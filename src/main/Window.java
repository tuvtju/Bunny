package src.main;

import javax.swing.JFrame;

import src.main.View.BunnyView;

public class Window extends JFrame{

    public static final String WINDOW_TITLE = "BUNNY GAME";

    public Window(BunnyView view){
        
          
        // The JFrame is the "root" application window.
        // We here set som properties of the main window, 
        // and tell it to display our tetrisView
        JFrame frame = new JFrame(WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(view);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }


    
}
