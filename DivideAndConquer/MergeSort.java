public class MergeSort {

    public static void print(int arr[]) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void divide(int start, int end, int arr[]) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        divide(start, mid, arr);       // left part: [start...mid]
        divide(mid + 1, end, arr);     // right part: [mid+1...end]
        merge(arr, start, mid, end);   // merge both halves
    }

    public static void merge(int arr[], int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start;     // left pointer
        int j = mid + 1;   // right pointer
        int k = 0;         // temp array pointer

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // Copy back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[start + x] = temp[x];
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 8, 1, 2, 7, 5};
        divide(0, arr.length - 1, arr);
        print(arr);  // ✅ Output: 1 2 4 5 7 8
    }
}
