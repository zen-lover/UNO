package game;

import Player.*;
import cards.*;

import java.util.*;

public class Display {

    private Display() {
    }

    private static Display display = new Display();

    public static Display getDisplay() {
        return display;
    }

    public void showTable(ArrayList<Player> players, Table table) {

        HashMap<Player, Integer> playerIntegerHashMap = new HashMap<Player, Integer>();
        for (Player player: players){
            playerIntegerHashMap.put(player, player.getId());
        }
        Map<Player, Integer> sortId = sortByValue(playerIntegerHashMap);
        Set<Player> keys = sortId.keySet();
        List<Player> listKeys = new ArrayList<Player>( keys );

        System.out.println("\n\n-------TABLE-------\n\n");
        System.out.printf("direction:");
        if (table.isClockwise()){
            System.out.println("clockwise\n");
        }else{
            System.out.println("anticlockwise\n");
        }
        System.out.printf("current color: "+ table.getPile().getTopCard().getColor());
        System.out.printf("\t\tcurrent value: "+ table.getPile().getTopCard().getValue());
        System.out.printf("\ncurrent player: "+ table.getCurrentPlayer().getName());
        System.out.printf("\t\tnumber of blame card: "+ table.getBlame());
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        int i,j;
        for (i=0; i<listKeys.size()/2; i++){
            System.out.printf("%-22s",listKeys.get(i).getName());
        }
        System.out.println();
        for (j=0; j<listKeys.size()/2; j++){
            System.out.printf("cards: %-15d",listKeys.get(j).getHand().getNumCards());
        }
        System.out.println("\n");
        table.getPile().getTopCard().show();
        System.out.println();
        for (i=listKeys.size()-1; i>=listKeys.size()/2; i--){
            System.out.printf("%-22s",listKeys.get(i).getName());
        }
        System.out.println();
        for (j=listKeys.size()-1; j>=listKeys.size()/2; j--){
            System.out.printf("cards: %-15d",listKeys.get(j).getHand().getNumCards());
        }
        System.out.println();
        System.out.println("----------------------------------------------------------------");


    }


    public void scoreTable(ArrayList<Player> players) {
        HashMap<Player, Integer> scores = new HashMap<Player, Integer>();
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                scores.put(player, 0);
            } else {
                int score = 0;
                for (Card card : player.getHand().getCardList()) {
                    int i = 0;
                    if (card instanceof NumericalCard) {
                        i = Integer.parseInt(card.getValue());
                    } else if (card instanceof MovementCard) {
                        i = 20;
                    } else if (card instanceof WildCard) {
                        i = 50;
                    }
                    score += i;
                }
                scores.put(player, score);
            }
        }
        Map<Player, Integer> sortScore = sortByValue(scores);

        // print the sorted hashmap
        System.out.println("\n\n");
        System.out.println("\033[1;32m"+"Score table:"+"\033[0m\n");
        for (Map.Entry<Player, Integer> en : sortScore.entrySet()) {
            System.out.println("Player = " + en.getKey().getName() +
                    ", Score = " + en.getValue());
        }
        System.out.println("\n");
        for (Map.Entry<Player, Integer> en : sortScore.entrySet()) {
            System.out.println(en.getKey().getName() +
                    " is winner");
            System.out.println("\033[1;35m"+"congratulation"+"\033[0m");
            break;
        }
    }

    public static HashMap<Player, Integer> sortByValue(HashMap<Player, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Player, Integer> > list =
                new LinkedList<Map.Entry<Player, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Player, Integer> >() {
            public int compare(Map.Entry<Player, Integer> o1,
                               Map.Entry<Player, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Player, Integer> temp = new LinkedHashMap<Player, Integer>();
        for (Map.Entry<Player, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
