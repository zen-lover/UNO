package game;

import Player.*;
import cards.Card;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UnoGame {

    private Table table;
    private ArrayList<Player> players;


    public UnoGame() {
        this.table = new Table();
        this.players = new ArrayList<Player>();
    }

    public void init() {

        System.out.println("\033[1;36m" + "\nWelcome to UNO game\n" + "\033[0m");
        boolean invalid;
        int numberOfPlayer = 3;
        do {
            invalid = false;
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("\033[0;35m" + "please enter number of player (3,5):" + "\033[0m");
                numberOfPlayer = in.nextInt();
                if (numberOfPlayer > 5 || numberOfPlayer < 3) {
                    throw new ArithmeticException("invalid number.");
                }
            } catch (Exception e) {
                System.out.println("\033[0;31m" + "format number of player is not valid." + "\033[0m");
                invalid = true;
            }

        } while (invalid);

        for (int i = 0; i < numberOfPlayer; i++) {
            String playerName = "player name";
            int type = 0;
            do {
                invalid = false;
                try {
                    Scanner in = new Scanner(System.in);
                    System.out.println("player " + (i + 1) + " enter your name:");
                    playerName = in.next();
                    boolean valid = false;
                    do {
                        valid = false;
                        try {
                            Scanner client = new Scanner(System.in);
                            System.out.println("pc or human?");
                            System.out.println("1)pc \n2)human");
                            type = client.nextInt();
                            if (!(type == 1 || type == 2)) {
                                throw new ArithmeticException("invalid number.");
                            }
                        } catch (Exception e) {
                            System.out.println("\033[0;31m" + "format type of player is not valid." + "\033[0m");
                            invalid = true;
                        }

                    } while (valid);
                } catch (Exception e) {
                    System.out.println("\033[0;31m" + "format name of player is not valid." + "\033[0m");
                    invalid = true;
                }

            } while (invalid);

            if (type == 1) {
                players.add(new PcPlayer(playerName, i));
            } else if (type == 2) {
                players.add(new HumanPlayer(playerName, i));
            }

        }

        table.prepareTable();
        table.divideCard(players);

    }

    public void start() {

        System.out.println("\n\n*************** game start ***************\n\n");
        Display display = Display.getDisplay();
        Random random = new Random();
        Player p = players.get(random.nextInt(players.size()));
        table.setCurrentPlayer(p);
        display.showTable(players, table);
        table.getPile().getTopCard().effect(table, players);
        System.out.println("effect first card");
        display.showTable(players, table);
        do {
            manageTurn();
            display.showTable(players, table);
        } while (!endGame());       ///////////

    }

    public void finish() {
        Display.getDisplay().scoreTable(players);
    }

    private boolean endGame() {
        for (Player player : players) {
            if (player.getHand().getNumCards() < 1) {
                return true;
            }
        }
        return false;
    }

    public Table getTable() {
        return table;
    }

    public void manageTurn() {

        if (table.getCurrentPlayer() instanceof HumanPlayer) {
            System.out.println("\n");
            System.out.println(table.getCurrentPlayer().getName() + " is your turn");
            System.out.println("This is your hand:\n");
            for (Card card : table.getCurrentPlayer().getHand().getCardList()) {
                card.show();
            }
            table.getCurrentPlayer().play(table, players);


        } else {
            Scanner in = new Scanner(System.in);
            System.out.println(table.getCurrentPlayer().getName() + " is pc player");
            table.getCurrentPlayer().play(table, players);
            System.out.println("please enter any thing then press enter to pass turn");
            table.changeCurrentPlayer(players);
            in.next();
        }
    }
}
