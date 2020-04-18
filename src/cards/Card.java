package cards;

import Player.Player;
import game.Table;

import java.util.ArrayList;

/**
 * Class for create all type of cards
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public abstract class Card {

    /**
     * Method for access to color
     * @return String get color
     */
    public abstract String getColor();

    /**
     * Method for access to color
     * @return String get value
     */
    public abstract String getValue();

    /**
     * Method for show card
     */
    public abstract void show();

    /**
     * Method for check match between two card
     * @param card input card for compare
     * @return boolean return true if are match
     */
    public abstract boolean match(Card card);

    /**
     * Apply effect on state of table
     * @param table table of game
     * @param players list of players
     */
    public abstract void effect(Table table, ArrayList<Player> players);

}
