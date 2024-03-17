public class LongestSubarrayOf1AfterDeletingOneEl1493Remake {
    public static void main(String[] args) {
        System.out.println(longestSubarrayOf1AfterDeletingOneElement(new int[]{1,1,0,1}));
    }
    public static int longestSubarrayOf1AfterDeletingOneElement(int[] nums){
        int ans = 0;
        int cur = 0;
        int prev = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                cur++;
            } else {
                ans = Math.max(ans, cur + prev + 1);
                prev = cur;
                cur = 0;
            }
        }
        return ans == nums.length ? nums.length - 1 : ans;
    }
}
