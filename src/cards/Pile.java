package cards;

import java.util.ArrayList;

public class Pile extends CardList {
    public Pile() {
        //super();
    }

    @Override
    public boolean addCard(Card card) {
        if (this.getTopCard() == null)
            return false;

        return this.cardList.add(card);
    }

    public void initialize(Card card) {
        if (this.cardList.size() == 0)
            this.cardList.add(card);
    }

    @Override
    public Card getCard(int index) {
        return null;
    }

    public Card getTopCard() {
        Card top;

        try {
            top = cardList.get(cardList.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            top = null;
        }

        return top;
    }

    public ArrayList<Card> takeCardsBack() {
        ArrayList<Card> newDeck = new ArrayList<Card>();

        while (this.cardList.size() > 1) {
            newDeck.add(this.cardList.remove(0));
        }

        return newDeck;
    }
}
