public class NumericalCard extends ColorfulCard {


    public NumericalCard(Color color, Value value) {
        super(color, value);
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public void show() {
        super.show();
    }


    @Override
    public boolean match(Card card){
        if(card.getColor().equals("BLACK"))
            return true;

        return (card.getColor().equals(this.getColor())
                || card.getValue().equals(this.getValue()));
    }

}
