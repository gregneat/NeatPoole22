import pkg.*;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
public class starter implements InputControl, InputKeyControl {
	public static Piece current;
	public static Piece next;
	public static Piece onHold;
	public static Piece projection;
	public static ArrayList<Block> usedPieces = new ArrayList<>();
	public static int[] pieceOdds = new int[]{1,1,1,1,1,1,1};
	public static int score = 0;
	public static boolean gameOver = false;
	public static double gameSpeed = 1;
	public static Text nameInput;
	public static boolean nameGiven = false;
	public static Line inputLine;
	public static Text tetris;
	public static boolean hardDown = false;
	public static boolean onHoldUsed = false;
	
	public static void main(String args[]) {
		KeyController kC = new KeyController(Canvas.getInstance(),new starter());
		MouseController mC = new MouseController(Canvas.getInstance(),new starter());
		
		Canvas.getInstance().changeIcon("Tetris_Icon.png");
		AudioPlayer music = new AudioPlayer();
		music.play("Tetris_Music.wav");
		projection = new Piece(150,-30,pickPiece(),3);
		current = new Piece(150,-30,projection.pieceValue());
		next = new Piece(400-Block.blockSize,100-Block.blockSize,pickPiece());
		projection.draw();
		current.draw();
		projectPosition();
		next.draw();
		Background background = new Background();
		background.draw();
		tetris = new Text(150,300,"TETRIS!");
		tetris.grow(tetris.getWidth(),tetris.getHeight());
		tetris.setPosition(150-tetris.getWidth()/4,300-tetris.getHeight()/4);
		tetris.draw();
		outer:
		while(true)
		{
			current.translate(0,Block.blockSize);
			Canvas.pause((int)(400/gameSpeed));
			if(current.isOnBottom(usedPieces))
			{
				for(int i = 0; i<current.getBlocks().length; i++)
				{
					usedPieces.add(current.getBlocks()[i]);
				}
				projection.undraw();
				projection = new Piece(150,-30,next.pieceValue(),3);
				current = new Piece(150,-30,next.pieceValue());
				if(current.contains(usedPieces))
				{
					gameOver = true;
					break outer;
				}
				projection.draw();
				current.draw();
				projectPosition();
				next.undraw();
				next = new Piece(400-Block.blockSize/2,100-Block.blockSize/2,pickPiece());
				next.draw();
				gameSpeed+=0.01;
				hardDown=false;
				onHoldUsed = false;
			}
			if(tetris.isDrawn())
			{
				tetris.undraw();
			}
			checkRows();
			background.updateScore(score);
		}
		music.pause();
		music.play("results.wav");
		Rectangle endOfGame = new Rectangle(50,50,400,500);
		Rectangle border = new Rectangle(50,50,400,500);
		Text gameOverMessage = new Text(250,100,"GAME OVER");
		Text scoreMessage = new Text(250,150,Integer.toString(score));
		scoreMessage.grow(scoreMessage.getWidth()/1.5,scoreMessage.getHeight()/2);
		gameOverMessage.grow(gameOverMessage.getWidth(),gameOverMessage.getHeight());
		Text highScoreSubmission = new Text(250,200,"Please enter name in console to submit score to leaderboard");
		gameOverMessage.setPosition(250-gameOverMessage.getWidth()/4,100-gameOverMessage.getHeight()/4);
		scoreMessage.setPosition(250-scoreMessage.getWidth()/4,150-scoreMessage.getHeight()/3);
		highScoreSubmission.translate(-highScoreSubmission.getWidth()/2,-highScoreSubmission.getHeight()/2);
		Text charCountWarning = new Text(250,220,"Maximum of 10 characters");
		charCountWarning.translate(-charCountWarning.getWidth()/2,-charCountWarning.getHeight()/2);
		endOfGame.fill();
		border.draw();
		endOfGame.setColor(Color.WHITE);
		gameOverMessage.draw();
		scoreMessage.draw();
		highScoreSubmission.draw();
		charCountWarning.draw();
		nameInput = new Text(250,400,"");
		nameInput.draw();
		inputLine = new Line(200,410,300,410);
		inputLine.draw();
		scoreBoard();
	}
	
