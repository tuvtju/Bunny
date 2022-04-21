package src.utility;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.Color;
import javax.imageio.ImageIO;

import src.main.Game;

public class Load {

    public static final String PLAYER_SPRITE = "b.png";
    public static final String LEVEL_SPRITE = "outside.png";
    public static final String LEVEL_ONE = "level_one_data.png";



    public static BufferedImage getSpriteSheet(String file){
        BufferedImage spritesheet = null;
        try{
            
            spritesheet = ImageIO.read(new FileInputStream("res/" + file));
        } catch (IOException e) {
            e.printStackTrace();
        }   
        return spritesheet;
    }
    
    public static int[][] getLevel(){
        int[][] level = new int[Game.HEIGHT][Game.WIDTH];
        BufferedImage image = getSpriteSheet(LEVEL_ONE);

        for (int row = 0; row < image.getHeight(); row++) {
            for (int col = 0; col < image.getWidth(); col++) {
                Color color = new Color(image.getRGB(col,row));
                int value = color.getRed();
                if(value >= 48)
                    value = 0;
                level[row][col] = value;
                
            }
            
        }
        return level;
    }
}
