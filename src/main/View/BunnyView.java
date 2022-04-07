package src.main.View;

import java.awt.Graphics;

import javax.swing.JPanel;

import src.main.Game;
import src.main.Move.BunnyMove;
import src.main.entity.Player;

import java.awt.Dimension;


public class BunnyView extends JPanel{
    public Player player;
    private Game game;
    
    

    public BunnyView(Game game) {
        this.game = game;
        setGameSize();
        
        addKeyListener(new BunnyMove(this));

    }
    
    private void setGameSize() {
        Dimension window = new Dimension(800,600);
        setPreferredSize(window);
        setMaximumSize(window);
        setMinimumSize(window);

    }

    public void updateGame() {
    }
    
    
    public void paint(Graphics g){
        super.paint(g);

        game.render(g);
       
    }

    public Game getGame(){
        return game;
    }
   
}