	public static void projectPosition(){
		projection.translate(current.getX()-projection.getX(),current.getY()-projection.getY());
		while(!projection.isOnBottom(usedPieces))
		{
			projection.translate(0,30);
		}
	}
	
	public static void scoreBoard(){
		while(true)
		{
			if(nameGiven)
				break;
			Canvas.pause(1);
		}
		String name = nameInput.getText();
		try 
		{
			FileWriter myWriter = new FileWriter("Scores.txt",true);
			myWriter.write(name + ";" + score + "\n");
			myWriter.close();
		} catch (IOException e){}
		EasyReader scoreReader = new EasyReader("Scores.txt");
		int lineNumber = 0;
		while(!scoreReader.eof())
		{
			scoreReader.readLine();
			lineNumber++;
		}
		int[] scores = new int[lineNumber];
		String[] names = new String[lineNumber];
		scoreReader = new EasyReader("Scores.txt");
		for(int i = 0; i<lineNumber; i++)
		{
			name = scoreReader.readLine();
			names[i] = name.substring(0,name.indexOf(";"));
			scores[i] = Integer.parseInt(name.substring(name.indexOf(";")+1));
		}
		Sorter.radixsort(scores,names);
		System.out.println("Current Leaderboard:");
		for(int i = lineNumber-1; i>-1; i--)
		{
			System.out.print(lineNumber-i + ". ");
			System.out.print(names[i] + "   ");
			System.out.println(scores[i]);
		}
		Text[] topScorers = new Text[10];
		Text[] topScores = new Text[10];
		for(int i = 0; i<lineNumber; i++)
		{
			String temp;
			if(names[names.length-i-1].length()>10)
			{
				temp = names[names.length-i-1].substring(0,10);
			}
			else{
				temp = names[names.length-i-1];
				for(int sp = 0; sp<10-temp.length(); sp++)
				{
					temp = temp + " ";
				}
			}
			topScorers[i] = new Text(135,250+i*15,i+1 +". "  +  temp);
			topScores[i] = new Text(275,250+i*15,Integer.toString(scores[scores.length-i-1]));
		}
		for(int i = 0; i<lineNumber; i++)
		{
			topScorers[i].draw();
			topScores[i].draw();
		}
		nameInput.translate(-600,-600);
		inputLine.translate(-600,-600);
		int playerRank = scores.length;
		for(int i = 0; i<scores.length; i++)
		{
			if(scores[i]==score)
			{
				playerRank = scores.length-i;
				break;
			}
		}
		if(playerRank>9)
		{
			String temp = nameInput.getText();
			if(nameInput.getText().length()>10)
			{
				temp = nameInput.getText().substring(0,10);
			}
			Text player = new Text(135,410,playerRank + ". " + temp);
			Text playerScore = new Text(275,410,Integer.toString(score));
			playerScore.draw();
			player.draw();
		}
	}
	
	public static int pickPiece(){
		int total = 0;
		for(int i = 0; i<pieceOdds.length; i++)
		{
			total+=pieceOdds[i];
		}
		total = (int)(Math.random()*total);
		for(int i = 0; i<pieceOdds.length; i++)
		{
			total -= pieceOdds[i];
			if(total<=0)
			{
				for(int a = 0; a<pieceOdds.length; a++)
				{
					pieceOdds[a] += 1;
				}
				pieceOdds[i] = 0;
				return i+1;
			}
		}
		return 1;
	}
	
	public static boolean rowFull(int row){
		boolean[] rowOne = new boolean[10];
		for(int b = 0; b<usedPieces.size(); b++)
		{
			if(usedPieces.get(b).getY()==600-row*Block.blockSize)
			{
				rowOne[usedPieces.get(b).getX()/30] = true;
			}
		}
		for(int i = 0; i<10; i++)
		{
			if(!rowOne[i])
			{
				return false;
			}
		}
		return true;
	}
	
