package cards;

public class Hand extends CardList{

    public Hand(){
        super();
    }


    @Override
    public boolean addCard(Card card){
        return this.cardList.add(card);
    }


    @Override
    public Card getCard(int index){
        try{
            return this.cardList.remove(index);
        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    public String showCard(int index){
        try{
            return this.cardList.get(index).toString();
        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    public Card getCardByIndex(int index){
        try{
            return this.cardList.get(index);
        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }

}
