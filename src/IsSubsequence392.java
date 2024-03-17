import java.util.HashMap;
import java.util.Map;

public class IsSubsequence392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int j = 0;

        for (int i = 0; i < t.length(); i++){
            if (s.charAt(j) == t.charAt(i)) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                j++;
                if(j == s.length()){
                    return true;
                }
            }
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() != 0){
                return false;
            }
        }

        return true;
    }
}
