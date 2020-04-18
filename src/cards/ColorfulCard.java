package cards;

import Player.Player;
import game.Table;

import java.util.ArrayList;

/**
 * Class for colorful card
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public abstract class ColorfulCard extends Card {

    /**
     * Construct a colorful card
     */
    public ColorfulCard() {
    }

    /**
     * Method for access to color
     * @return String get color
     */
    @Override
    public abstract String getColor();

    /**
     * Method for access to color
     * @return String get value
     */
    @Override
    public abstract String getValue();

    /**
     * Method for show card
     */
    public void show(NumericalCard.Color color, String value) {

        String ANSI_COLOR;
        switch (color) {
            case RED:
                final String ANSI_RED = "\u001B[31m";
                ANSI_COLOR = ANSI_RED;
                break;
            case BLUE:
                final String ANSI_BLUE = "\u001B[34m";
                ANSI_COLOR = ANSI_BLUE;
                break;
            case GREEN:
                final String ANSI_GREEN = "\u001B[32m";
                ANSI_COLOR = ANSI_GREEN;
                break;
            case YELLOW:
                final String ANSI_YELLOW = "\u001B[33m";
                ANSI_COLOR = ANSI_YELLOW;
                break;
            default:
                final String ANSI_WHITE = "\u001B[37m";
                ANSI_COLOR = ANSI_WHITE;
                break;
        }
        final String ANSI_RESET = "\u001B[0m";

        String str = getValue();
        int space1 = 8 + str.length() / 2;
        int space2 = 8 - str.length() / 2;
        System.out.printf(ANSI_COLOR + "|$$$$$$$$$$$$$$$|\n");
        System.out.printf("|%" + 17 + "s", "|\n");
        System.out.printf("|%" + space1 + "s" + "%" + space2 + "s\n", str, "|");
        System.out.printf("|%" + 17 + "s", "|\n");
        System.out.printf("|$$$$$$$$$$$$$$$|\n" + ANSI_RESET);
    }

    /**
     * Method for check match between two card
     * @param card input card for compare
     * @return boolean return true if are match
     */
    @Override
    public abstract boolean match(Card card);

    /**
     * Apply effect on state of table
     * @param table table of game
     * @param players list of players
     */
    public abstract void effect(Table table, ArrayList<Player> players);

}
