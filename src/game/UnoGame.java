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

        System.out.println("Welcome to UNO game\n");
        boolean invalid;
        int numberOfPlayer = 3;
        do {
            invalid = false;
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("please enter number of player (3,5):");
                numberOfPlayer = in.nextInt();
                if (numberOfPlayer > 5 || numberOfPlayer < 3) {
                    throw new ArithmeticException("invalid number.");
                }
            } catch (Exception e) {
                System.out.println("format number of player is not valid.");
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
                            System.out.println("format type of player is not valid.");
                            invalid = true;
                        }

                    } while (valid);
                } catch (Exception e) {
                    System.out.println("format name of player is not valid.");
                    invalid = true;
                }

            } while (invalid);

            if (type == 1) {
                players.add(new PcPlayer(playerName));
            } else if (type == 2) {
                players.add(new HumanPlayer(playerName));
            }

        }

        table.prepareTable();

        this.divideCard();

    }

    public void start() {

        Display display = Display.getDisplay();
        Random random = new Random();
        Player p = players.get(random.nextInt(players.size()));
        table.setCurrentPlayer(p);
        display.show(players, p);
        do {

        } while (!endGame());

    }

    public void finish() {

    }

    /**
     * Distribute 7 cards to all players in the game.
     *
     * @return true if the operation was successful, false otherwise.
     */
    private boolean divideCard() {
        Card card;

        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                card = this.table.pullCard();
                if (card == null)
                    return false;

                player.takeCard(card);
            }
        }

        return true;
    }

    private boolean endGame() {
        for (Player player : players) {
            if (player.getHand().getNumCards() < 1) {
                return true;
            }
        }
        return false;
    }


}
