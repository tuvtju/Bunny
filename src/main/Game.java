package src.main;

import java.awt.Graphics;

import src.main.View.BunnyView;

import src.main.entity.Player;

public class Game implements Runnable{

    private Window frame;
    private BunnyView view;
    private Thread thread;
    private final int FPS = 120;
    private final int UPS = 200;
    private Player player;

    public Game() {
        initClass();
        view = new BunnyView(this);
        frame = new Window(view);
        view.requestFocus();
       
        Loop();
       
    }

    private void initClass() {
        player = new Player(0,0);
    }

    private void Loop(){
        thread = new Thread(this);
        thread.start();
    }

    public void update(){
        player.update();
    }

    public void render(Graphics g){
        player.render(g);

    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0/FPS;
        double timePerUpdate = 1000000000.0/UPS;
        long previousTime = System.nanoTime();
        int frames = 0;
        int update = 0;
        long lastcheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;
        while(true){

            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime)/ timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;
            if(deltaU >= 1){
                update++;
                deltaU--;
            }

            if(deltaF >= 1){
                view.repaint();
                deltaF--;
                frames++;
            }

            if(System.currentTimeMillis() -lastcheck >= 1000){
                lastcheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + "  | UPS: " + update);
                frames = 0;
                update = 0;
            }
        }
        
    }

    public Player getPlayer(){
        return player;
    }
    
}
