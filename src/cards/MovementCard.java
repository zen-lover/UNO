package cards;

import Player.Player;
import game.Table;

import java.util.ArrayList;

public abstract class MovementCard extends ColorfulCard {

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

    private final NumericalCard.Color color;
    private final Value value;

    public MovementCard(final NumericalCard.Color color, final Value value) {
        this.color = color;
        this.value = value;
    }

    public void show() {
        super.show(color, value.toString());
    }

    @Override
    public String getColor() {
        return this.color.name();
    }

    @Override
    public String getValue() {
        return this.value.toString();
    }

    @Override
    public boolean match(Card card) {
        if (card.getColor().equals("BLACK"))
            return true;

        return (card.getColor().equals(this.getColor())
                || card.getValue().equals(this.getValue()));
    }

    @Override
    public abstract void effect(Table table, ArrayList<Player> players);
}
