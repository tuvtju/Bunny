package src.Move;


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
            case KeyEvent.VK_A:
            view.getGame().getPlayer().setLeft(true);
            System.out.println("Left");
                break;
            case KeyEvent.VK_D:
            view.getGame().getPlayer().setRight(true);
            System.out.println("Right");
                break;
            case KeyEvent.VK_SPACE:
            view.getGame().getPlayer().setJump(true);
            System.out.println("Weeee!");
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_A:
            view.getGame().getPlayer().setLeft(false);
                break;
            case KeyEvent.VK_D:
            view.getGame().getPlayer().setRight(false);
                break;
            case KeyEvent.VK_SPACE:
            view.getGame().getPlayer().setJump(false);
                break;
        }
        
    }
    
}
