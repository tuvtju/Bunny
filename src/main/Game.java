package src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.image.BufferedImage;

import src.Levels.levelManager;
import src.main.View.BunnyView;
import src.main.View.Window;
import src.main.entity.Player;
import src.utility.Load;

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

    private BufferedImage background;
    private BufferedImage carrot;



    public Game() {
        initClass();
        background = Load.getSpriteSheet(Load.BACKGROUND);
        carrot = Load.getSpriteSheet(Load.CARROT_SPRITE);
        view = new BunnyView(this);
        frame = new Window(view);
        view.requestFocus();

        
        Loop();
       
    }

    // creates needed objects
    private void initClass() {
        manager = new levelManager(this);
        player = new Player(1000,600,(int)(2*64*SCALE), (int)(2*32*SCALE));
        player.loadlvlData(manager.getCurrentLevel().getLevel());
    }

    private void Loop(){
        thread = new Thread(this);
        thread.start();
    }



   
    // renders the graphics of all elemnts order is necesery
    public void render(Graphics g){
        g.drawImage(background, 0, 0, GAMEWIDTH, GAMEHEIGHT,null);
        manager.draw(g);
        g.drawImage(carrot, 50, 20, TILES * 2, TILES*2, null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Sans",Font.BOLD,50));
        g.drawString("x" + Player.carrots, 160, 200);
        player.render(g);
        
        
    }

    @Override
    public void run() {

        //makes the game smooth 

       

        long lastcheck = System.currentTimeMillis();
        long previousTime = System.nanoTime();

        int frames = 0;
        int update = 0;
        
        double timePerFrame = 1000000000.0/FPS;
        double timePerUpdate = 1000000000.0/UPS;

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
                System.out.println("FPS: " + frames + "  | UPS: " + update + " " );
                frames = 0;
                update = 0;
            }
        }
        
    }

    // makes sure player stands still when focus is lost
    public void lostFocus(){
        player.resetDir();
    }


    public Player getPlayer(){
        return player;
    }
    
}
