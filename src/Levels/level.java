package src.Levels;

public class level {
    private int[][] level;

    public level(int[][] level) {
        this.level = level;
    }
    
    public int getIndex(int x,int y){
        return level[y][x];

    }

    public int setIndex(int x,int y){
        return level[y][x];

    }



    public int[][] getLevel(){
        return level;
    }
}
