import pkg.*;

public class Block{
	private int xCenter;
	private int yCenter;
	private int x;
	private int y;
	private Rectangle hitBox;
	private Rectangle outline;
	private int[] positionVals = new int[4];
	public static final int blockSize = 30;
	private Color hitBoxColor;
	private Color outlineColor;
	public Block(int x, int y){
		hitBox = new Rectangle(x,y,blockSize,blockSize);
		outline = new Rectangle(x,y,blockSize,blockSize);
		this.x=x;
		this.y=y;
		xCenter=x;
		yCenter=y;
	}
	public Block(int x, int y, int[] vals){
		this(x,y);
		positionVals = vals;
		x+=vals[1]*blockSize-vals[3]*blockSize;
		y+=vals[2]*blockSize-vals[0]*blockSize;
		hitBox.setPosition(x,y);
		outline.setPosition(x,y);
	}
	public void draw(){
		hitBox.fill();
		outline.draw();
	}
	public void undraw(){
		hitBox.undraw();
		outline.undraw();
	}
	public void setColor(Color c){
		hitBox.setColor(c);
		hitBoxColor = c;
		if(outlineColor==null)
		{
			outlineColor = new Color(0,0,0);
		}
	}
	public void setOutlineColor(Color c){
		outline.setColor(c);
		outlineColor = c;
	}
	public Color getColor(){
		return hitBoxColor;
	}
	public Color getOutlineColor(){
		return outlineColor;
	}
	public void rotate(int a){
		int[] copy = new int[4];
		for(int i = 0; i<a; i++)
		{
			for(int b = 0; b<4; b++)
			{
				copy[b] = positionVals[b];
			}
			for(int b = 1; b<4; b++)
			{
				positionVals[b] = copy[b-1];
			}
			positionVals[0] = copy[3];
		}
		x=xCenter+positionVals[1]*blockSize-positionVals[3]*blockSize;
		y=yCenter+positionVals[2]*blockSize-positionVals[0]*blockSize;
		hitBox.setPosition(x,y);
		outline.setPosition(x,y);
	}
	public void translate(int dx, int dy){
		hitBox.translate(dx,dy);
		outline.translate(dx,dy);
		x+=dx;
		y+=dy;
		xCenter+=dx;
		yCenter+=dy;
	}
	public void setPosition(int X, int Y){
		hitBox.setPosition(X,Y);
		outline.setPosition(X,Y);
		x=X;
	}
	public int getX(){
		return hitBox.getX();
	}
	public int getY(){
		return hitBox.getY();
	}
}
