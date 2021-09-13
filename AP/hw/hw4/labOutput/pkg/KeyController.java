package pkg;
import java.awt.event.*;
//import java.awt.event.MouseListener;

public class KeyController{

    private Canvas c = null;
    private InputKeyControl iC;

    public KeyController(Canvas c, InputKeyControl iC){
        this.c = c;
        this.iC = iC;
        System.out.println("Key Started");
        handleKey();
    }

    private void handleKey(){
        this.c.frame.addKeyListener(new KeyListener() {
            @Override
			public void keyPressed(KeyEvent e) {
				char cc = e.getKeyChar();
				String c = Character.toString(cc);
                iC.keyPress(c);
            }

			
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
            
        });

    }

}