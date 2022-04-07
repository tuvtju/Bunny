package src.main.Move;

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
                view.getGame().getPlayer().setDirection(UP);
                System.out.println("W");
                break;
            case KeyEvent.VK_A:
                view.getGame().getPlayer().setDirection(LEFT);
                System.out.println("A");
                break;
            case KeyEvent.VK_S:
                view.getGame().getPlayer().setDirection(DOWN);
                System.out.println("S");
                break;
            case KeyEvent.VK_D:
                view.getGame().getPlayer().setDirection(RIGHT);
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
            view.getGame().getPlayer().setMoving(false);
                break;
        }
        
    }
    
}
