package cards;

import java.util.ArrayList;

/**
 * Class for pile
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public class Pile extends CardList {

    /**
     * Construct Pile obj
     */
    public Pile() {
        //super();
    }

    /**
     * Method for add card to this list
     * @param card obj off card that want to add
     * @return boolean return true if added successfully
     */
    @Override
    public boolean addCard(Card card) {
        if (this.getTopCard() == null)
            return false;

        return this.cardList.add(card);
    }

    /**
     * Method for initialize pile
     * @param card first card for top card in pile
     */
    public void initialize(Card card) {
        if (this.cardList.size() == 0)
            this.cardList.add(card);
    }

    /**
     * Method for access card with index in list
     * @param index index of card
     * @return Card obj of card
     */
    @Override
    public Card getCard(int index) {
        return null;
    }

    /**
     * Method for top card in pile
     * @return Card This returns top card in pile
     */
    public Card getTopCard() {
        Card top;

        try {
            top = cardList.get(cardList.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            top = null;
        }

        return top;
    }

    /**
     * Method for take cards back when deck is empty
     * @return ArrayList list of cards that take back
     */
    public ArrayList<Card> takeCardsBack() {
        ArrayList<Card> newDeck = new ArrayList<Card>();

        while (this.cardList.size() > 1) {
            newDeck.add(this.cardList.remove(0));
        }

        return newDeck;
    }
}
