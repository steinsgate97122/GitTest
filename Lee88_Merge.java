import java.util.Arrays;

public class Lee88_Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
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

    /**
     * 2. 双指针法
     * 双指针法是一种更有效的方法。它使用两个指针，分别指向两个数组的当前元素。从两个数组的开头开始，比较两个指针指向的元素，并将较小的元素插入到合并后的数组中。当其中一个指针到达数组末尾时，另一个指针指向的剩余元素可以直接添加到合并后的数组中。这种方法的时间复杂度为 O(m + n)。
     * 3. 递归法
     * 递归法是一种比较优雅的解法。它将合并两个数组的问题分解为两个子问题：合并两个数组的左半部分和合并两个数组的右半部分。然后，将合并后的左半部分和右半部分连接起来即可得到最终结果。这种方法的时间复杂度为 O(m + n)。
     * 4. 归并排序
     * 归并排序是一种经典的排序算法，它也可以用来合并两个有序数组。归并排序的基本思想是将数组不断分割成子数组，然后递归地对子数组进行排序，最后将排序好的子数组合并起来。这种方法的时间复杂度为 O(m + n log(m + n))。
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 0, 0, 0};
        int[] nums2 = {2, 4, 6};
        merge(nums1, 2, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
