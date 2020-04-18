package Player;

import cards.Card;
import cards.Hand;
import game.Table;

import java.util.ArrayList;

/**
 * Class for player
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public abstract class Player {

    // player name
    private String name;
    // player hand
    private Hand hand;
    // player id
    private int id;
    // variable for declare player cant move and take card from deck
    boolean takenCard;

    /**
     * Construct a player obj
     *
     * @param name name of player
     * @param id id of player
     */
    public Player(String name, int id) {
        this.name = name;
        this.hand = new Hand();
        this.id = id;
        takenCard = false;
    }

    /**
     * Method for handle turn for player
     * @param table game table
     * @param players players
     */
    public abstract void play(Table table, ArrayList<Player> players);

    /**
     * Method for take card when can't play any card
     * @param card card that want to take
     * @return boolean This returns true if player take card
     */
    public boolean takeCard(Card card) {
        return this.hand.addCard(card);
    }

    /**
     * Method for access to player name
     * @return String player name
     */
    public String getName() {
        return name;
    }

    /**
     * Method for access to hand of player
     * @return This returns player hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Method for access to player id
     * @return This returns player id
     */
    public int getId() {
        return id;
    }

    /**
     * Method for check that player can play any card except wild draw card or not
     * @param Card This is top card on pile
     * @return boolean
     */
    public boolean checkForPlay(Card Card) {

        for (Card card : hand.getCardList()) {
            if (!card.getValue().equals("WILD+4")) {
                if (card.match(Card)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method for check that player can play wild draw card or not
     * @return boolean
     */
    public boolean checkForWildDraw() {

        for (Card card : hand.getCardList()) {
            if (card.getValue().equals("WILD+4")) {
                return true;
            }
        }
        return false;
    }

}
