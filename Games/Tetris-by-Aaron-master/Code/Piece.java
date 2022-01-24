import pkg.*;
import java.util.ArrayList;
public class Piece{
	private int[][] values;
	private Block[] blocks = new Block[4];
	private int pieceVal;
	private boolean drawn = false;
	private Color[] pieceColors = new Color[]{
		new Color(125,249,255),//cyan
		new Color(0,0,255),//blue
		new Color(242,140,40),//orange
		new Color(251,250,0),//yellow
		new Color(238,75,43),//green
		new Color(13,235,80),//red
		new Color(150,10,170)//purple
	};
	public Piece(int x, int y, int pNum){
		pieceVal=pNum;
		if(pNum==1)
			pieceOne(x,y);
		else if(pNum==2)
			pieceTwo(x,y);
		else if(pNum==3)
			pieceThree(x,y);
		else if(pNum==4)
			pieceFour(x,y);
		else if(pNum==5)
			pieceFive(x,y);
		else if(pNum==6)
			pieceSix(x,y);
		else if(pNum==7)
			pieceSeven(x,y);
		for(int i = 0; i<4; i++)
		{
			blocks[i] = new Block(x,y,values[i]);
			blocks[i].setColor(pieceColors[pNum-1]);
		}
	}
	
	public Piece(int x, int y, int pNum, int fade){
		this(x,y,pNum);
		for(int i = 0; i<blocks.length; i++)
		{
			blocks[i].setColor(new Color(255-255/fade+blocks[i].getColor().getRed()/fade,255-255/fade+blocks[i].getColor().getGreen()/fade,255-255/fade+blocks[i].getColor().getBlue()/fade));
			blocks[i].setOutlineColor(new Color(255-255/fade+blocks[i].getOutlineColor().getRed()/fade,255-255/fade+blocks[i].getOutlineColor().getGreen()/fade,255-255/fade+blocks[i].getOutlineColor().getBlue()/fade));
		}
	}
	//{piece construction methods
	//I piece
	private void pieceOne(int x, int y){
		values = new int[][]{
			{0,0,0,0},
			{1,0,0,0},
			{2,0,0,0},
			{0,0,1,0},
		};
	}
	//J piece
	private void pieceTwo(int x, int y){
		values = new int[][]{
			{0,0,0,0},
			{0,0,0,1},
			{1,0,0,1},
			{0,1,0,0},
		};
	}
	// L piece
	private void pieceThree(int x, int y){
		values = new int[][]{
			{0,0,0,0},
			{0,0,0,1},
			{1,1,0,0},
			{0,1,0,0},
		};
	}
	//O piece
	private void pieceFour(int x, int y){
		values = new int[][]{
			{0,0,0,0},
			{0,1,0,0},
			{1,1,0,0},
			{1,0,0,0},
		};
	}
	//S piece
	private void pieceFive(int x, int y){
		values = new int[][]{
			{0,0,0,0},
			{0,0,0,1},
			{1,1,0,0},
			{1,0,0,0},
		};
	}
	//Z piece
	private void pieceSix(int x, int y){
		values = new int[][]{
			{0,0,0,0},
			{0,1,0,0},
			{1,0,0,0},
			{1,0,0,1},
		};
	}
	//T piece
	private void pieceSeven(int x, int y){
		values = new int[][]{
			{0,0,0,0},
			{0,1,0,0},
			{1,0,0,0},
			{0,0,0,1},
		};
	}
	//}
	public void draw(){
		for(int i = 0; i<blocks.length; i++)
		{
			blocks[i].draw();
		}
		drawn = true;
	}
	public void undraw(){
		for(int i = 0; i<blocks.length; i++)
		{
			blocks[i].undraw();
		}
		drawn = false;
	}
	public boolean isDrawn(){
		return drawn;
	}
	private void smallRotate(int angle){
		if(pieceVal!=4)
		{
			for(int i = 0; i<blocks.length; i++)
			{
				blocks[i].rotate(angle);
			}
		}
	}
	public void translate(int dx, int dy){
		for(int i = 0; i<blocks.length; i++)
		{
			blocks[i].translate(dx,dy);
		}
	}
	public void setPosition(int X, int Y){
		for(int i = 0; i<blocks.length; i++)
		{
			blocks[i].setPosition(X,Y);
		}
	}
	public int getX(){
		return blocks[0].getX();
	}
	public int getY(){
		return blocks[0].getY();
	}
	public Block[] getBlocks(){
		return blocks;
	}
	public int pieceValue(){
		return pieceVal;
	}
	//{ sensing methods
	public boolean isOnBottom(ArrayList<Block> usedPieces){
		for(int a = 0; a<blocks.length; a++)
		{
			if(blocks[a].getY()>=600-Block.blockSize)
			{
				return true;
			}
			for(int i = 0; i<usedPieces.size(); i++)
			{
				if(usedPieces.get(i).getY()-30==blocks[a].getY()&&usedPieces.get(i).getX()==blocks[a].getX())
				{
					return true;
				}
			}
		}
		return false;
	}
	public boolean isOnRight(ArrayList<Block> usedPieces){
		for(int a = 0; a<blocks.length; a++)
		{
			if(blocks[a].getX()>=300-Block.blockSize)
			{
				return true;
			}
			for(int i = 0; i<usedPieces.size(); i++)
			{
				if(usedPieces.get(i).getY()==blocks[a].getY()&&usedPieces.get(i).getX()==blocks[a].getX()+30)
				{
					return true;
				}
			}
		}
		return false;
	}
	public boolean isOnLeft(ArrayList<Block> usedPieces){
		for(int a = 0; a<blocks.length; a++)
		{
			if(blocks[a].getX()<=0)
			{
				return true;
			}
			for(int i = 0; i<usedPieces.size(); i++)
			{
				if(blocks[a].getX()==0)
				{
					return true;
				}
				if(usedPieces.get(i).getY()==blocks[a].getY()&&usedPieces.get(i).getX()==blocks[a].getX()-30)
				{
					return true;
				}
			}
		}
		return false;
	}
	public boolean contains(ArrayList<Block> usedPieces)
	{
		for(int a = 0; a<blocks.length; a++)
		{
			for(int i = 0; i<usedPieces.size(); i++)
			{
				if(blocks[a].getX()==usedPieces.get(i).getX()&&blocks[a].getY()==usedPieces.get(i).getY())
				{
					return true;
				}
			}
		}
		return false;
	}
	public boolean contains(Block[] usedPieces)
	{
		for(int a = 0; a<blocks.length; a++)
		{
			for(int i = 0; i<usedPieces.length; i++)
			{
				if(blocks[a].getX()==usedPieces[i].getX()&&blocks[a].getY()==usedPieces[i].getY())
				{
					return true;
				}
			}
		}
		return false;
	}
	//}
	public void rotate(ArrayList<Block> usedPieces, int r){
		smallRotate(r);
		outerloop:
		for(int a = 0; a<blocks.length; a++)
		{
			if(blocks[a].getX()<0||blocks[a].getX()>=300||blocks[a].getY()>=600)
			{
				smallRotate(4-r);
				break;
			}
			for(int i = 0; i<usedPieces.size(); i++)
			{
				if(blocks[a].getX()==usedPieces.get(i).getX()&&blocks[a].getY()==usedPieces.get(i).getY())
				{
					smallRotate(4-r);
					break outerloop;
				}
			}
		}
	}
}