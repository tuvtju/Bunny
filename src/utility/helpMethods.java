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
        if (x < 0 || x >= Game.GAMEWIDTH)
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
            int xTile = currentTile * Game.TILES;
            int xSpace = (int)(Game.TILES - hitBox.width);
            return xTile + xSpace -1;
        }else{
            return currentTile * Game.TILES;
        }
    }

    public static float GetRooforFloor(Rectangle2D.Float hitBox, float airspeed){
        int currentTile = (int)(hitBox.y / Game.TILES);
        if(airspeed > 0){
            int yTile = currentTile * Game.TILES;
            int ySpace = (int)(Game.TILES - hitBox.height);
            return yTile + ySpace -1;
        }else{
            return currentTile * Game.TILES;
        }

    }




}
