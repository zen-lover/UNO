package cards;

import java.util.ArrayList;

public class Pile extends CardList {
    public Pile(){
        //super();
    }

    /**
     * Add an card on the top of the pile.
     */
    @Override
    public boolean addCard(Card card){
        if(this.getTopCard() == null)
            return false;

        if(!this.getTopCard().match(card))
            return false;

        return this.cardList.add(card);
    }

    /**
     * Starts the discard pile putting the first card.
     * @param card : the first card in the pile.
     */
    public void initialize(Card card){
        if(this.cardList.size() == 0)
            this.cardList.add(card);
    }

    /**
     * This operation is not allowed in this class, since the only way to
     * remove cards from this collection is removing all but the top.
     */
//    @Override
//    public Card getCard(int index){
//        throw new UnsupportedOperationException("Operation not allowed.");
//    }


    @Override
    public Card getCard(int index) {
        return null;
    }

    /**
     * This function get the last card discarded in the game.
     * @return the card on the top of the discard pile.
     */
    public Card getTopCard(){
        Card top;

        try{
            top = cardList.get(cardList.size()-1);
        }catch(IndexOutOfBoundsException e){
            top = null;
        }

        return top;
    }

    /**
     * This method take the cards in the Discard Pile and make a new deck.
     * Only the last discarded card remains after this operation.
     * @return a list with all the cards but the top.
     */
    public ArrayList<Card> takeCardsBack(){
        ArrayList<Card> newDeck = new ArrayList<Card>();

        while(this.cardList.size() > 1){
            newDeck.add(this.cardList.remove(0));
        }

        return newDeck;
    }
}