	public static void checkRows(){
		int numRowsFull = 0;
		boolean rowIsGone[] = new boolean[20];
		for(int row = 1; row<20; row++)
		{
			if(rowFull(row))
			{
				numRowsFull++;
				rowIsGone[row] = true;
				for(int b = 0; b<usedPieces.size(); b++)
				{
					if(usedPieces.get(b).getY()==600-row*Block.blockSize)
					{
						usedPieces.get(b).undraw();
						usedPieces.remove(b);
						b--;
					}
				}
			}
		}
		if(numRowsFull==4)
		{
			tetris.draw();
			score+=2400*gameSpeed;
		}
		else if(numRowsFull==3)
		{
			score+=600*gameSpeed;
		}
		else if(numRowsFull==2)
		{
			score+=200*gameSpeed;
		}
		else if(numRowsFull==1)
		{
			score+=80*gameSpeed;
		}
		dropRows(rowIsGone);
		projectPosition();
	}
	
	public static void dropRows(boolean[] rowIsGone){
		int offValue = 0;
		for(int row = 1; row<20; row++)
		{
			if(rowIsGone[row])
			{
				for(int b = 0; b<usedPieces.size(); b++)
				{
					if(usedPieces.get(b).getY()<=600-(row-offValue+1)*Block.blockSize)
					{
						usedPieces.get(b).translate(0,30);
					}
				}
				for(int r = row; r<rowIsGone.length-1; r++)
				{
					rowIsGone[r] = rowIsGone[r+1];
				}
				rowIsGone[rowIsGone.length-1] = false;
				row--;
			}
		}
	}

	public void onMouseClick(double x, double y) {
		// enter code here
	}

