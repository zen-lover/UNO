package cards;

public class WildDrawFourCard extends WildCard{

    private Value value;

    public WildDrawFourCard(){
        super();
        this.value = Value.WILDDRAWFOUR;
    }

    @Override
    public String getValue(){
        return this.value.toString();
    }

}
