package src.main.View;

import java.awt.Graphics;

import javax.swing.JPanel;

import src.Move.BunnyMove;

import static src.main.Game.GAMEHEIGHT;
import static src.main.Game.GAMEWIDTH;

import src.main.Game;

import java.awt.Dimension;



public class BunnyView extends JPanel{
    
    private Game game;
    
    
    public BunnyView(Game game) {
        this.game = game; 
        setGameSize();
        addKeyListener(new BunnyMove(this));

    }

    private void setGameSize() {
        Dimension window = new Dimension(GAMEWIDTH,GAMEHEIGHT);
        setPreferredSize(window);

    }

    
    //paints the game
    public void paint(Graphics g){
        super.paint(g);


        game.render(g);
        

       
    }

    public Game getGame(){
        return game;
    }
   
}