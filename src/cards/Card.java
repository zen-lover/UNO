package cards;

import Player.Player;
import game.Table;

import java.util.ArrayList;

public abstract class Card {

    public abstract String getColor();

    public abstract String getValue();

    public abstract void show();

    public abstract boolean match(Card card);

    public abstract void effect(Table table, ArrayList<Player> players);

}
