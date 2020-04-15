package game;
import cards.Card;
import cards.ColorfulCard;
import cards.NumericalCard;


public class Main {

    public static void main(String... args){

        Card card1 = new NumericalCard(NumericalCard.Color.RED, NumericalCard.Value.FIVE);
        Card card2 = new NumericalCard(NumericalCard.Color.RED,NumericalCard.Value.THREE);
        card1.show();
        System.out.println(card1.match(card2));

    }
}
