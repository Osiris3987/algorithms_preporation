import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JewelsAndStones771 {
    public static void main(String[] args) {

    }
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for(char c: jewels.toCharArray()){
            set.add(c);
        }

        int counter = 0;
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) counter++;
        }

        return counter;
    }
}
