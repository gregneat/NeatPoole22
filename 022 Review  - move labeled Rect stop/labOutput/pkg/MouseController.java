package pkg;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseController{

    private Canvas c = null;
    private InputControl iC;

    public MouseController(Canvas c, InputControl iC){
        this.c = c;
        this.iC = iC;
        // System.out.println("Mouse Started");
        handleClick();
    }

    private void handleClick(){
        this.c.frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x=e.getX();
                int y=e.getY();
                iC.onMouseClick(x,y);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

}