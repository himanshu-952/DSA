package Greedy;
import java.util.Arrays;

public class PlatformsRequired {

    static class Solution {

        public int findPlatform(int[] Arrival, int[] Departure) {
            Arrays.sort(Arrival);
            Arrays.sort(Departure);

            int n = Arrival.length;
            int plat_needed = 1, maxPlat = 1;
            int i = 1, j = 0;

            while (i < n && j < n) {
                if (Arrival[i] <= Departure[j]) {
                    plat_needed++;
                    i++;
                } else {
                    plat_needed--;
                    j++;
                }
                maxPlat = Math.max(maxPlat, plat_needed);
            }

            return maxPlat;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(s.findPlatform(arr, dep)); // Output: 3
    }
}
