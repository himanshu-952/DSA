import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReveaklCards {
    class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) q.add(i);

        int[] result = new int[n];
        for (int card : deck) {
            int index = q.poll();
            result[index] = card;
            if (!q.isEmpty()) q.add(q.poll());
        }

        return result;
    }
}

}
