package Greedy;

import java.util.Arrays;


public class Nmeetings {
   

class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        int[][] meetings = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            meetings[i][0] = i;         // index
            meetings[i][1] = start[i];  // start time
            meetings[i][2] = end[i];    // end time
        }

       
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        int count = 1; // first meeting always selected
        int lastEnd = meetings[0][2];

        for (int i = 1; i < n; i++) {
            if (meetings[i][1] > lastEnd) {
                count++;
                lastEnd = meetings[i][2];
            }
        }
        return count;
    }
}

}
