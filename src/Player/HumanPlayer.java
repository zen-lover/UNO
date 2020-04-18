package Player;

import cards.*;
import game.Table;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for human player
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public class HumanPlayer extends Player {

    /**
     * Construct a human player obj
     *
     * @param name player name
     * @param id player id
     */
    public HumanPlayer(String name, int id) {
        super(name, id);
    }

    /**
     * Method for handle turn for player
     * @param table game table
     * @param players players
     */
    public void play(Table table, ArrayList<Player> players) {

        if (checkForPlay(table.getPile().getTopCard())) {
            System.out.println("select card except wild Draw card");
            boolean valid = true;
            do {
                valid = true;
                int choice = 0;
                System.out.println("\nplease choose a card:");
                System.out.println(table.getCurrentPlayer().getHand().toString());
                try {
                    Scanner in = new Scanner(System.in);
                    choice = in.nextInt();
                        ColorfulCard card = (ColorfulCard) table.getCurrentPlayer().getHand().getCardByIndex(choice - 1);
                        if (table.getPile().getTopCard().match((table.getCurrentPlayer().getHand().getCardByIndex(choice - 1)))) {
                            if (!(card instanceof DrawTwoCard)) {
                                int i;
                                for (i = 0; i < table.getBlame(); i++) {
                                    table.getCurrentPlayer().takeCard(table.pullCard());
                                }
                                table.resetBlame(0);
                                if (i > 0) {
                                    table.changeCurrentPlayer(players);
                                    return;
                                }
                            }
                            table.getPile().addCard(table.getCurrentPlayer().getHand().getCard(choice - 1));
                            card.effect(table, players);

                            table.changeCurrentPlayer(players);
                            valid = false;
                        } else {
                            System.out.println("cant choose this card, try another");
                            valid = true;
                        }

                } catch (Exception e) {
                    System.out.println("\033[0;31m" + "format choice of card is not valid." + "\033[0m");
                }

            } while (valid);
        } else {
            if (checkForWildDraw()) {
                System.out.println("select wild Draw card");
                boolean valid = true;
                do {
                    valid = true;
                    int choice = 0;
                    System.out.println("\nplease choose a card:");
                    System.out.println(table.getCurrentPlayer().getHand().toString());
                    try {
                        Scanner in = new Scanner(System.in);
                        choice = in.nextInt();
                            WildCard card = (WildCard) table.getCurrentPlayer().getHand().getCardByIndex(choice - 1);
                            if (table.getPile().getTopCard().match((table.getCurrentPlayer().getHand().getCardByIndex(choice - 1)))) {
                                if (!(card instanceof WildDrawFourCard)) {
                                    int i;
                                    for (i = 0; i < table.getBlame(); i++) {
                                        table.getCurrentPlayer().takeCard(table.pullCard());
                                    }
                                    table.resetBlame(0);
                                    if (i > 0) {
                                        table.changeCurrentPlayer(players);
                                        return;
                                    }
                                }
                                table.getPile().addCard(card);
                                table.getCurrentPlayer().getHand().getCard(choice - 1);
                                card.effect(table, players);

                                table.changeCurrentPlayer(players);
                                valid = false;
                            } else {
                                System.out.println("cant choose this card, try another");
                                valid = true;
                            }

                    } catch (Exception e) {
                        System.out.println("\033[0;31m" + "format choice of card is not valid." + "\033[0m");
                    }

                } while (valid);
            } else {
                if (takenCard) {
                    table.changeCurrentPlayer(players);
                    takenCard = false;
                } else {
                    if (table.getBlame() > 0) {
                        int i;
                        for (i = 0; i < table.getBlame(); i++) {
                            table.getCurrentPlayer().takeCard(table.pullCard());
                        }
                        table.resetBlame(0);
                        if (i > 0) {
                            table.changeCurrentPlayer(players);
                            return;
                        }
                    } else {
                        System.out.println("you should take a card");
                        Card card;
                        card = table.pullCard();
                        takeCard(card);
                        Scanner in = new Scanner(System.in);
                        System.out.println("please enter anything then press enter to take card");
                        in.next();
                        takenCard = true;
                    }
                }
            }
        }


    }


}
