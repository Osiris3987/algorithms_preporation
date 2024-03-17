import java.util.HashMap;
import java.util.HashSet;

public class LineReflection356 {
    public boolean isReflected(int[][] points){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        HashMap<Integer, HashSet<Integer>> ySet = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            min = Math.min(min, x);
            max = Math.max(max, x);
            if(!ySet.containsKey(y)) {
                ySet.put(x, new HashSet<>());
            }
            ySet.get(x).add(y);
        }
        int reflectedLine = min + max;
        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int xPoint = reflectedLine - x;
            if(!ySet.containsKey(xPoint)){
                return false;
            }
            if(!ySet.get(xPoint).contains(y)){
                return false;
            }
        }
        return true;
    }
}
