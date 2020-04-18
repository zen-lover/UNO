import cards.Card;
import cards.ColorfulCard;
import cards.NumericalCard;
import cards.WildDrawFourCard;
import game.UnoGame;

import java.util.Random;

/**
 * Main class for driven
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public class Main {

    /**
     * Method to drive
     */
    public static void main(String... args){

        UnoGame game = new UnoGame();
        game.init();
        game.start();
        game.finish();

    }
}
