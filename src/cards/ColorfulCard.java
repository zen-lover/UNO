package cards;

import Player.Player;
import game.Table;

import java.util.ArrayList;

public abstract class ColorfulCard extends Card {


    public ColorfulCard() {
    }

    @Override
    public abstract String getColor();

    @Override
    public abstract String getValue();

    public void show(NumericalCard.Color color, String value){

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

        String str = value.toString();
        int space1 = 8+str.length()/2;
        int space2 = 8-str.length()/2;
        System.out.printf(ANSI_COLOR+"|$$$$$$$$$$$$$$$|\n");
        System.out.printf("|%" + 17 + "s","|\n");
        System.out.printf("|%"+ space1 + "s" + "%"+ space2 + "s\n",str,"|");
        System.out.printf("|%" + 17 + "s","|\n");
        System.out.printf("|$$$$$$$$$$$$$$$|\n"+ANSI_RESET);
    }

    @Override
    public abstract boolean match(Card card);

    public abstract void effect(Table table, ArrayList<Player> players);

}
