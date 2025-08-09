package Greedy;

import java.util.Arrays;

public class AssignCookies {
    class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);

        int max=0;
       int cookie=0;
       int greed=0;

       while (cookie<s.length) {
        if(s[cookie]>=g[greed]){
            max++;
            cookie++;
            greed++;
        }
        else{
            cookie++;
        }
        
       }

      return max;
    }
}
}
