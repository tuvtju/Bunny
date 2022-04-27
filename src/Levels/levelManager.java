package src.Levels;

import src.main.Game;
import src.main.entity.Carrot;
import src.utility.Load;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class levelManager {

    private Game game;
    private BufferedImage[] levelsprite;
    private level levelOne;
    private Carrot carrot;
    
    
    public levelManager(Game game){
        this.game = game;
        levelIterator();
        levelOne = new level(Load.getLevel());
        
    }


    private void levelIterator() {
        BufferedImage sheet = Load.getSpriteSheet(Load.LEVEL_SPRITE);
        levelsprite = new BufferedImage[48];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 12; col++) {
                int index = row*12 + col;
                    levelsprite[index] = sheet.getSubimage(col*32, row*32, 32, 32);
                
            }            
        }
    }


    public void draw(Graphics canvas){
        for(int row = 0; row < Game.HEIGHT; row ++)
            for (int col = 0; col < levelOne.getLevel()[0].length; col++) {
                int index = levelOne.getIndex(col, row);
                canvas.drawImage(levelsprite[index],col*Game.TILES,row*Game.TILES,Game.TILES,Game.TILES,null);
            }
        

    }

    public void update(){

    }
    
    public level getCurrentLevel(){
        return levelOne;
    }




}
