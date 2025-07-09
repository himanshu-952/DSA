public class RotatedArray {

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int search(int arr[], int start, int end, int key) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        // Check if the left half is sorted
        if (arr[start] <= arr[mid]) {
            if (key >= arr[start] && key < arr[mid]) {
                return search(arr, start, mid - 1, key);
            } else {
                return search(arr, mid + 1, end, key);
            }
        }

        // Right half must be sorted
        else {
            if (key > arr[mid] && key <= arr[end]) {
                return search(arr, mid + 1, end, key);
            } else {
                return search(arr, start, mid - 1, key); // fixed wrong argument order
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 7, 8, 10, 0, 1, 2};
        System.out.println(search(arr, 0, arr.length - 1, 10)); // Output should be index of 10
    }
}
