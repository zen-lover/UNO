package cards;

import java.util.ArrayList;

public abstract class CardList {

    protected ArrayList<Card> cardList;

    public CardList(){
        this.cardList = new ArrayList<Card>();
    }

    public abstract boolean addCard(Card card);
    public abstract Card getCard(int index);

    public int getNumCards(){
        return this.cardList.size();
    }

    public ArrayList<Card> getCardList() {
        return cardList;
    }

    public boolean isEmpty(){
        if(0 == this.cardList.size())
            return true;
        else
            return false;
    }
}

