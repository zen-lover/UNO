package Player;

import cards.*;
import game.Table;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, int id) {
        super(name, id);
    }

    public void play(Table table, ArrayList<Player> players) {

        if (checkForPlay(table.getPile().getTopCard())) {
            System.out.println("select card except wild card");
            boolean valid = true;
            do {
                valid = true;
                int choice = 0;
                System.out.println("\nplease choose a card:");
                System.out.println(table.getCurrentPlayer().getHand().toString());
                try {
                    Scanner in = new Scanner(System.in);
                    choice = in.nextInt();
                    if (!table.getCurrentPlayer().getHand().getCardByIndex(choice - 1).getColor().equals("BLACK")) {
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
                    } else {
                        System.out.println("select card except wild card");
                        valid = true;
                    }

                } catch (Exception e) {
                    System.out.println("\033[0;31m" + "format choice of card is not valid." + "\033[0m");
                }

            } while (valid);
        } else {
            if (checkForWild()) {
                System.out.println("select wild card");
                boolean valid = true;
                do {
                    valid = true;
                    int choice = 0;
                    System.out.println("\nplease choose a card:");
                    System.out.println(table.getCurrentPlayer().getHand().toString());
                    try {
                        Scanner in = new Scanner(System.in);
                        choice = in.nextInt();
                        if (table.getCurrentPlayer().getHand().getCardByIndex(choice - 1).getColor().equals("BLACK")) {
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
                                changeColor(card);
                                table.getPile().addCard(card);
                                table.getCurrentPlayer().getHand().getCard(choice - 1);
                                card.effect(table, players);

                                table.changeCurrentPlayer(players);
                                valid = false;
                            } else {
                                System.out.println("cant choose this card, try another");
                                valid = true;
                            }
                        } else {
                            System.out.println("select wild card");
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
                        takenCard = true;
                    }
                }
            }
        }


    }

    public void changeColor(WildCard card) {
        System.out.println("choose color for table");
        int i = 1;
        try {
            for (NumericalCard.Color color : NumericalCard.Color.values()) {
                System.out.println(i + ") " + color.toString());
                i++;
            }
        } catch (Exception e) {
            System.out.println("format choice of card is not valid.");
        }

        Scanner in = new Scanner(System.in);
        int color = in.nextInt();           //set color for wild card
        card.setColor(NumericalCard.Color.values()[color - 1].toString());

    }

}
