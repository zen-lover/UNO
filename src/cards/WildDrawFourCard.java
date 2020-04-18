package cards;

import Player.Player;
import game.Table;

import java.util.ArrayList;

public class WildDrawFourCard extends WildCard {

    private Value value;

    public WildDrawFourCard() {
        super();
        this.value = Value.WILDDRAWFOUR;
    }

    @Override
    public String getValue() {
        return this.value.toString();
    }

    public void effect(Table table, ArrayList<Player> players) {
        super.effect(table,players);
        table.setBlame(4);
    }

}
