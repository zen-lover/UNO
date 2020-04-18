package Player;

import cards.*;
import game.Table;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, int id) {
        super(name, id);
    }

    public void play(Table table, ArrayList<Player> players){

        if (checkForPlay(table.getPile().getTopCard())){
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
                    if (!table.getCurrentPlayer().getHand().getCardByIndex(choice-1).getColor().equals("BLACK")){
                        ColorfulCard card = (ColorfulCard)table.getCurrentPlayer().getHand().getCardByIndex(choice-1);
                        if (table.getPile().getTopCard().match((table.getCurrentPlayer().getHand().getCardByIndex(choice-1))) ){
                            table.getPile().addCard(table.getCurrentPlayer().getHand().getCard(choice-1));
                            card.effect(table, players);
                            if (!(table.getCurrentPlayer().getHand().getCardByIndex(choice-1) instanceof DrawTwoCard)){
                                for (int i=0; i<table.getBlame(); i++){
                                    table.getCurrentPlayer().takeCard(table.pullCard());
                                }
                                table.setBlame(0);
                            }
                            table.changeCurrentPlayer(players);
                            valid = false;
                        }else{
                            System.out.println("cant choose this card, try another");
                            valid = true;
                        }
                    }else{
                        System.out.println("select card except wild card");
                        valid = true;
                    }

                }catch (Exception e){
                    System.out.println("\033[0;31m"+"format choice of card is not valid."+"\033[0m");
                }

            }while (valid);
        }else {
            if (checkForWild()){
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
                        if (table.getCurrentPlayer().getHand().getCardByIndex(choice-1).getColor().equals("BLACK")){
                            WildCard card = (WildCard)table.getCurrentPlayer().getHand().getCardByIndex(choice-1);
                            if (table.getPile().getTopCard().match((table.getCurrentPlayer().getHand().getCardByIndex(choice-1))) ){
                                System.out.println("enter color for table");
                                String color = in.next();           //set color for wild card
                                card.setColor(color);
                                table.getPile().addCard(table.getCurrentPlayer().getHand().getCard(choice-1));
                                card.effect(table, players);
                                if (!(table.getCurrentPlayer().getHand().getCardByIndex(choice-1) instanceof WildDrawFourCard)){
                                    for (int i=0; i<table.getBlame(); i++){
                                        table.getCurrentPlayer().takeCard(table.pullCard());
                                    }
                                    table.setBlame(0);
                                }
                                table.changeCurrentPlayer(players);
                                valid = false;
                            }else{
                                System.out.println("cant choose this card, try another");
                                valid = true;
                            }
                        }else{
                            System.out.println("select wild card");
                            valid = true;
                        }

                    }catch (Exception e){
                        System.out.println("\033[0;31m"+"format choice of card is not valid."+"\033[0m");
                    }

                }while (valid);
            }else {
                Card card;
                card = table.pullCard();
                takeCard(card);
            }
        }


    }
}
