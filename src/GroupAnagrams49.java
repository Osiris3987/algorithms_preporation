import java.util.*;

public class GroupAnagrams49 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new List[]{groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = Arrays.toString(charArray);
            if(!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
