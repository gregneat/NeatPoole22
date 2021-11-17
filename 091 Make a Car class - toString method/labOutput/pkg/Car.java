//HIDE
package pkg;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Car
{
    private Color color = Color.BLACK;
	private Color carColor;
	private int sp;
    private boolean filled = false;
    private double x;
    private double y;
    private double width;
    private int height;
	private Rectangle body;
	private Ellipse wh1;
	private Ellipse wh2;
	private Text label;
	private Text locLabel;
	private String s;
	private Rectangle bBox;

    /**
       Constructs a rectangle.
       @param x the leftmost x-coordinate
       @param y the topmost y-coordinate
       @param width the width
       @param height the height
    */
    public Car(double x, double y)
    {
		height = 60+30;
		body = new Rectangle(x,y, 100,60);
		body.fill();
		body.setColor(Color.RED);
		wh1 = new Ellipse(x+10,y+body.getHeight()-15,30,30);
		wh1.setColor(Color.BLACK);
		wh1.fill();
		wh2 = new Ellipse(x+60,y+body.getHeight()-15,30,30);
		wh2.setColor(Color.BLACK);
		wh2.fill();
		bBox = new Rectangle(x,y,body.getWidth(),body.getHeight()+wh1.getHeight()/2);
		// bBox.draw();
        this.x = x;
        this.y = y;
		sp = 4;
		s = "";
		label = new Text(0,0,"");
		locLabel = new Text(0,0,"");
			
    }
	public Car(double x, double y, String n)
    {
		this(x,y);
		Text dummyZ = new Text(0,0,n);
		double tx = x+bBox.getWidth()/2 - dummyZ.getWidth()/2;
		double ty = y+bBox.getHeight()/2- dummyZ.getHeight()/2;
		label = new Text(tx,ty,n);
		//label = new Text(x+35,y+25,n);
		label.setColor(Color.WHITE);
		// label.grow(10,10);
		label.draw();
		locLabel = new Text(x+35,y+45,getX()+", "+getY());
		locLabel.setColor(Color.WHITE);
		// locLabel.draw();
		s=n;
    }
	public Car(double x, double y, String n, Color c)
    {
		this(x,y,n);
		carColor = c;
		body.setColor(c);
		body.fill();
    }
	public Car(double x, double y, String n, Color c, int s)
    {
		this(x,y,n,c);
		sp = s;
    }
	public void translate(double ex, double why)
	{
		body.translate(ex,why);
		wh1.translate(ex,why);
		wh2.translate(ex,why);
		label.translate(ex,why);
		locLabel.setText(getX()+", "+getY());
		locLabel.translate(ex,why);
		bBox.translate(ex,why);
	}
	public void drive()
	{
		if(getX() > 700)
		{
			translate(-900,115);
		}
		else if(getY() > 600)
		{
			translate(0,-getY()+5);
		}
		else
		{
			translate(sp,0);
		}
	}
	public void driveRandom()
	{
		translate(sp,0);
		if(getX() > 700)
		{
			// if(getY() > 600 || getY() < 0)
			// {
				// int back = e.getHeight()+fudge+5
				translate(-1000+Canvas.rand(300),0);
			// }
			// if(getY() > 600)
			// {
				// translate(-900,-getY());
			// }
			// else if(getY() < 0)
			// {
				// translate(-900,-getY());
			// }
			// else
			// {
				// translate(-900,-115 + Canvas.rand(3)*115);
			// }
		}
	}
	public int getX()
	{
		return body.getX();
	}
	
	public int getY()
	{
		return body.getY();
	}
	public int getStep()
	{
		return sp;
	}
	public void setStep(int st)
	{
		sp = st;
	}
	public int getHeight()
    {
        return height;
    }
	public int getWidth()
    {
        return bBox.getWidth();
    }
	public Rectangle getBoundBox()
	{
		return bBox;
	}
	public String getName()
	{
		return s;
	}
    public String toString()
	{
		String temp = "Car "+ s + " starts at " + x + ", "+ y +  " and is going " + sp + " mph.";
		return temp;
	}
    

 

    // /**
       // Resizes this rectangle both horizontally and vertically.
       // @param dw the amount by which to resize the width on each side
       // @param dw the amount by which to resize the height on each side
    // */
    // public void grow(double dw, double dh)
    // {
        // width += 2 * dw;
        // height += 2 * dh;
        // x -= dw;
        // y -= dh;
        // Canvas.getInstance().repaint();
    // }

    // /**
       // Sets the color of this rectangle.
       // @param newColor the new color
    // */
    // public void setColor(Color newColor)
    // {
        // color = newColor;
        // Canvas.getInstance().repaint();
    // }

    // /**
       // Draws this rectangle.
    // */
    // public void draw()
    // {
        // filled = false;
        // Canvas.getInstance().show(this);
    // }

    // /**
       // Fills this rectangle.
    // */
    // public void fill()
    // {
        // filled = true;
        // Canvas.getInstance().show(this);
    // }

    // public String toString()
    // {
        // return "Rectangle[x=" + getX() + ",y=" + getY() + ",width=" + getWidth() + ",height=" + getHeight() + "]";
    // }

    // public void paintShape(Graphics2D g2)
    // {
        // Rectangle2D.Double rect = new Rectangle2D.Double(getX(), getY(),
                // getWidth(), getHeight());
        // g2.setColor(new java.awt.Color((int) color.getRed(), (int) color.getGreen(), (int) color.getBlue()));
        // if (filled)
        // {
            // g2.fill(rect);
        // }
        // else
        // {
            // g2.draw(rect);
        // }
    // }
}
