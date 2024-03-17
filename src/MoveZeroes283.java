import java.util.Arrays;

public class MoveZeroes283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int lastNonZero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[lastNonZero] = nums[i];
                lastNonZero++;
            }
        }
        for(int i = lastNonZero; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
