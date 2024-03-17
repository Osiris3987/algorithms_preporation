package yandex_contest_demo_2024;

import java.util.*;
import java.io.*;

public class Task2Remake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> firstPlayerCardAmount = new HashMap<>();
        Map<Integer, Integer> secondPlayerCardAmount = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int moves = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            int card = Integer.parseInt(tokenizer.nextToken());
            firstPlayerCardAmount.put(card, firstPlayerCardAmount.getOrDefault(card, 0) + 1);
        }

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < m; i++){
            int card = Integer.parseInt(tokenizer.nextToken());
            secondPlayerCardAmount.put(card, secondPlayerCardAmount.getOrDefault(card, 0) + 1);
        }

        Integer result = countLeftCards(firstPlayerCardAmount, secondPlayerCardAmount);

        for(int i = 0; i < moves; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int eventType = Integer.parseInt(tokenizer.nextToken());
            char player = tokenizer.nextToken().charAt(0);
            int card = Integer.parseInt(tokenizer.nextToken());
            if(player == 'A') {
                result = makeMove(firstPlayerCardAmount, secondPlayerCardAmount, card, eventType, result);
            } else {
                result = makeMove(secondPlayerCardAmount, firstPlayerCardAmount, card, eventType, result);
            }
            System.out.println(result);
        }
        reader.close();
    }

    public static int makeMove(Map<Integer, Integer> m1, Map<Integer, Integer> m2, int card, int eventType, Integer result) {
        if(eventType == 1) {
            int totalBeforePatch = Math.abs(m1.getOrDefault(card, 0) - m2.getOrDefault(card, 0));
            m1.put(card, m1.getOrDefault(card, 0) + 1);
            int totalAfterPatch = Math.abs(m1.getOrDefault(card, 0) - m2.getOrDefault(card, 0));
            if(totalAfterPatch > totalBeforePatch){
                result++;
            }
            else {
                result--;
            }
        } else {
            int totalBeforePatch = Math.abs(m1.getOrDefault(card, 0) - m2.getOrDefault(card, 0));
            if(m1.get(card) == 1) {
                m1.remove(card);
            } else {
                m1.put(card, m1.get(card) - 1);
            }
            int totalAfterPatch = Math.abs(m1.getOrDefault(card, 0) - m2.getOrDefault(card, 0));
            if(totalBeforePatch > totalAfterPatch){
                result--;
            } else {
                result++;
            }
        }
        return result;
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
