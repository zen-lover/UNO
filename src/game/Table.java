package game;

import Player.Player;
import cards.*;

import java.util.ArrayList;

public class Table {

    private Pile pile;
    private Deck deck;
    private static Table table = null;
    private boolean clockwise;
    private Player currentPlayer;

    public Table() {
        this.pile = new Pile();
        this.deck = new Deck();
        this.clockwise = true;
    }

//    public static Table getInstance(){
//        if(table == null)
//            table = new Table();
//
//        return table;
//    }

    /**
     * Prepares the table to start the game. The cards (if there is some) in
     * the Discard Pile are put back into the deck and then it is shuffle.
     * Finally, one card is put back in the discard pile.
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
    }


    /**
     * Get the last played card.
     *
     * @return the card on the top of the discard pile.
     */
    public Card showTopCard() {
        return this.pile.getTopCard();
    }

    /**
     * Try to play a card that is in the hand of the current player. If it
     * is possible, then the card is put in the discard pile and its effect
     * is applied in the game.
     *
     * @param card the name of the card that will be played.
     * @return if the operation was successful.
     */
    public boolean pushCard(Card card) {
        if (card == null)
            return false;

        if (this.pile.getTopCard().match(card)) {
            this.pile.addCard(card);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Take a card from the top of the deck. If the deck is empty, then
     * the discard pile is used to provide more cards to the game.
     *
     * @return one card.
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
     * Get the number of cards left in the deck.
     *
     * @return the number of cards in the deck.
     */
    public int getNumCardsOnDeck() {
        return this.deck.getNumCards();
    }


    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void divideCard(ArrayList<Player> players) {
        Card card;

        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                card = pullCard();
                player.takeCard(card);
            }
        }

    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void reverseDirection(ArrayList<Player> players) {
        ArrayList<Player> revArrayList = new ArrayList<Player>();
        for (int i = players.size() - 1; i >= 0; i--) {
            // Append the elements in reverse order
            revArrayList.add(players.get(i));
        }
        // Return the reversed arraylist
        players = revArrayList;

        clockwise = !clockwise;
    }

    public boolean isClockwise() {
        return clockwise;
    }

    public Pile getPile() {
        return pile;
    }
}
