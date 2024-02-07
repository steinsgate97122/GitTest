import java.util.Arrays;

public class Lee88_Merge {
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] mergeNums = new int[m + n];
        // 遍历两个数组，将较小的塞入新数组
        int i = 0;
        int j = 0;
        int k = 0;
        while ((i < m) && (j < n)) {
            if (nums1[i] < nums2[j]) {
                mergeNums[k] = nums1[i];
                k = k + 1;
                i = i + 1;
            } else {
                mergeNums[k] = nums2[j];
                k = k + 1;
                j = j + 1;
            }
        }
        // 将剩余没塞进去的数字塞进数组
        while (i < m) {
            mergeNums[k] = nums1[i];
            k = k + 1;
            i = i + 1;
        }
        while (j < n) {
            mergeNums[k] = nums2[j];
            k = k + 1;
            j = j + 1;
        }
        System.arraycopy(mergeNums, 0, nums1, 0, m + n);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前遍历，可以直接在nums1中更新
        int end = m + n - 1;
        m = m - 1;
        n = n - 1;
        while ((m >= 0) && (n >= 0)) {
            if (nums1[m] < nums2[n]) {
                nums1[end] = nums2[n];
                end = end - 1;
                n = n - 1;
            } else {
                nums1[end] = nums1[m];
                end = end - 1;
                m = m - 1;
            }
        }
        // 将剩余没塞进去的数字塞进数组
        while (n >= 0) {
            nums1[end] = nums2[n];
            end = end - 1;
            n = n - 1;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 0, 0, 0};
        int[] nums2 = {2, 4, 6};
        merge2(nums1, 2, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
