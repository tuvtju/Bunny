package utility;

public class Constants {
    

    public static class BunnyState {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMPING = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        
        public static int getSprites(int action){

            switch(action){
            case IDLE:   
            case JUMPING:
                return 4;
            case RUNNING:
                return 3;
            case FALLING:
            case GROUND:
            case default:
                return 1;
            

            }
        
    }
    }

    public static class Compass {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int DOWN = 2;
        public static final int RIGHT = 3;
        
    }

    
}
