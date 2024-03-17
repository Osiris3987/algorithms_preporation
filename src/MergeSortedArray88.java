import java.util.Arrays;

public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        merge(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;

        for(int p = k; p >= 0; p--){
            if (i != -1 && j != -1 && nums1[i] > nums2[j]) {
                nums1[p] = nums1[i];
                i--;
            } else if(j != -1) {
                nums1[p] = nums2[j];
                j--;
            }
        }
    }
}
