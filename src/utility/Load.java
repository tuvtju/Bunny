package src.utility;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.Color;
import javax.imageio.ImageIO;

import src.main.Game;
import src.main.entity.Carrot;

public class Load {

    public static final String PLAYER_SPRITE = "b.png";
    public static final String LEVEL_SPRITE = "outside.png";
    public static final String LEVEL_ONE = "level_one.png";
    public static final String CARROT_SPRITE = "Carrot.png";
    private static Carrot carrot;



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
        
        BufferedImage image = getSpriteSheet(LEVEL_ONE);
        int[][] level = new int[image.getHeight()][image.getWidth()];
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
