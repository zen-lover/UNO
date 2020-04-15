package game;

import Player.Player;
import cards.Card;

import java.util.ArrayList;

public class Display {

    private Display() {
    }

    private static Display display = new Display();

    public static Display getDisplay() {
        return display;
    }

    public void show(ArrayList<Player> players, Player currentPlayer){

        for (Player player:players){
            for (Card card: player.getHand().getCardList()){
                card.show();
            }
        }
    }
}
