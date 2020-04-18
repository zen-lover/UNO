package cards;

import java.util.ArrayList;

/**
 * Class that store list of cards
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public abstract class CardList {

    // list of cards
    protected ArrayList<Card> cardList;

    /**
     * Construct a list of cards
     */
    public CardList() {
        this.cardList = new ArrayList<Card>();
    }

    /**
     * Method for add card to this list
     * @param card obj off card that want to add
     * @return boolean return true if added successfully
     */
    public abstract boolean addCard(Card card);

    /**
     * Method for access card with index in list
     * @param index index of card
     * @return Card obj of card
     */
    public abstract Card getCard(int index);

    /**
     * Method for access to number of cards in list
     */
    public int getNumCards() {
        return this.cardList.size();
    }

    /**
     * Method that returns list of cards
     * @return ArrayList list pf cards
     */
    public ArrayList<Card> getCardList() {
        return cardList;
    }

    /**
     * Check list is empty or not
     * @return boolean Check list is empty or not
     */
    public boolean isEmpty() {
        if (0 == this.cardList.size())
            return true;
        else
            return false;
    }

    /**
     * Method for convert list to String
     * @return String string that contain all cards color and value
     */
    @Override
    public String toString() {
        int i = 1;
        String string = "\n";
        for (Card card : cardList) {
            string += i + ") color: " + card.getColor()
                    + " value: " + card.getValue() + "\n";
            i++;
        }
        return string;
    }
}

