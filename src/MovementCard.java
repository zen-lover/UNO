public abstract class MovementCard extends ColorfulCard {


    public MovementCard(Color color, Value value) {
        super(color, value);
    }


    @Override
    public boolean match(Card card){
        if(card.getColor().equals("BLACK"))
            return true;

        return (card.getColor().equals(this.getColor())
                || card.getValue().equals(this.getValue()));
    }
}
