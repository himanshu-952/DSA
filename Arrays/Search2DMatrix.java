public class Search2DMatrix {
    class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0, high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target)
                return true;
            else if (midValue < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
    }
}

}
