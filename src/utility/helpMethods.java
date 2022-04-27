package src.utility;
import java.awt.geom.*;

import src.main.Game;

public class helpMethods {
    
    public static boolean movable(float x, float y, float width, float height, int[][] level){

        if (!Solid(x, y, level))
            if (!Solid(x + width, y + height, level))
                if (!Solid(x + width, y, level))
                    if (!Solid(x, y + height, level))
                        return true;
        return false;
        
    }

    private static boolean Solid(float x, float y, int[][] level){
        int maxWidth = level[0].length * Game.TILES;
        if (x < 0 || x >= maxWidth)
            return true;
        if (y < 0 || y >= Game.GAMEHEIGHT)
            return true;
        
        float xIndex = x / Game.TILES;
        float yIndex = y / Game.TILES;

        

        int value = level[(int) yIndex][(int) xIndex];
        if (value >= 48 || value < 0 || value != 11)
            return true;
        return false;

        



            
        
    }

    public static float GetWall(Rectangle2D.Float hitBox, float xSpeed) {
        int currentTile = (int)(hitBox.x / Game.TILES);
        if(xSpeed > 0){
            //right
            int xTile = currentTile * Game.TILES;
            int xSpace = (int)(Game.TILES - hitBox.width);
            return xTile + xSpace -1;
        }else{
            //left
            return currentTile * Game.TILES;
        }
    }

    public static float GetRooforFloor(Rectangle2D.Float hitBox, float airSpeed){
        int currentTile = (int)(hitBox.y / Game.TILES);
        if(airSpeed > 0){
            //falling
            int yTile = currentTile * Game.TILES;
            int ySpace = (int)(Game.TILES - hitBox.height);
            return yTile + ySpace -1;
        }else{
            //jumping
            return currentTile * Game.TILES;
        }

    }

    public static boolean onFloor(Rectangle2D.Float hitBox, int[][] level){

        if(!Solid(hitBox.x, hitBox.y + hitBox.height + 1, level))
            if(!Solid(hitBox.x + hitBox.width, hitBox.y + hitBox.height + 1, level))
                return false;
        return true;
        
    }




}
