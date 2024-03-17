import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DesignHitCounter {
    public Queue<Integer> queue;

    public DesignHitCounter(){
        queue = new LinkedList<>();
    }
    public void hit(int timeStamp) {
        queue.add(timeStamp);
    }
    public int getHits(int timeStamp) {
        while (queue.size() > 0 && queue.peek() <= timeStamp - 300) {
            queue.poll();
        }
        return queue.size();
    }
}
