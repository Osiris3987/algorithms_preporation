import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals56 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[][]{{1,4}, {2, 3}})));
        System.out.println(10%11);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while(i <= intervals.length - 1){
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(i+1 != intervals.length && isIntersected(intervals[i], intervals[i+1])){
                end = Math.max(intervals[i][1], intervals[i+1][1]);
                i++;
            }
            res.add(Arrays.asList(start, end));
            i++;
        }
        int n = res.size();
        int[][] ints = new int[n][2];
        for(int j = 0; j < n; j++){
            ints[j][0] = res.get(j).get(0);
            ints[j][1] = res.get(j).get(1);
        }
        if(intervals.length == 1){
            return new int[][]{{intervals[0][0], intervals[0][1]}};
        }
        return ints;
    }

    private static boolean isIntersected(int[] interval1, int[] interval2){
        return (interval1[1] >= interval2[0] && interval1[1] <= interval2[1]) || (interval1[0] <= interval2[0] && interval1[1] >= interval2[1]);
    }
}
