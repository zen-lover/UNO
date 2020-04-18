package cards;

import Player.Player;
import game.Table;

import java.util.ArrayList;

/**
 * Class for numerical card
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public class NumericalCard extends ColorfulCard {

    // Enum structure for color of wild card
    public enum Color {
        BLUE {
            public String toString() {
                return "BLUE";
            }
        },
        RED {
            public String toString() {
                return "RED";
            }
        },
        GREEN {
            public String toString() {
                return "GREEN";
            }
        },
        YELLOW {
            public String toString() {
                return "YELLOW";
            }
        }
    }

    // Enum structure for value of wild card
    public enum Value {

        // Numerical cards.Card
        ZERO {
            public String toString() {
                return "0";
            }
        },
        ONE {
            public String toString() {
                return "1";
            }
        },
        TWO {
            public String toString() {
                return "2";
            }
        },
        THREE {
            public String toString() {
                return "3";
            }
        },
        FOUR {
            public String toString() {
                return "4";
            }
        },
        FIVE {
            public String toString() {
                return "5";
            }
        },
        SIX {
            public String toString() {
                return "6";
            }
        },
        SEVEN {
            public String toString() {
                return "7";
            }
        },
        EIGHT {
            public String toString() {
                return "8";
            }
        },
        NINE {
            public String toString() {
                return "9";
            }
        }
    }

    // color of card
    private final Color color;
    // value of card
    private final Value value;

    /**
     * Construct a numerical card
     *
     * @param color color of card
     * @param value value of card
     */
    public NumericalCard(final Color color, final Value value) {
        this.color = color;
        this.value = value;
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
    public void effect(Table table, ArrayList<Player> players) {

    }

    /**
     * Method for check input color is valid or not
     * @param colorToComp color to compare
     * @return boolean if color is valid returns true
     */
    public static boolean validColor(String colorToComp) {
        for (Color color : Color.values()) {
            if (color.name().equals(colorToComp.toUpperCase()))
                return true;
        }
        return false;
    }

    /**
     * Method for show card
     */
    public void show() {
        super.show(color, value.toString());
    }

}
