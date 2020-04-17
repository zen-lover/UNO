package cards;

public abstract class Card {

    public abstract String getColor();

    public abstract String getValue();

    public abstract void show();

    public abstract boolean match(Card card);


}
