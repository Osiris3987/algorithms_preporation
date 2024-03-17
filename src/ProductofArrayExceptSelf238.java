import java.util.Arrays;

public class ProductofArrayExceptSelf238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{4, 0, 4})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int l = nums.length;
        int[] ans = new int[l];
        boolean containsZero = false;

        if(Arrays.stream(nums).filter(e -> e == 0).toArray().length > 1){
            Arrays.fill(ans, 0);
            return ans;
        }

        for (int n : nums) {
            if(n != 0){
                product *= n;
            }
            if(n == 0){
                containsZero = true;
            }
        }

        if(!containsZero) {
            for (int i = 0; i < l; i++) {
                int exceptSelfProduct = product;
                if (nums[i] == 0) {
                    ans[i] = 0;
                } else {
                    ans[i] = exceptSelfProduct / nums[i];
                }
            }
        } else {
            for (int i = 0; i < l; i++) {
                if(nums[i] != 0){
                    ans[i] = 0;
                } else {
                    ans[i] = product;
                }
            }
        }

        return ans;
    }
}
