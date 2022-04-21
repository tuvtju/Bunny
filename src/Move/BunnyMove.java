package src.Move;

import static src.utility.Constants.Compass.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import src.main.View.BunnyView;

public class BunnyMove  implements KeyListener {

    private BunnyView view;


    public BunnyMove(BunnyView bunnyView) {
        this.view = bunnyView;
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
            view.getGame().getPlayer().setUp(true);
            System.out.println("w");
                break;
            case KeyEvent.VK_A:
            view.getGame().getPlayer().setLeft(true);
                break;
            case KeyEvent.VK_S:
            view.getGame().getPlayer().setDown(true);
                break;
            case KeyEvent.VK_D:
            view.getGame().getPlayer().setRight(true);
            System.out.println("d");
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
            view.getGame().getPlayer().setUp(false);
                break;
            case KeyEvent.VK_A:
            view.getGame().getPlayer().setLeft(false);
                break;
            case KeyEvent.VK_S:
            view.getGame().getPlayer().setDown(false);
                break;
            case KeyEvent.VK_D:
            view.getGame().getPlayer().setRight(false);
                break;
        }
        
    }
    
}
