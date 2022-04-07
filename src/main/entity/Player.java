package src.main.entity;

import static src.utility.Constants.BunnyState.*;
import static src.utility.Constants.Compass.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import src.main.Game;
import src.utility.Load;

public class Player extends entity{
    private BufferedImage[][] Anis;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int Action = IDLE;
    private int charDir = -1;
    private boolean moving = false;
    private int height;
    private int width;
    private float pSpeed = 1.0f * Game.SCALE;
    //private BufferedImage spritesheet;


    public Player(float x,float y, int height, int width) {
        super(x, y);

        this.height= height;
        this.width = width;
        AniIterator();
    }

    public void update(){
        updateAniTick();
        setAni();
        UpdatePos();

    }

    public void render(Graphics canvas){
        canvas.drawImage(Anis[Action][aniIndex], (int)x, (int)y, height, width, null);
        update();

    }

    public void setDirection(int Dir){
        this.charDir = Dir;
        moving = true;
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
                x -=pSpeed;
                break;
            case UP:
                y -=pSpeed;
                break;
            case RIGHT:
                x +=pSpeed;
                break;
            case DOWN:
                y +=pSpeed;
                break;
            }
            
        }
    }
    



    private void AniIterator() {   
        BufferedImage spritesheet = Load.getSpriteSheet(Load.PLAYER_SPRITE);

        Anis = new BufferedImage[5][4];
        for (int row = 0; row < Anis.length; row++) {
            for (int col = 0; col < Anis[row].length; col++) {
            Anis[row][col] = spritesheet.getSubimage(col*64, row*32, 64, 32);
            }
        }
    }
        
       
    
    
}
