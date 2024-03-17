import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionofTwoArraysII350 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num: nums2){
            if(map.containsKey(num) && map.get(num) != 0){
                ans.add(num);
                map.put(num, map.get(num)-1);
            }
        }

        int n = ans.size();

        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
