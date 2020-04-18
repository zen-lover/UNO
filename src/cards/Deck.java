package cards;

import java.util.Random;

/**
 * Class for deck
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public class Deck extends CardList {

    // random variable for shuffle
    private final static Random sourceRandom = new Random();
    // number of card on deck
    public final static int LENGTH = 108;

    /**
     * Construct a deck and create 108 card
     */
    public Deck() {
        for (NumericalCard.Color c : NumericalCard.Color.values()) {
            for (int j = 0; j < 2; j++) {
                for (NumericalCard.Value v : NumericalCard.Value.values()) {
                    if (j == 1 && v.equals(NumericalCard.Value.ZERO))
                        continue;
                    else
                        cardList.add(new NumericalCard(c, v));
                }
            }
        }

        for (NumericalCard.Color c : NumericalCard.Color.values()) {
            for (int j = 0; j < 2; j++) {
                cardList.add(new SkipCard(c));
                cardList.add(new ReverseCard(c));
                cardList.add(new DrawTwoCard(c));

            }
        }


        for (int j = 0; j < 4; j++) {
            cardList.add(new WildCard());
            cardList.add(new WildDrawFourCard());
        }

    }

    /**
     * When game start we shuffle deck
     */
    public void shuffle() {
        for (int i = cardList.size() - 1; i > 0; --i) {
            int index = sourceRandom.nextInt(i);
            Card c = cardList.get(index);
            cardList.set(index, cardList.get(i));
            cardList.set(i, c);
        }
    }

    /**
     * Method for convert list to String
     * @return String string that contain all cards color and value
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Card c : cardList) {
            sb.append(c.toString() + " ");
        }
        return sb.toString();
    }

    /**
     * Method for add card to this list
     * @param card obj off card that want to add
     * @return boolean return true if added successfully
     */
    @Override
    public boolean addCard(Card card) {
        return this.cardList.add(card);
    }

    /**
     * Method for access card with index in list
     * @param index index of card
     * @return Card obj of card
     */
    @Override
    public Card getCard(int index) {
        try {
            return this.cardList.remove(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
