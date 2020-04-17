package cards;

import Player.Player;
import game.Table;

import java.util.ArrayList;

public class ReverseCard extends MovementCard{

    public ReverseCard(NumericalCard.Color color){
        super(color, Value.REVERSE);
    }

    public void effect(Table table, ArrayList<Player> players){
        table.reverseDirection(players);
    }

}
