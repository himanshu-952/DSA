import java.util.LinkedList;
import java.util.Queue;

public class Dota2senate {
    class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') r.add(i);
            else d.add(i);
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int ri = r.poll(), di = d.poll();
            if (ri < di) r.add(ri + n);
            else d.add(di + n);
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}

}
