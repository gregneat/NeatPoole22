
package pkg;

public class Emoji
{
    private double x;
    private double y;
    private double width;
    private double height;
	
	private Ellipse Ethan;
	private Ellipse Kobe;
	private Ellipse Shaq;
	private Ellipse Bob;
	private Rectangle Sped;
	private Rectangle Jill;
	private Ellipse Sushi;
	private Ellipse Ball;

    /**
       Constructs an empty rectangle.
    */
    public Emoji()
    {
        x = 0;
        y = 0;
        width = 100;
        height = 100;


		Ethan = new Ellipse(x,y,(int)(width),(int)(height));
		
		Kobe = new Ellipse(x+(int)(width*1.0/5.0),y+(int)(height*1.0/5.0),(int)(width*13.0/50.0),(int)(height*13.0/50.0));
		
		Shaq = new Ellipse(x+(int)(width*27.0/50.0),y+(int)(height*1.0/5.0),(int)(width*13.0/50.0),(int)(height*13.0/50.0));
		
		Bob = new Ellipse(x+(int)(width*1.0/5.0),y+(int)(height*3.0/5.0),(int)(width*3.0/5.0),(int)(height*1.0/5.0));
		
		Sped = new Rectangle(x+(int)(width*12.0/50.0),y+(int)(height*1.0/5.0),(int)(width*9.0/50.0),(int)(height*1.0/25.0));
		
		Jill = new Rectangle(x+(int)(width*3.0/5.0),y+(height*1.0/5.0),(int)(width*9.0/50.0),(int)(height*1.0/25.0));
        
		Sushi = new Ellipse(x+(int)(width*3.0/10.0),y+(int)(height*3.0/10.0),(int)(width*3.0/25.0),(int)(height*3.0/25.0));
		
		Ball = new Ellipse(x+(int)(width*3.0/5.0),y+(int)(height*3.0/10.0),(int)(width*3.0/25.0),(int)(height*3.0/25.0));
    }       

    /**
       Constructs an Emoji.
       @param x the leftmost x-coordinate
       @param y the topmost y-coordinate
       @param width the width
       @param height the height
    */
    public Emoji(double x, double y, double width, double height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
		
		
		Ethan = new Ellipse(x,y,width,height);
		
		Kobe = new Ellipse(x+width*1.0/5.0,y+height*1.0/5.0,width*13.0/50.0,height*14.0/50.0);
		
		Shaq = new Ellipse(x+width*27.0/50.0,y+height*1.0/5.0,width*13.0/50.0,height*14.0/50.0);

		Bob = new Ellipse(x+width*1.0/5.0,y+height*3.0/5.0,width*3.0/5.0,height*1.0/5.0);
		
		Sped = new Rectangle(x+width*12.0/50.0,y+height*1.0/5.0,width*9.0/50.0,height*1.0/25.0);
		
		Jill = new Rectangle(x+width*3.0/5.0,y+height*1.0/5.0,width*9.0/50.0,height*1.0/25.0);
        
		Sushi = new Ellipse(x+width*3.0/10.0,y+height*3.0/10.0,width*3.0/25.0,height*3.0/25.0);
		
		Ball = new Ellipse(x+width*3.0/5.0,y+height*3.0/10.0,width*3.0/25.0,height*3.0/25.0);
    }

    /**
       Gets the leftmost x-position of this Emoji.
       @return the leftmost x-position
    */
    public int getX()
    {
        return Ethan.getX();
    }

    /**
       Gets the topmost y-position of this Emoji.
       @return the topmost y-position
    */
    public int getY()
    {
        return Ethan.getY();
    }

    /**
       Gets the width of this Emoji.
       @return the width
    */    
    public int getWidth()
    {
        return Ethan.getWidth();
    }

    /**
       Gets the height of this Emoji.
       @return the height
    */    
    public int getHeight()
    {
        return Ethan.getHeight();
    }

    /**
       Moves this Emoji by a given amount.
       @param dx the amount by which to move in x-direction
       @param dy the amount by which to move in y-direction
    */
    public void translate(double dx, double dy)
    {
        Ethan.translate(dx, dy);
		x = Ethan.getX();
		y = Ethan.getY();
		Kobe.translate(dx, dy);
		Shaq.translate(dx, dy);
		Bob.translate(dx, dy);
		Sped.translate(dx, dy);
		Jill.translate(dx, dy);
		Sushi.translate(dx, dy);
		Ball.translate(dx, dy);
    }

    /**
       Resizes this Emoji both horizontally and vertically.
       @param dw the amount by which to resize the width on each side
       @param dw the amount by which to resize the height on each side
    */
    public void grow(double dw, double dh)
    {
		Ethan.grow(dw, dh);
		x = Ethan.getX();
		y = Ethan.getY();
		height = Ethan.getHeight();
		width = Ethan.getWidth();
		Kobe.translate(x+width*1.0/5.0-Kobe.getX(),y+(height)*1.0/5.0-Kobe.getY());
		Kobe.grow(dw*13.0/50.0,dh*13.0/50.0);
		Shaq.translate(x+width*27.0/50.0-Shaq.getX(),y+(height)*1.0/5.0-Shaq.getY());
		Shaq.grow(dw*13.0/50.0,dh*13.0/50.0);
		Bob.translate(x+width*1.0/5.0-Bob.getX(),y+height*3.0/5.0-Bob.getY());
		Bob.grow(dw*3.0/5.0,dh*1.0/5.0);
		Sped.translate(x+width*12.0/50.0-Sped.getX(),y+height*1.0/5.0-Sped.getY());
		Sped.grow(dw*9.0/50.0,dh*1.0/25.0);
		Jill.translate(x+width*3.0/5.0-Jill.getX(), y+height*1.0/5.0-Jill.getY());
		Jill.grow(dw*9.0/50.0, dh*1.0/25.0);
		Sushi.translate(x+width*3.0/10.0-Sushi.getX(),y+height*3.0/10.0-Sushi.getY());
		Sushi.grow(dw*3.0/25.0,dh*3.0/25.0);
		Ball.translate(x+width*3.0/5.0-Ball.getX(),y+height*3.0/10.0-Ball.getY());
		Ball.grow(dw*3.0/25.0,dh*3.0/25.0);
    }

    /**
       Fills this Emoji.
    */
    public void fill()
    {
	Ethan.fill();
	Color Ethan2 = new Color(244,229,66);
	Ethan.setColor(Ethan2);
	Kobe.fill();
	Color Kobe2 = new Color(255,255,255);
	Kobe.setColor(Kobe2);
	Shaq.fill();
	Color Shaq2 = new Color(255,255,255);
	Shaq.setColor(Shaq2);
	Bob.fill();
	Color Bob2 = new Color(229,36,36);
	Bob.setColor(Bob2);
	Sped.fill();
	Jill.fill();
	Sushi.fill();
	Ball.fill();	
    }
	
	// added by Neato 10/21/18

	public boolean crash(Car v)
	{
		if(Ethan.contains(v.getBoundBox()))
		{
			return true;
		}
		return false;
	}
   

   
}
