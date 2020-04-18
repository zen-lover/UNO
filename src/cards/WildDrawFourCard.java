package cards;

import Player.Player;
import game.Table;

import java.util.ArrayList;


public class WildDrawFourCard extends WildCard {

    // value of card
    private Value value;

    /**
     * Construct a wild draw card
     */
    public WildDrawFourCard() {
        super();
        this.value = Value.WILDDRAWFOUR;
    }

    /**
     * Method for access to color
     * @return String get value
     */
    @Override
    public String getValue() {
        return this.value.toString();
    }

    /**
     * Apply effect on state of table
     * @param table table of game
     * @param players list of players
     */
    public void effect(Table table, ArrayList<Player> players) {
        super.effect(table,players);
        table.setBlame(4);
    }

}
