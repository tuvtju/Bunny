package src.utility;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.Color;
import javax.imageio.ImageIO;


public class Load {

    // this class loads the spritesheet from png files and gives the level pixles rgb(red) values

    public static final String PLAYER_SPRITE = "Bunny.png";
    public static final String LEVEL_SPRITE = "Texture.png";
    public static final String LEVEL_ONE = "Level.png";
    public static final String CARROT_SPRITE = "Carrot.png";

    public static final String BACKGROUND = "BackGround.png";

    



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
                
                if(value >= 51)
                    value = 0;
                level[row][col] = value;

            }
            
        }
        return level;
    }
    
}
