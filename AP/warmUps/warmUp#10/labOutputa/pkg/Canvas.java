//HIDE
//OUT canvas.png
package pkg;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Canvas
{
    private static Canvas canvas = new Canvas();

    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private BufferedImage background;
    public JFrame frame;
    private CanvasComponent component;

    private static final int MIN_SIZE = 100;
    private static final int MARGIN = 10;
    private static final int LOCATION_OFFSET = 120;

    class CanvasComponent extends JComponent
    {
        public void paintComponent(Graphics g)
        {
            g.setColor(java.awt.Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(java.awt.Color.BLACK);
            if (background != null)
            {
                g.drawImage(background, 0, 0, null);
            }
            for (Shape s : new ArrayList<Shape>(shapes))
            {
                Graphics2D g2 = (Graphics2D) g.create();
                /**
                    Added null check b/c I think the graphics
                    are rendered async, so when undrawing it
                    has a chance to try to render something
                    which doesnt exist.
                */
                if (s != null)
                {
                    s.paintShape(g2);
                }
                g2.dispose();
            }
        }

        public Dimension getPreferredSize()
        {
            int maxx = MIN_SIZE;
            int maxy = MIN_SIZE;
            if (background != null)
            {
                maxx = Math.max(maxx, background.getWidth());
                maxy = Math.max(maxx, background.getHeight());
            }
            for (Shape s : shapes)
            {
                maxx = (int) Math.max(maxx, s.getX() + s.getWidth());
                maxy = (int) Math.max(maxy, s.getY() + s.getHeight());
            }
			// changed by Neato to make Canvas the same size (600 x 600)
			return new Dimension(600,600);
            //return new Dimension(maxx + MARGIN, maxy + MARGIN);
        }
    }

    private Canvas()
    {
        component = new CanvasComponent();

        if (System.getProperty("com.horstmann.codecheck") == null)
        {
            frame = new JFrame();
            if (!System.getProperty("java.class.path").contains("bluej"))
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(component);
            frame.pack();
            frame.setLocation(LOCATION_OFFSET, LOCATION_OFFSET);
            frame.setVisible(true);
        }
        else
        {
            final String SAVEFILE = "canvas.png";
            final Thread currentThread = Thread.currentThread();
            Thread watcherThread = new Thread()
                {
                    public void run()
                    {
                        try
                        {
                            final int DELAY = 10;

                            while (currentThread.getState() != Thread.State.TERMINATED)
                            {
                                Thread.sleep(DELAY);
                            }
                            saveToDisk(SAVEFILE);
                        }
                        catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }
                    }
                };
            watcherThread.start();
        }
    }

    public static Canvas getInstance()
    {
        return canvas;
    }

    public void show(Shape s)
    {
        if (!shapes.contains(s))
        {
            shapes.add(s);
        }
        repaint();
    }

	public void unshow(Shape s)
	{
		if (shapes.contains(s)) {
			shapes.remove(s);
		}
		repaint();
	}

    public void repaint()
    {
        if (frame == null) return;
        Dimension dim = component.getPreferredSize();
        if (dim.getWidth() > component.getWidth()
                || dim.getHeight() > component.getHeight())
        {
            frame.pack();
        }
        else
        {
            frame.repaint();
        }
    }

    /**
     * Pauses so that the user can see the picture before it is transformed.
     */
   // invented by Dylan sometime academic year 18'-19'
	public static void pause(int td)
	{
	  try {
		Thread.sleep(td);
	  } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	  }
	}
	// made by Neato in summer 2019 rework of AREPOS

    public static int rand(int r)
	{
	  return (int)(Math.random()*r);
	}

    /**
     * Takes a snapshot of the screen, fades it, and sets it as the background.
     */
    public static void snapshot()
    {
        Dimension dim = getInstance().component.getPreferredSize();
        java.awt.Rectangle rect = new java.awt.Rectangle(0, 0, dim.width, dim.height);
        BufferedImage image = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(java.awt.Color.WHITE);
        g.fillRect(0, 0, rect.width, rect.height);
        g.setColor(java.awt.Color.BLACK);
        getInstance().component.paintComponent(g);
        float factor = 0.8f;
        float base = 255f * (1f - factor);
        RescaleOp op = new RescaleOp(factor, base, null);
        BufferedImage filteredImage
           = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        op.filter(image, filteredImage);
        getInstance().background = filteredImage;
        getInstance().component.repaint();
    }

    public void saveToDisk(String fileName)
    {
        Dimension dim = component.getPreferredSize();
    	java.awt.Rectangle rect = new java.awt.Rectangle(0, 0, dim.width, dim.height);
    	BufferedImage image = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(java.awt.Color.WHITE);
        g.fill(rect);
        g.setColor(java.awt.Color.BLACK);
        component.paintComponent(g);
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
        try
        {
            ImageIO.write(image, extension, new File(fileName));
        }
        catch(IOException e)
        {
            System.err.println("Was unable to save the image to " + fileName);
        }
    	g.dispose();
    }
}
