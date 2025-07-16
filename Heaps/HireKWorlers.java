import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HireKWorlers {
    class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i] = new double[]{(double) wage[i] / quality[i], quality[i]};
        }
        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));

        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double qualitySum = 0, minCost = Double.MAX_VALUE;

        for (double[] worker : workers) {
            maxHeap.add(worker[1]);
            qualitySum += worker[1];

            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, qualitySum * worker[0]);
            }
        }
        return minCost;
    }
}

}
