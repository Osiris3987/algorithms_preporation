import java.util.HashMap;
import java.util.Map;

public class PermutationInString567 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }
    public static boolean checkInclusion(String s1, String s2){

        Map<Character, Integer> m1 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            m1.put(s1.charAt(i), m1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for(int i = 0; i <= s2.length() - s1.length(); i++){
            Map<Character, Integer> m2 = new HashMap<>();
            for (int j = i; j < i + s1.length(); j++) {
                m2.put(s2.charAt(j), m2.getOrDefault(s2.charAt(j), 0) + 1);
            }
            if (m1.equals(m2)) {
                return true;
            }
        }
        return false;
    }

}
