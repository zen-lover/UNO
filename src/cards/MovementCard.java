package cards;

import Player.Player;
import game.Table;

import java.util.ArrayList;

/**
 * Class for movement card
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public abstract class MovementCard extends ColorfulCard {

    // Enum structure for value of wild card
    public enum Value {

        // Colorful cards.Card
        SKIP {
            public String toString() {
                return "SKIP";
            }
        },
        REVERSE {
            public String toString() {
                return "REVERSE";
            }
        },
        DRAWTWO {
            public String toString() {
                return "DRAW+2";
            }
        }
    }

    // color of card
    private final NumericalCard.Color color;
    // value of card
    private final Value value;

    /**
     * Construct a movement card
     *
     * @param color color of card
     * @param value value of card
     */
    public MovementCard(final NumericalCard.Color color, final Value value) {
        this.color = color;
        this.value = value;
    }

    /**
     * Method for show card
     */
    public void show() {
        super.show(color, value.toString());
    }

    /**
     * Method for access to color
     * @return String get color
     */
    @Override
    public String getColor() {
        return this.color.name();
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
     * Method for check match between two card
     * @param card input card for compare
     * @return boolean return true if are match
     */
    @Override
    public boolean match(Card card) {
        if (card.getColor().equals("BLACK"))
            return true;

        return (card.getColor().equals(this.getColor())
                || card.getValue().equals(this.getValue()));
    }

    /**
     * Apply effect on state of table
     * @param table table of game
     * @param players list of players
     */
    @Override
    public abstract void effect(Table table, ArrayList<Player> players);
}
