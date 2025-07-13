import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter {
    class HitCounter {
    Queue<Integer> q;

    public HitCounter() {
        q = new LinkedList<>();
    }

    public void hit(int timestamp) {
        q.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!q.isEmpty() && q.peek() <= timestamp - 300) {
            q.poll();
        }
        return q.size();
    }
}

}
