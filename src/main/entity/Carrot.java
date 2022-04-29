package src.main.entity;

import java.awt.image.BufferedImage;

import java.awt.Graphics;

import src.main.Game;
import src.utility.Load;

public class Carrot extends entity {

    public Carrot(float x, float y, int width, int height) {
        super(x, y, width, height);
        initHitBox(x, y, 32 * Game.SCALE,32 * Game.SCALE);
    }


    public void draw(Graphics canvas){
        BufferedImage Carrot = Load.getSpriteSheet(Load.CARROT_SPRITE);
        canvas.drawImage(Carrot, (int)( hitBox.x), (int)(hitBox.y), width, height, null);
        //drawHitBox(canvas);
    }


}
