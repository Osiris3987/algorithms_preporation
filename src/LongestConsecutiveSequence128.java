import java.util.*;

public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {

        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                int length = left + right + 1;
                maxLength = Math.max(maxLength, length);

                map.put(n, length);

                if (left > 0) {
                    map.put(n - left, length);
                }

                if (right > 0) {
                    map.put(n + right, length);
                }
            }
        }
        return maxLength;
    }
}
