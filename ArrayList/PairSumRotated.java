import java.util.*;

public class PairSumRotated {

    public static boolean checksum(ArrayList<Integer> list, int target) {
        int LP = -1, RP = -1;
        
        // Find the pivot point (largest element)
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                RP = i;
                LP = (i + 1) % list.size();
                break;
            }
        }
        
        // If no pivot found, it means the array is not rotated
        if (RP == -1) {
            RP = list.size() - 1;
            LP = 0;
        }
        
        // Two pointer approach
        while (LP != RP) {
            int sum = list.get(LP) + list.get(RP);
            if (sum == target) {
                return true;
            }
            if (sum < target) {
                LP = (LP + 1) % list.size();
            } else {
                RP = (RP - 1 + list.size()) % list.size();
            }
        }
        
        return false; // No pair found
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(checksum(list, 16)); // true (6 + 10)
        System.out.println(checksum(list, 21)); // true (11 + 10)
        System.out.println(checksum(list, 27)); // false
    }
}
