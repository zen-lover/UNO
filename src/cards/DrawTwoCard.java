package cards;

import Player.Player;
import game.Table;

import java.util.ArrayList;

public class DrawTwoCard extends MovementCard {

    public DrawTwoCard(NumericalCard.Color color){
        super(color, Value.DRAWTWO);
    }

    public void effect(Table table, ArrayList<Player> players){
        table.setBlame(2);
    }
}
