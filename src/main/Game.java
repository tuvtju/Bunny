package src.main;

import java.awt.Graphics;

import src.Levels.levelManager;
import src.main.View.BunnyView;

import src.main.entity.Player;

public class Game implements Runnable{

    private Window frame;
    private BunnyView view;
    private Thread thread;
    private final int FPS = 120;
    private final int UPS = 200;
    private Player player;
    private levelManager manager;


    public static final int TILES_DEFAULT = 32;
    public static final float SCALE = 3.0f;
    public static final int WIDTH = 26;
    public static final int HEIGHT = 14;
    public static final int TILES = (int)(TILES_DEFAULT * SCALE);
    public static final int GAMEWIDTH = WIDTH * TILES;
    public static final int GAMEHEIGHT = HEIGHT * TILES;



    public Game() {
        initClass();
        view = new BunnyView(this);
        frame = new Window(view);
        view.requestFocus();
        
        Loop();
       
    }

    private void initClass() {
        player = new Player(0,0,(int)(2*64*SCALE), (int)(2*32*SCALE));
        manager = new levelManager(this);
    }

    private void Loop(){
        thread = new Thread(this);
        thread.start();
    }


    public void update(){
        manager.update();
    }


    public void render(Graphics g){
        manager.draw(g);
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

    public void lostFocus(){
        player.setMoving(false);
    }

    public Player getPlayer(){
        return player;
    }
    
}
