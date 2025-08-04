public class MergeSortedArrays {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;         // Last index of nums1's meaningful part
            int j = n - 1;         // Last index of nums2
            int k = m + n - 1;     // Last index of nums1

            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[k--] = nums1[i--];
                } else {
                    nums1[k--] = nums2[j--];
                }
            }

            // If any elements left in nums2
            while (j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
