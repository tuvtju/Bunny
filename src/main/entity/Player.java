package src.main.entity;

import java.awt.Graphics;


import static utility.Constants.Compass.*;
import static utility.Constants.BunnyState.*;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends entity{
    private BufferedImage[][] Anis;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int Action = IDLE;
    private int charDir = -1;
    private boolean moving = false;


    public Player(float x,float y) {
        super(x, y);
        AniIterator();
    }

    public void update(){
        updateAniTick();
        setAni();
        UpdatePos();

    }

    public void render(Graphics canvas){
        canvas.drawImage(Anis[Action][aniIndex], (int)x, (int)y, 512,256, null);

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
                x -=3;
                break;
            case UP:
                y -=3;
                break;
            case RIGHT:
                x +=3;
                break;
            case DOWN:
                y +=3;
                break;
            }
            
        }
    }
    
    private void AniIterator() {

        
        try{
           
            BufferedImage spritesheet = ImageIO.read(new FileInputStream("res/bunny_char.png"));
            
            Anis = new BufferedImage[5][4];
            for (int row = 0; row < Anis.length; row++) {
                for (int col = 0; col < Anis[row].length; col++) {
                Anis[row][col] = spritesheet.getSubimage(col*64, row*32, 64, 32);
                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        
            
    }
        
       
    
    
}
