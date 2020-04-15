import cards.Card;
import cards.ColorfulCard;
import cards.NumericalCard;
import game.UnoGame;

import java.util.Random;


public class Main {

    public static void main(String... args){


        UnoGame game = new UnoGame();
        game.init();
        game.start();

    }
}
