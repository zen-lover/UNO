package cards;

/**
 * Class for Hand
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public class Hand extends CardList {

    /**
     * Construct a hand obj
     */
    public Hand() {
        super();
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

    /**
     * Method for access card with index in list
     * @param index index of card
     * @return Card obj of card
     */
    public Card getCardByIndex(int index) {
        try {
            return this.cardList.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

}
