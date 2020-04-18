package cards;

import Player.Player;
import game.Table;

import java.util.ArrayList;

public class SkipCard extends MovementCard{

    public SkipCard(NumericalCard.Color color){
        super(color, Value.SKIP);
    }

    public void effect(Table table, ArrayList<Player> players) {
        table.changeCurrentPlayer(players);
    }
}
