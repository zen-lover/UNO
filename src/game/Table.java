package game;

import Player.Player;
import cards.*;

import java.util.ArrayList;

/**
 * Class for table and manage it
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public class Table {

    // pile in table
    private Pile pile;
    // deck in table
    private Deck deck;
    // direction
    private boolean clockwise;
    // current player
    private Player currentPlayer;
    // number of blame card
    private int blame;

    /**
     * Construct a table obj
     */
    public Table() {
        this.pile = new Pile();
        this.deck = new Deck();
        this.clockwise = true;
    }

    /**
     * Method for prepare table and shuffle deck
     */
    public void prepareTable() {
        if (this.pile.getNumCards() != 0) {
            ArrayList<Card> list = pile.takeCardsBack();
            for (int i = 0; i < list.size(); i++)
                this.deck.addCard(list.remove(0));
        }

        deck.shuffle();

        Card card = this.deck.getCard(0);
        while (card.getColor().equals("BLACK")) {     //NullPointerException------8-8-8--8-8-8-8-8-8-8-
            this.deck.addCard(card);
            card = this.deck.getCard(0);
        }

        this.pile.initialize(card);
        blame = 0;
    }

    /**
     * Method for pull card from deck
     * @return Card This returns card that you want to pull
     */
    public Card pullCard() {
        Card card = null;
        if (this.deck.isEmpty()) {
            ArrayList<Card> list = pile.takeCardsBack();
            if (list.size() != 0) {
                for (int i = 0; i < list.size(); i++)
                    card = list.remove(0);

                if (card.getValue().equals("WILD+4"))
                    this.deck.addCard(new WildDrawFourCard());
                else if (card.getValue().equals("WILD"))
                    this.deck.addCard(new WildCard());
                else
                    this.deck.addCard(card);

                this.deck.shuffle();
            } else {
                System.out.println("NO MORE CARDS AVAILABLE");
                return null;
            }
        }

        return this.deck.getCard(0);
    }

    /**
     * Method for set current player
     * @param currentPlayer current player
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Method for divide cards between players before game start
     * @param players List of players
     */
    public void divideCard(ArrayList<Player> players) {
        Card card;

        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                card = pullCard();
                player.takeCard(card);
            }
        }

    }

    /**
     * Method for access to current player
     * @return This returns current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Method for change direction on deck
     */
    public void reverseDirection() {
        clockwise = !clockwise;
    }

    /**
     * Method to show direction
     * @return boolean This returns true if direction is clock wise
     */
    public boolean isClockwise() {
        return clockwise;
    }

    /**
     * Method for access to pile on table
     * @return This returns pile
     */
    public Pile getPile() {
        return pile;
    }

    /**
     * Method for change current player
     * @param players List of players
     */
    public void changeCurrentPlayer(ArrayList<Player> players) {
        if (isClockwise()) {
            if (players.indexOf(currentPlayer) == players.size() - 1) {
                currentPlayer = players.get(0);
            } else {
                currentPlayer = players.get(players.indexOf(currentPlayer) + 1);
            }
        } else {
            if (players.indexOf(currentPlayer) == 0) {
                currentPlayer = players.get(players.size() - 1);
            } else {
                currentPlayer = players.get(players.indexOf(currentPlayer) - 1);
            }
        }
    }

    /**
     * Method for access to number of blame card
     * @return This returns number of blame card
     */
    public int getBlame() {
        return blame;
    }

    /**
     * Method for add to number of blame card
     * @param blame number of blame card that want to add blame card
     */
    public void setBlame(int blame) {
        this.blame += blame;
    }

    /**
     * Method for reset blame card to 0
     * @param blame This is number you want to reset blame to it
     */
    public void resetBlame(int blame) {
        this.blame = blame;
    }


}
