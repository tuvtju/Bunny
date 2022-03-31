package src.main.View;

import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import src.main.Move.BunnyMove;

import java.awt.Dimension;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class BunnyView extends JPanel{
    private int xDelta = 0, yDelta = 0;
    private BufferedImage spritesheet;
    private BufferedImage sprite;

    
    

    public BunnyView() {
        importimage();
        setGameSize();
        
        addKeyListener(new BunnyMove(this));

    }
    



    private void importimage() {

        try{
            
            spritesheet = ImageIO.read(new FileInputStream("res/bunny_char.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    

    private void setGameSize() {
        Dimension window = new Dimension(1280,600);
        setPreferredSize(window);
        setMaximumSize(window);
        setMinimumSize(window);

    }

    public void deltaX(int move){
        this.xDelta += move;
        
    }

    public void deltaY(int move){
        this.yDelta += move;
        
    }





    public void paint(Graphics g){
        super.paint(g);
        //sprite.getSubimage(x, y, w, h)
        sprite = spritesheet.getSubimage(2*64,0*32, 64, 32);
        g.drawImage(sprite, (int)xDelta, (int)yDelta, 256,128, null);
       
    }
   
}