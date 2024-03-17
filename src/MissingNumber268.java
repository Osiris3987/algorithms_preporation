public class MissingNumber268 {
    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = 0;

        for(int i = 0; i <= n; i++){
            total += i;
        }

        for(int i = 0; i < n; i++){
            total -= nums[i];
        }

        return total;
    }
}
