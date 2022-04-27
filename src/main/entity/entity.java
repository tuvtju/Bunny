package src.main.entity;

import java.awt.Rectangle;
import java.awt.geom.*;
import java.text.CollationElementIterator;
import java.awt.Color;
import java.awt.Graphics;

public class entity{
    
    protected float x,y;
    protected int width,height;
    protected Rectangle2D.Float hitBox;

    public entity(float x, float y, int width,int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;

        getHitBox();
    }

    
    protected void drawHitBox(Graphics g){
        //debugging hitBox
        g.setColor(Color.RED);
        g.drawRect((int) hitBox.x, (int) hitBox.y, (int) hitBox.width, (int) hitBox.height);

    }

    protected void initHitBox(float x, float y, float width, float height) {
        hitBox = new Rectangle2D.Float(x, y, width, height);
    }

    public Rectangle2D.Float getHitBox() {
        return this.hitBox;
    }

   
    
   
}