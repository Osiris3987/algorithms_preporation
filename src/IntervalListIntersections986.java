import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections986 {

    public static void main(String[] args) {

    }

    /*public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < firstList.length && j < secondList.length){
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][2]);
            if(start <= end){
                ans.add(new int[]{start, end});
            }
            if(firstList[i][1] < secondList[j][1]){
                i++;
            } else {
                j++;
            }

        }
        return ans.toArray(new int[0][]);
    }
    */





































    public List<List<Integer>> intervalIntersection(int[][] firstList, int[][] secondList) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i != firstList.length && j != secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if(start <= end) {
                ans.add(List.of(start, end));
            }
            if(firstList[i][1] < secondList[j][1]){
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
