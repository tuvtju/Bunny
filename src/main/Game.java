package src.main;

import src.main.View.BunnyView;

public class Game implements Runnable{

    private Window frame;
    private BunnyView view;
    private Thread thread;
    private final int FPS = 120;

    public Game() {

       view = new BunnyView();
       frame = new Window(view);
       view.requestFocus();
       Loop();
       
    }

    private void Loop(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0/FPS;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        int frames = 0;
        long lastcheck = System.currentTimeMillis();
        while(true){

            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame){
                view.repaint();
                lastFrame = now;
                frames++;
            }
            if(System.currentTimeMillis() -lastcheck >= 1000){
                lastcheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        
    }
    
}
