package src.main.entity;

import src.main.Move.BunnyMove;
import src.main.View.BunnyView;

public class Player extends entity{
    BunnyView view;
    BunnyMove move;


    public Player(BunnyView view, BunnyMove move) {
        this.view = view;
        this.move = move;
    }
    
    
}
