package Player;

import cards.Card;
import cards.Hand;
import game.Table;

import java.util.ArrayList;

public abstract class Player {

    private String name;
    private Hand hand;
    private int id;
    private boolean takenCard;

    public Player(String name, int id) {
        this.name = name;
        this.hand = new Hand();
        this.id = id;
        takenCard = false;
    }

    public abstract void play(Table table, ArrayList<Player> players);

    public boolean takeCard(Card card) {
        return this.hand.addCard(card);
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public int getId() {
        return id;
    }

    public boolean checkForPlay(Card tableCard) {

        for (Card card : hand.getCardList()) {
            if (!card.getColor().equals("BLACK")) {
                if (card.match(tableCard)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForWild() {

        for (Card card : hand.getCardList()) {
            if (card.getColor().equals("BLACK")) {
                return true;
            }
        }
        return false;
    }

}
