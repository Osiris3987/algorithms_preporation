import java.util.ArrayList;
import java.util.List;

public class MaximizeDistanceToClosestPerson849 {
    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{0,1}));
    }
    public static int maxDistToClosest(int[] seats) {
        int count = 0;
        int max = 0;
        int j = 0;
        if(seats[j] == 0){
            while(j < seats.length && seats[j] == 0){
                count++;
                j++;
            }
            max = Math.max(max, count);
            count = 0;
        }
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 0) {
                count++;
            } else {
                if(count % 2 == 1){
                    max = Math.max(max, count/2+1);
                } else {
                    max = Math.max(max, count/2);
                }
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
