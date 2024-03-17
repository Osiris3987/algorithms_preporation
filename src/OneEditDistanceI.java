import java.util.Objects;

public class OneEditDistanceI {
    public static void main(String[] args) {
        String[] cities = {"MSK", "SPB", "EKT", "NNOV"}; // 1
// 2
        int index = -1;// 3
        System.out.println(cities[index]); // 4
// 5
        for (int i = 0; i <= cities.length; i++) { // 6
            System.out.println(cities[i]); // 7
        } // 8
// 9
        for (int i = 0; i < cities.length; i++) { // 10
            System.out.println(cities[i]); // 11
        } // 12
// 13
        System.out.println(cities[index]);// 15
    }
    static class Dog {
        String name;
        float age;
        int weight;
        String color;
        boolean waggingItsTail;
    }
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return Objects.equals(s.substring(i + 1), t.substring(i + 1));
                }
                if (s.length() < t.length()) {
                    return Objects.equals(s.substring(i), t.substring(i + 1));
                } else {
                    return Objects.equals(s.substring(i + 1), t.substring(i));
                }
            }
        }

        // case: abc, abcdefg
        return Math.abs((int) s.length() - (int) t.length()) == 1;
    }
}
