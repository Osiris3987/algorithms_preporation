import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SubarraySumEqualsK560 {
    public static Pair subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);
        int startIndex = 0;
        int endIndex = -1;
        int count = 0;
        int temp = k;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int reminder = sum - k;
            if(map.containsKey(reminder)){
                endIndex = i;
                //count += map.get(reminder);
                break;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        if(endIndex == -1){
            return new Pair(-1, -1);
        }
        for(int i = endIndex; i > 0; i--){
            temp -= nums[i];
            if(temp == 0){
                startIndex = i;
                break;
            }
        }
        return new Pair(startIndex,endIndex);
    }
    private static class Pair{
        int start;
        int end;

        public Pair(int val, int index) {
            this.start = val;
            this.end = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair pair)) return false;
            return start == pair.start && end == pair.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{10, 2, 1, 3, 2}, 5));
    }
}
