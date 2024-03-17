package yandex_contest_demo_2024;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> firstPlayerCardAmount = new HashMap<>();
        Map<Integer, Integer> secondPlayerCardAmount = new HashMap<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int moves = scanner.nextInt();

        for(int i = 0; i < n; i++){
            int card = scanner.nextInt();
            firstPlayerCardAmount.put(card, firstPlayerCardAmount.getOrDefault(card, 0) + 1);
        }

        for(int i = 0; i < m; i++){
            int card = scanner.nextInt();
            secondPlayerCardAmount.put(card, secondPlayerCardAmount.getOrDefault(card, 0) + 1);
        }

        int result = countLeftCards(firstPlayerCardAmount, secondPlayerCardAmount);

        for(int i = 0; i < moves; i++){
            int eventType = scanner.nextInt();
            char player = scanner.next().charAt(0);
            int card = scanner.nextInt();
            if(player == 'A') {
                makeMove(firstPlayerCardAmount, card, eventType);
            } else {
                makeMove(secondPlayerCardAmount, card, eventType);
            }
            System.out.print(countLeftCards(firstPlayerCardAmount, secondPlayerCardAmount) + " ");
        }
    }
    public static void makeMove(Map<Integer, Integer> map, int card, int eventType) {
        if(eventType == 1) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        } else {
            if(map.get(card) == 1) {
                map.remove(card);
            } else {
                map.put(card, map.get(card) - 1);
            }
        }
    }

    public static int countLeftCards(Map<Integer, Integer> m1, Map<Integer, Integer> m2) {
        Integer result = 0;
        Set<Integer> countedCards = new HashSet<>();
        for(int k: m1.keySet()){
            if(m2.containsKey(k)){
                result += Math.abs(m1.get(k) - m2.get(k));
            } else {
                result += m1.get(k);
            }
            countedCards.add(k);
        }
        for(int k: m2.keySet()){
            if(!countedCards.contains(k) && m1.containsKey(k)){
                result += Math.abs(m2.get(k) - m1.get(k));
            } else if(!countedCards.contains(k)){
                result += m2.get(k);
            }
        }
        return result;
    }
}
