import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstUniqueCharacterInAString387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String inp) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < inp.length(); i++){
            map.put(inp.charAt(i), map.getOrDefault(inp.charAt(i), 0) + 1);
        }

        Character firstUniqChar = ' ';

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                firstUniqChar = entry.getKey();
                break;
            }
        }

        for(int i = 0; i < inp.length(); i++){
            if(inp.charAt(i) == firstUniqChar){
                return i;
            }
        }
        return -1;
    }

}
