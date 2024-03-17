import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-1,-2,-3,-4,-5}, -8)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            map.put(i, numbers[i]);
        }

        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length - 1;
        int[] ans = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
            if(numbers[left] + numbers[right] == target){
                ans[0] = numbers[left];
                ans[1] = numbers[right];
                break;
            }
        }
        int index = 0;
        int[] finalAns = new int[2];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == ans[0] || entry.getValue() == ans[1]){
                finalAns[index] = entry.getKey();
                index++;
            }
            if(index > 1) break;
        }
        Arrays.sort(finalAns);
        return finalAns;
    }
}
