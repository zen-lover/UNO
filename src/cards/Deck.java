package cards;

import java.util.Random;

public class Deck extends CardList{


    private final static Random sourceRandom = new Random();
    public final static int LENGTH = 108;

    public Deck(){
        for(NumericalCard.Color c:NumericalCard.Color.values()){
            for(int j = 0; j < 2 ; j++) {
                for(NumericalCard.Value v:NumericalCard.Value.values()){
                    if(j == 1 && v.equals(NumericalCard.Value.ZERO) )
                        continue;
                    else
                        cardList.add(new NumericalCard(c,v));
                }
            }
        }

        for(NumericalCard.Color c:NumericalCard.Color.values()){
            for(int j = 0; j < 2 ; j++) {
                cardList.add(new SkipCard(c));
                cardList.add(new ReverseCard(c));
                cardList.add(new DrawTwoCard(c));

            }
        }


        for(int j = 0; j < 4; j++) {
            cardList.add(new WildCard());
            cardList.add(new WildDrawFourCard());
        }

    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() {
        for(int i = cardList.size() - 1; i > 0; --i){
            int index = sourceRandom.nextInt(i);
            Card c = cardList.get(index);
            cardList.set(index,cardList.get(i));
            cardList.set(i,c);
        }
    }

    /**
     * Get a card in the deck.
     * @param i index of the card
     * @return the card.
     */
    public Card get(final int i) {
        try{
            return this.cardList.get(i);

        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    /**
     * Make a string that contains all cards in the deck.
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for(Card c : cardList){ sb.append(c.toString() + " ");}
        return sb.toString();
    }

    /**
     * Add a card in the deck.
     */
    @Override
    public boolean addCard(Card card){
        return this.cardList.add(card);     // PRECISA SER MODIFICADO.
    }

    /**
     * Get a card from the deck.
     */
    @Override
    public Card getCard(int index){
        try{
            return this.cardList.remove(index);
        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }
}
