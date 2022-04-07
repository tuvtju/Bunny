package Move;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import src.main.View.BunnyView;
import static utility.Constants.Compass.*;

public class BunnyMove  implements KeyListener {

    private BunnyView view;


    public BunnyMove(BunnyView bunnyView) {
        this.view = bunnyView;
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                view.setDirection(UP);
                view.repaint();
                System.out.println("W");
                break;
            case KeyEvent.VK_A:
                view.setDirection(LEFT);
                view.repaint();
                System.out.println("A");
                break;
            case KeyEvent.VK_S:
                view.setDirection(DOWN);
                view.repaint();
                System.out.println("S");
                break;
            case KeyEvent.VK_D:
                view.setDirection(RIGHT);
                view.repaint();
                System.out.println("D");
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
            view.setMoving(false);
                break;
        }
        
    }
    
}
