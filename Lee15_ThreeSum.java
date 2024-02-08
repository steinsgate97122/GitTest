import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Lee15_ThreeSum {
    // 三元组和为0，不能输出重复三元组
    // 三层循环时间复杂度n^3，无法接受

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 双层循环得到的一组元素，使用哈希表快速检查第三个元素是否存在（不好去重）
        int length = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(nums[0], 0);
        for (int i = 1; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                // 快速检索是否存在k
                int kValue = 0 - nums[i] - nums[j];
                if (!hashMap.containsKey(kValue)) {
                    continue;
                }
                List<Integer> list = new ArrayList<>();
                Collections.addAll(list, nums[i], nums[j], kValue);
                result.add(list);
            }
            hashMap.put(nums[i], i);
        }
        return result;
    }

    static class IndexedNums {
        int index;
        int value;

        public IndexedNums(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        if ((nums == null) || (nums.length < 3)) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        // 先排序（方便后面去重），确定1个元素后，剩余的数组转换为两数之和的问题
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 当nums[i]与nums[i-1]相等时，会找到重复三元组，直接跳过
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }
            // 双指针检索两数之和为-nums[i]的一组数
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] > -nums[i]) {
                    right = right - 1;
                } else if (nums[left] + nums[right] < -nums[i]) {
                    left = left + 1;
                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(list);
                    // 避免添加重复元素组
                    left = left + 1;
                    right = right - 1;
                    while ((left < right) && (nums[left] == nums[left - 1])) {
                        left = left + 1;
                    }
                    while ((left < right) && (nums[right] == nums[right + 1])) {
                        right = right - 1;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, -12, 7, -8, -2, 12, -8};
        List<List<Integer>> lists = threeSum2(nums);
        List<Integer> list = lists.stream().flatMap(a -> a.stream()).collect(Collectors.toList());
        System.out.println(list);
    }
}
