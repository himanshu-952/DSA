import java.util.Collections;
import java.util.PriorityQueue;

public class halfArrSum {
    class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double total = 0;
        for (int num : nums) {
            total += num;
            maxHeap.offer((double) num);
        }

        int ops = 0;
        double reduced = 0;
        while (reduced < total / 2) {
            double top = maxHeap.poll();
            reduced += top / 2;
            maxHeap.offer(top / 2);
            ops++;
        }
        return ops;
    }
}

}
