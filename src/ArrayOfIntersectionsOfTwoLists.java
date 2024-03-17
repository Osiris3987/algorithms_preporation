import java.util.*;

public class ArrayOfIntersectionsOfTwoLists {
    public static int[] intersection(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] ans = new int[n];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int counter = 0;
        for(int i = 0; i < n; i++){
            if(arr1[i] == arr2[i]) {
                counter++;
            } else if((set1.contains(arr2[i]) && set1.add(arr1[i]))) {
                counter++;
            } else if(set2.contains(arr1[i]) && set2.add(arr2[i])){
                counter++;
            }else {
                set1.add(arr1[i]);
                set2.add(arr2[i]);
            }
            ans[i] = counter;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1,3,3,1,1}, new int[]{0, 1,1,5,3})));
        System.out.println(Arrays.toString(intersection(new int[]{1, 1, 2, 3}, new int[]{2, 1, 3, 1})));
    }
}
