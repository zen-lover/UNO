package game;

import Player.Player;
import cards.*;

import java.util.ArrayList;

public class Table {

    private Pile pile;
    private Deck deck;
    private boolean clockwise;
    private Player currentPlayer;
    private int blame;

    public Table() {
        this.pile = new Pile();
        this.deck = new Deck();
        this.clockwise = true;
    }

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
        clockwise = !clockwise;
    }

    public boolean isClockwise() {
        return clockwise;
    }

    public Pile getPile() {
        return pile;
    }

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

    public int getBlame() {
        return blame;
    }

    public void setBlame(int blame) {
        this.blame += blame;
    }

    public void resetBlame(int blame) {
        this.blame = blame;
    }


}
