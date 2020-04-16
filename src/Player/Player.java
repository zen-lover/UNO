package Player;

import cards.Card;
import cards.Hand;

public class Player {

    private  String name;
    private Hand hand;
    private int id;

    public Player(String name, int id) {
        this.name = name;
        this.hand = new Hand();
        this.id = id;
    }

    public boolean takeCard(Card card){
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
}
