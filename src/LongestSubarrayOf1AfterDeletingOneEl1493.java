
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LongestSubarrayOf1AfterDeletingOneEl1493 {

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,1}));
    }


    public static int longestSubarray(int[] nums) {
        List<Pair> pairsOfOnes = new ArrayList<>();
        int start = 0;
        int end = 0;
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == 0 && nums[i] == 1) {
                start = i;
                end = i;
            }
            if (nums[i] == 1) {
                end = i;
            }
            if(i > 0 && nums[i-1] == 1 &&nums[i] == 0 && !pairsOfOnes.contains(new Pair(start, end))){
                pairsOfOnes.add(new Pair(start, end));
            }
        }

        if(nums[n-1] != 0){
            pairsOfOnes.add(new Pair(start, end));
        }
        int maxLength = 0;
        //смотрим разницу между концом предыдущего и началом следущего
        for (int i = 0; i < pairsOfOnes.size(); i++) {
            if(i != pairsOfOnes.size() - 1 && pairsOfOnes.get(i+1).start - 2 == pairsOfOnes.get(i).end){
                maxLength = Math.max(maxLength,pairsOfOnes.get(i+1).end - pairsOfOnes.get(i).start);
            } else {
                maxLength = Math.max(maxLength,  pairsOfOnes.get(i).end - pairsOfOnes.get(i).start + 1);
            }
        }


        if(pairsOfOnes.size() == 1 && !containsZero(nums)){
            return pairsOfOnes.get(0).end;
        }
        if(pairsOfOnes.size() == 1){
            return pairsOfOnes.get(0).end - pairsOfOnes.get(0).start + 1;
        }


        return maxLength;
    }
    private static boolean containsZero(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                return true;
            }
        }
        return false;
    }
}

class Pair{
    Integer start;
    Integer end;

    public Pair(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return start.equals(pair.start) && end.equals(pair.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}