package Player;

import cards.*;
import game.Table;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Class for pc player
 *
 * @author Mahdi Saeedi
 * @version 1.0.0
 * @since 2020-04-18
 */
public class PcPlayer extends Player {

    /**
     * Construct a pc player obj
     *
     * @param name player name
     * @param id player id
     */
    public PcPlayer(String name, int id) {
        super(name, id);
    }

    /**
     * Method for handle turn for player
     * @param table game table
     * @param players players
     */
    public void play(Table table, ArrayList<Player> players) {

        if (checkForPlay(table.getPile().getTopCard())) {
//            System.out.println("select card except wild draw card");
            boolean valid = true;
            int choice = 0;
            do {
                valid = true;
//                System.out.println("\nplease choose a card:");
//                System.out.println(table.getCurrentPlayer().getHand().toString());
                try {
                    if (choice < table.getCurrentPlayer().getHand().getNumCards()){         //diff
                        choice ++;
                    }
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
//                            System.out.println("cant choose this card, try another");
                            valid = true;
                        }
                } catch (Exception e) {
//                    System.out.println("\033[0;31m" + "format choice of card is not valid." + "\033[0m");
                }

            } while (valid);
        } else {
            if (checkForWildDraw()) {
//                System.out.println("select wild draw card");
                boolean valid = true;
                int choice = 0;
                do {
                    valid = true;
//                    System.out.println("\nplease choose a card:");
//                    System.out.println(table.getCurrentPlayer().getHand().toString());
                    try {
                        if (choice < table.getCurrentPlayer().getHand().getNumCards()){         //diff
                            choice ++;
                        }
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
//                                System.out.println("cant choose this card, try another");
                                valid = true;
                            }

                    } catch (Exception e) {
//                        System.out.println("\033[0;31m" + "format choice of card is not valid." + "\033[0m");
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
//                        System.out.println("you should take a card");
                        Card card;
                        card = table.pullCard();
                        takeCard(card);
                        takenCard = true;
                    }
                }
            }
        }
    }



}
