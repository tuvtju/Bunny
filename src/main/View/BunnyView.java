package src.main.View;

import java.awt.Graphics;

import javax.swing.JPanel;

import Move.BunnyMove;
import src.main.Game;
import src.main.entity.Player;

import java.awt.Dimension;

import static utility.Constants.Compass.*;
import static utility.Constants.BunnyState.*;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class BunnyView extends JPanel{
    private BufferedImage[][] Anis;
    private BufferedImage sprite;
    private int aniTick, aniIndex, aniSpeed = 15;
    private float Deltax = 0, Deltay = 0;
    private int Action = IDLE;
    private int charDir = -1;
    private boolean moving = false;
    public Player player;
    private Game game;
    private BufferedImage spritesheet;
    
    
    public BunnyView() {
        //this.game = game;
        setGameSize();
        Import();
        AniIterator();
        
        addKeyListener(new BunnyMove(this));

    }

    private void updateAniTick() {
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= getSprites(Action)) {
                aniIndex = 0;
                
            }
        }
    }
    
    public void setAni(){
        if(moving){
            Action = RUNNING;
        }else{
            Action = IDLE;
        }
    }
    public void setMoving(boolean moving) {
        this.moving = moving;

        }

    private void UpdatePos() {
        if(moving){
            switch(charDir){
            case LEFT:
                Deltax -=3;
                break;
            case UP:
                Deltay-=3;
                break;
            case RIGHT:
                Deltax +=3;
                break;
            case DOWN:
                Deltay +=3;
                break;
            }
            
        }
    }


    private void Import(){
        try{
                
            spritesheet = ImageIO.read(new FileInputStream("res/bunny_char.png"));
                
                

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private void AniIterator() {

        Anis = new BufferedImage[5][4];
            for (int row = 0; row < Anis.length; row++) {
                for (int col = 0; col < Anis[row].length; col++) {
                Anis[row][col] = spritesheet.getSubimage(col*64, row*32, 64, 32);
                }
            }
        
        
        


        
            
    }

    public void setDirection(int Dir){
        this.charDir = Dir;
        moving = true;

    }








    
    private void setGameSize() {
        Dimension window = new Dimension(800,600);
        setPreferredSize(window);
        setMaximumSize(window);
        setMinimumSize(window);

    }

    public void updateGame() {
        updateAniTick();
        setAni();
        UpdatePos();
    }
    
    
    public void paint(Graphics g){
        super.paint(g);

        updateGame();

        g.drawImage(Anis[Action][aniIndex], (int)Deltax, (int)Deltay, 512,256, null);
       
    }

    public Game getGame(){
        return game;
    }
   
}