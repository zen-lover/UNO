package cards;

import Player.Player;
import game.Table;

import java.util.ArrayList;

/**
 * Class for skip card
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public class SkipCard extends MovementCard{

    /**
     * Construct skip card
     * @param color choose color for card
     */
    public SkipCard(NumericalCard.Color color){
        super(color, Value.SKIP);
    }

    /**
     * Apply effect on state of table
     * @param table table of game
     * @param players list of players
     */
    public void effect(Table table, ArrayList<Player> players) {
        table.changeCurrentPlayer(players);
    }
}
