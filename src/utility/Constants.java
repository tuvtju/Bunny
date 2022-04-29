package src.utility;

public class Constants {
    
    //Constants for bunny animation

    public static class BunnyState {
        public static final int IDLE_RIGHT = 0;
        public static final int IDLE_LEFT = 2;
        public static final int RUNNING_RIGHT = 1;
        public static final int RUNNING_LEFT = 3;
        
        public static int getSprites(int action){

            switch(action){
            case IDLE_RIGHT:
            case IDLE_LEFT:      
                return 4;
            case RUNNING_RIGHT:
            case RUNNING_LEFT:
            default:
                return 3;
            

            }
        
    }
    }

    
}
