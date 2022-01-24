import pkg.*;

public class Background{
	private Rectangle border;
	private Rectangle nextPiece;
	private Rectangle scoreBorder;
	private Rectangle onHoldBorder;
	private Text score;
	private Text next;
	private Text onHold;
	private double digitWidth;
	private int scoreBound = 10;
	public Background(){
		border = new Rectangle(0,0,300,600);
		nextPiece = new Rectangle(300,0,200,200);
		scoreBorder = new Rectangle(300,400,200,200);
		onHoldBorder = new Rectangle(300,200,200,200);
		score = new Text(400,500,"0");
		next = new Text(385,5,"Next");
		onHold = new Text(385,205,"On Hold");
		score.grow(score.getWidth(),score.getHeight());
		digitWidth = score.getWidth();
	}
	public void draw(){
		border.draw();
		nextPiece.draw();
		scoreBorder.draw();
		onHoldBorder.draw();
		score.draw();
		next.draw();
		onHold.draw();
	}
	public void updateScore(int s){
		if(s>=scoreBound)
		{
			score.grow(digitWidth/2,0);
			scoreBound*=10;
		}
		score.setText(Integer.toString(s));
		score.setPosition(400,500);
	}
}
