package src.main.View;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class Window extends JFrame{

    public static final String WINDOW_TITLE = "BUNNY GAME";

    public Window(BunnyView view){
        
          
        // Creats Jframe and checks focus
        JFrame frame = new JFrame(WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(view);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowFocusListener(new WindowFocusListener(){

            @Override
            public void windowGainedFocus(WindowEvent e) {
                
                
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                System.out.println("pop up again");
                view.getGame().lostFocus();


                
                
            }
            
        });
    }


    
}
