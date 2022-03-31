package src.main.Move;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import src.main.View.BunnyView;

public class BunnyMove  implements KeyListener {

    private BunnyView model;


    public BunnyMove(BunnyView view) {
        this.model = view;
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        switch(e.getKeyCode()){
        
            case KeyEvent.VK_W:
                model.deltaY(-5);
                model.repaint();
                System.out.println("W");
                break;
            case KeyEvent.VK_A:
                model.deltaX(-5);
                model.repaint();
                System.out.println("A");
                break;
            case KeyEvent.VK_S:
                model.deltaY(5);
                model.repaint();
                System.out.println("S");
                break;
            case KeyEvent.VK_D:
                model.deltaX(5);
                model.repaint();
                System.out.println("D");
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
