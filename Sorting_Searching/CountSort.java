public class CountSort {
    public static void countingSort(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int num : arr) max = Math.max(max, num);

    int[] count = new int[max + 1];

    for (int num : arr) {
        count[num]++;
    }

    int index = 0;
    for (int i = 0; i < count.length; i++) {
        while (count[i]-- > 0) {
            arr[index++] = i;
        }
    }
}

}
