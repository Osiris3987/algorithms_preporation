import java.util.HashSet;
import java.util.Set;

public class RandomizedSet380 {
    Set<Integer> set;

    public RandomizedSet380() {
        set = new HashSet();
    }

    public boolean insert(int val) {
        if(!set.contains(val)){
            set.add(val);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int rand = (int) (Math.random() * set.size());
        return (int) set.toArray()[rand];
    }
}
