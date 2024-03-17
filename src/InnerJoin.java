import java.util.*;

public class InnerJoin {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new List[]{innerJoin(new int[][]{{1,2},{2,3},{3,4},{2,6},{1,4}},
                new int[][]{{3,2}, {2,5}, {2,3}})})
        );
    }
    public static List<ArrayList<Integer>> innerJoin(int[][] nums1, int[][] nums2){
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i][0])){
                map.get(nums2[i][0]).add(nums2[i][1]);
            }else {
                map.put(nums2[i][0], new ArrayList<>());
                map.get(nums2[i][0]).add(nums2[i][1]);
            }
        }
        List<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i][0])){
                for(int num: map.get(nums1[i][0])){
                    ans.add(0, new ArrayList<>());
                    ans.get(0).add(nums1[i][0]);
                    ans.get(0).add(nums1[i][1]);
                    ans.get(0).add(num);
                }
            }
        }
        return ans;
    }
}
