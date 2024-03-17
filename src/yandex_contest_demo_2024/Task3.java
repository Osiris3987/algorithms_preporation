package yandex_contest_demo_2024;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        List<String> colNames = new ArrayList<>();
        Map<String, List<Pair>> matrix = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String name = scanner.next();
            colNames.add(name);
            matrix.put(name, new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int val = scanner.nextInt();
                matrix.get(colNames.get(j)).add(new Pair(i, val));
            }
        }
        Map<String, Restriction> restrictions = new HashMap<>();
        for(int i = 0; i < q; i++){
            String s1 = scanner.next();
            String s2 = scanner.next();
            String s3 = scanner.next();
            if(!restrictions.containsKey(s1)){
                restrictions.put(s1, new Restriction());
            }
            if(s2.equals(">")){
                if(Integer.valueOf(s3) > restrictions.get(s1).min || restrictions.get(s1).min == Integer.MIN_VALUE){
                    restrictions.get(s1).min = Integer.valueOf(s3);
                }
            } else {
                if(Integer.valueOf(s3) < restrictions.get(s1).max || restrictions.get(s1).max == Integer.MAX_VALUE){
                    restrictions.get(s1).max = Integer.valueOf(s3);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(m);
        for(int i = 0; i < m; i++) {
            ans.add(new ArrayList<>());
        }
        for(String name: colNames){
            if(restrictions.containsKey(name)){
                Restriction restriction = restrictions.get(name);
                for(Pair pair: matrix.get(name)){
                    if(pair.val > restriction.min && pair.val < restriction.max){
                        ans.get(pair.row).add(pair.val);
                    }
                }
            } else {
                for(Pair pair: matrix.get(name)){
                    ans.get(pair.row).add(pair.val);
                }
            }
        }
        long res = 0;
        for(List<Integer> list: ans) {
            if(list.size() == n){
                for(int el: list){
                    res += el;
                }
            }
        }
        System.out.println(res);
    }
    private static class Restriction{
        public int min;
        public int max;
        {
            min = Integer.MIN_VALUE;
            max = Integer.MAX_VALUE;
        }
    }
    private static class Pair{
        public int row;
        public int val;
        public Pair(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }
}
