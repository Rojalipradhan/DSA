class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int gap = (len + 1) / 2;

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {

                // Both elements are in nums1
                if (left < m && right < m) {
                    if (nums1[left] > nums1[right]) {
                        swap(nums1, left, right);
                    }
                }

                // left is in nums1, right is in nums2
                else if (left < m && right >= m) {
                    if (nums1[left] > nums2[right - m]) {
                        int temp = nums1[left];
                        nums1[left] = nums2[right - m];
                        nums2[right - m] = temp;
                    }
                }

                // Both elements are in nums2
                else {
                    if (nums2[left - m] > nums2[right - m]) {
                        swap(nums2, left - m, right - m);
                    }
                }

                left++;
                right++;
            }

            if (gap == 1)
                break;

            gap = (gap + 1) / 2;
        }
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}