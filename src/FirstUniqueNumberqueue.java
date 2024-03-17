import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUniqueNumberqueue {
    public Queue<Integer> queue;
    public Map<Integer, Integer> map;
    public FirstUniqueNumberqueue(LinkedList<Integer> list){
        this.queue = list;
        this.map = new HashMap<>();
    }
    public void add(int num){
        queue.offer(num);
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    public int showFirstUnique(){
        while (!queue.isEmpty() && map.get(queue.peek()) != 1) {
            queue.poll();
        }
        return queue.isEmpty() ? -1 : queue.peek();
    }
}
