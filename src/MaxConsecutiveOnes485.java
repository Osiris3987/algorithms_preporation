public class MaxConsecutiveOnes485 {
    public static void main(String[] args) {

    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                counter++;
            }else {
                ans = Math.max(ans, counter);
                counter = 0;
            }
        }
        return Math.max(ans, counter);
    }
}
