import java.util.Arrays;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
    int total = 0, n = costs.length / 2;
    for (int i = 0; i < costs.length; i++) {
        total += (i < n) ? costs[i][0] : costs[i][1];
    }
    return total;
}

}