	public void keyPress(String key) {
		// enter code here
		try{
		if(!gameOver)
		{
			if(!hardDown)
			{
				if(key.equalsIgnoreCase("a"))
				{
					if(!current.isOnLeft(usedPieces))
						current.translate(-Block.blockSize,0);
				}
				else if(key.equalsIgnoreCase("s"))
				{
					if(!current.isOnBottom(usedPieces))
					{
						current.translate(0,Block.blockSize);
						score+=1*gameSpeed;
					}
				}
				else if(key.equalsIgnoreCase("d"))
				{
					if(!current.isOnRight(usedPieces))
						current.translate(Block.blockSize,0);
				}
				else if(key.equalsIgnoreCase("q"))
				{
					projection.translate(current.getX()-projection.getX(),current.getY()-projection.getY());
					projection.rotate(usedPieces,3);
					current.rotate(usedPieces,3);
				}
				else if(key.equalsIgnoreCase("e"))
				{
					projection.translate(current.getX()-projection.getX(),current.getY()-projection.getY());
					projection.rotate(usedPieces,1);
					current.rotate(usedPieces,1);
				}
				else if(key.equalsIgnoreCase("w"))
				{
					while(!current.isOnBottom(usedPieces))
					{
						current.translate(0,Block.blockSize);
						score+=2*gameSpeed;
					}
					hardDown=true;
				}
				else
				{
					char shift1 = (char)14;
					char shift2 = (char)32;
					String s1 = Character.toString(shift1);
					String s2 = Character.toString(shift2);
					if(key.equals(Character.toString((char)32)))
					{
						if(!onHoldUsed)
						{
							onHoldUsed = true;
							if(onHold!=null)
							{
								int temp = current.pieceValue();
								current.undraw();
								current = new Piece(150,-30,onHold.pieceValue());
								onHold.undraw();
								onHold = new Piece(400-Block.blockSize/2,300-Block.blockSize/2,temp);
								current.draw();
								onHold.draw();
								projection.undraw();
								projection = new Piece(150,-30,current.pieceValue(),3);
								projection.draw();
							}
							else
							{
								projection.undraw();
								projection = new Piece(150,-30,next.pieceValue(),3);
								onHold = new Piece(400-Block.blockSize/2,300-Block.blockSize/2,current.pieceValue());
								current.undraw();
								current = new Piece(150,-30,next.pieceValue());
								projection.draw();
								current.draw();
								onHold.draw();
								projectPosition();
								next.undraw();
								next = new Piece(400-Block.blockSize/2,100-Block.blockSize/2,pickPiece());
								next.draw();
							}
						}
					}
				}
				projectPosition();
			}
		}
		else if(!nameGiven)
		{
			if(key.equalsIgnoreCase("a")||key.equalsIgnoreCase("b")||key.equalsIgnoreCase("c")||
			key.equalsIgnoreCase("d")||key.equalsIgnoreCase("e")||key.equalsIgnoreCase("f")||key.equalsIgnoreCase("g")||
			key.equalsIgnoreCase("h")||key.equalsIgnoreCase("i")||key.equalsIgnoreCase("j")||key.equalsIgnoreCase("k")||
			key.equalsIgnoreCase("l")||key.equalsIgnoreCase("m")||key.equalsIgnoreCase("n")||key.equalsIgnoreCase("o")||
			key.equalsIgnoreCase("p")||key.equalsIgnoreCase("q")||key.equalsIgnoreCase("r")||key.equalsIgnoreCase("s")||
			key.equalsIgnoreCase("t")||key.equalsIgnoreCase("u")||key.equalsIgnoreCase("v")||key.equalsIgnoreCase("w")||
			key.equalsIgnoreCase("x")||key.equalsIgnoreCase("y")||key.equalsIgnoreCase("z")||key.equalsIgnoreCase("1")||
			key.equalsIgnoreCase("2")||key.equalsIgnoreCase("3")||key.equalsIgnoreCase("4")||key.equalsIgnoreCase("5")||
			key.equalsIgnoreCase("6")||key.equalsIgnoreCase("7")||key.equalsIgnoreCase("8")||key.equalsIgnoreCase("9")||
			key.equalsIgnoreCase("0")||key.equalsIgnoreCase("!")||key.equalsIgnoreCase("@")||key.equalsIgnoreCase("#")||
			key.equalsIgnoreCase("$")||key.equalsIgnoreCase("%")||key.equalsIgnoreCase("^")||key.equalsIgnoreCase("&")||
			key.equalsIgnoreCase("*")||key.equalsIgnoreCase("(")||key.equalsIgnoreCase(")")||key.equalsIgnoreCase("-")||
			key.equalsIgnoreCase("_")||key.equalsIgnoreCase("+")||key.equalsIgnoreCase("=")||key.equalsIgnoreCase("{")||
			key.equalsIgnoreCase("}")||key.equalsIgnoreCase("|")||key.equalsIgnoreCase("[")||key.equalsIgnoreCase("]")||
			key.equalsIgnoreCase("\\")||key.equalsIgnoreCase(":")||key.equalsIgnoreCase("\"")||
			key.equalsIgnoreCase("'")||key.equalsIgnoreCase("<")||key.equalsIgnoreCase(">")||key.equalsIgnoreCase("?")||
			key.equalsIgnoreCase(",")||key.equalsIgnoreCase(".")||key.equalsIgnoreCase("/")||key.equalsIgnoreCase("`")||
			key.equalsIgnoreCase("~")||key.equalsIgnoreCase(" "))
			{
				if(nameInput.getText().length()<10)
				{
					nameInput.setText(nameInput.getText() + key);
					nameInput.setPosition(250-nameInput.getWidth()/2,400-nameInput.getHeight()/2);
				}
			}
			char enter = (char)10;
			String temp1 = Character.toString(enter);
			char backSpace = (char)8;
			String temp2 = Character.toString(backSpace);
			if(key.equals(temp1))
			{
				nameGiven = true;
			}
			if(key.equals(temp2))
			{
				if(nameInput.getText().length()>0)
				{
					nameInput.setText(nameInput.getText().substring(0,nameInput.getText().length()-1));
				}
				nameInput.setPosition(250-nameInput.getWidth()/2,400-nameInput.getHeight()/2);
			}
		}
		}catch(Exception e){}
	}
}