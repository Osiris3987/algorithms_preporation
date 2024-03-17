public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int counter = 0;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[0] = nums[n-1];
        int leftSum = nums[0];
        int rightSum = nums[n-1];
        for(int i = 1; i < n; i++){
            leftSum += nums[i];
        }
        for(int i = n - 2; i >= 0; i--){
            rightSum += nums[i];
        }
        return counter;
    }
}
