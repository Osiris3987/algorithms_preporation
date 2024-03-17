public class MaxConsecutiveOnesIII1004 {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
    public static int longestOnes(int[] nums, int k) {
        int windowSize = 0;
        int windowStart = 0;
        int zeroesCount = 0;
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++){
            if(nums[windowEnd] == 0) {
                zeroesCount++;
            }
            while (windowStart < nums.length && zeroesCount > k) {
                if(nums[windowStart] == 0) {
                    zeroesCount--;
                }
                windowStart++;
            }
            windowSize = Math.max(windowSize, windowEnd - windowStart + 1);
        }
        return windowSize;
    }
}
