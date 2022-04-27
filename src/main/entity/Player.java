package src.main.entity;

import static src.utility.Constants.BunnyState.*;

import static src.utility.helpMethods.*;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D.Float;
import java.awt.image.BufferedImage;


import src.main.Game;
import src.utility.Load;

public class Player extends entity{
    private BufferedImage[][] Anis;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int Action = IDLE_RIGHT;
    private boolean moving = false;
    private boolean left, right, Jump;
    private float pSpeed = 1.0f * Game.SCALE;
    private boolean Dir = false;

    //Jumping Gravity
    private float airSpeed = 0f;
    private float gravity = 0.08f * Game.SCALE;
    private float jumpSpeed = -3.7f * Game.SCALE;
    private float hitFall = 0.5f * Game.SCALE;
    private boolean inAir = true;

    private int[][] level;
    private float xDrawhitbox = 28 * Game.SCALE;
    private float yDrawhitbox = 18 * Game.SCALE;
 
    //private BufferedImage spritesheet;


    public Player(float x,float y, int width, int height) {
        super(x, y, width, height);
        initHitBox(x, y, 20 * Game.SCALE,19 * Game.SCALE);
        AniIterator();
    }

    public void update(){
        UpdatePos();
        updateAniTick();
        setAni();
        

    }

    public void render(Graphics canvas){
        canvas.drawImage(Anis[Action][aniIndex], (int)( hitBox.x - xDrawhitbox), (int)(hitBox.y - yDrawhitbox), width, height, null);
        //drawHitBox(canvas);
        update();

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
            if(left){
                Action = RUNNING_LEFT;
                Dir = true;
            }else{
                Action = RUNNING_RIGHT;
                Dir = false;
            }
        }else{
           if(Dir)
                Action = IDLE_LEFT;
            else
                Action = IDLE_RIGHT;
        }
    }
 

    private void UpdatePos() {

        moving = false;
        if(Jump){
            jump();
        }

        

        if(!left && !right && !inAir)
            return;

        float xSpeed = 0;

        if(!inAir){
            if(!onFloor(hitBox, level) )
                inAir = true;
        }

        

        if(left && !right)
            xSpeed = -pSpeed;
        else if(right && !left)
            xSpeed = pSpeed;

        if(inAir){
            if(movable(hitBox.x, (hitBox.y + airSpeed) , hitBox.width, hitBox.height, level)){
                hitBox.y += airSpeed; 
                airSpeed += gravity;
                updatexPos(xSpeed);
            }else{
                hitBox.y = GetRooforFloor(hitBox,airSpeed);
                if(airSpeed > 0)
                    resetInAir();
                else 
                     airSpeed = hitFall;
                updatexPos(xSpeed); 
            }

        }else
            updatexPos(xSpeed);
        

        moving = true;
          
            
    }
    


    private void resetInAir() {
        inAir = false;
        airSpeed = 0;
    }

    private void jump() {
        if(inAir)
            return;
        inAir = true;
        airSpeed = jumpSpeed;
    }


    private void updatexPos(float xSpeed) {
        if(movable(hitBox.x + xSpeed, hitBox.y, hitBox.width, hitBox.height, level)){
            hitBox.x += xSpeed;
        }else{
            hitBox.x = GetWall(hitBox,xSpeed);
        }
    }

    

    private void AniIterator() {   
        BufferedImage spritesheet = Load.getSpriteSheet(Load.PLAYER_SPRITE);

        Anis = new BufferedImage[4][4];
        for (int row = 0; row < Anis.length; row++) {
            for (int col = 0; col < Anis[row].length; col++) {
            Anis[row][col] = spritesheet.getSubimage(col*64, row*32, 64, 32);
            }
        }
    }

    public void loadlvlData(int[][] level){
        this.level = level;

    }
        

    public void resetDir(){
        left = false;
        right = false;
    }

    

    public boolean isLeft() {
        return this.left;
    }


    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return this.right;
    }



    public void setRight(boolean right) {
        this.right = right;
    }

    public void setJump(boolean jump) {
        this.Jump = jump;
    }


}