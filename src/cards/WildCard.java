package cards;

import Player.*;
import game.Table;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WildCard extends Card {

    public enum Value {
        WILD {
            public String toString() {
                return "WILD";
            }
        },
        WILDDRAWFOUR {
            public String toString() {
                return "WILD+4";
            }
        }
    }

    private final String color = "BLACK";
    private final Value value;
    private boolean used;
    private String effectiveColor;

    public WildCard() {
        this.value = Value.WILD;
    }

    @Override
    public String getColor() {
        if (!this.used)
            return this.color;
        else
            return this.effectiveColor;
    }

    @Override
    public String getValue() {
        return this.value.name();
    }

    @Override
    public boolean match(Card card) {
        if (this.getColor().equals("BLACK"))
            return false;
        else if (card.getColor().equals("BLACK"))
            return true;
        else
            return (card.getColor().equals(this.getColor()));
    }

    public boolean setColor(String color) {
        if (this.used)
            return false;
        if (!NumericalCard.validColor(color))
            throw new IllegalArgumentException();

        this.effectiveColor = color;
        this.used = true;
        return true;
    }

    @Override
    public String toString() {
        if (this.used)
            return super.toString();

        return this.getValue();
    }

    public void show() {

        String ANSI_COLOR;
        switch (color) {
            case "BLACK":
                final String ANSI_BLACK = "\u001B[30m";
                ANSI_COLOR = ANSI_BLACK;
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

    public void effect(Table table, ArrayList<Player> players) {
        table.changeCurrentPlayer(players);
        changeColor(table);
    }

    public void changeColor(Table table) {
        System.out.println("choose color for table");
        int i = 1;
        try {
            for (NumericalCard.Color color : NumericalCard.Color.values()) {
                System.out.println(i + ") " + color.toString());
                i++;
            }
        } catch (Exception e) {
            System.out.println("format choice of card is not valid.");
        }

        int color;
        if (table.getCurrentPlayer() instanceof HumanPlayer){
            Scanner in = new Scanner(System.in);
            color = in.nextInt();           //set color for wild card
        }else {
            Random random = new Random();
            color = random.nextInt(4)+1;
        }

        setColor(NumericalCard.Color.values()[color - 1].toString());

    }


}
