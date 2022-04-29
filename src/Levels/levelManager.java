package src.Levels;

import src.main.Game;
import src.main.entity.Carrot;
import src.main.entity.Player;
import src.utility.Load;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class levelManager {

    private Game game;
    public BufferedImage[] levelsprite;
    private level level;
    private Carrot carrot;

    
    
    
    public levelManager(Game game){
        this.game = game;
        levelIterator();
        level = new level(Load.getLevel());
        
    }

    //goes through the levelsprite and makeseach block sprite their own image
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

    //draws each tile of the level depending on the set RGB(red) values in Load
    public void draw(Graphics canvas){
        for(int row = 0; row < Game.HEIGHT; row ++)
            for (int col = 0; col < level.getLevel()[0].length; col++) {
                int index = level.getIndex(col, row);
                if(index == 49 && !Player.remove){
                    //creates a carrot object 
                    carrot = new Carrot(col*Game.TILES, row*Game.TILES, Game.TILES, Game.TILES);
                    carrot.draw(canvas);

                }
                else if(index <= 48)
                canvas.drawImage(levelsprite[index],col*Game.TILES,row*Game.TILES,Game.TILES,Game.TILES,null);
            } 
            
           
        

    }
    
    public level getCurrentLevel(){
        return level;
    }






}
