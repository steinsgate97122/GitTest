import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Lee01_TwoSum {
    public static int[] twoSum1(int[] nums, int target) {
        // 暴力法，时间复杂度n^2
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        // 排序后使用双指针，排序的时间复杂度nlogn
        IndexedNums[] indexedArr = new IndexedNums[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexedArr[i] = new IndexedNums(i, nums[i]);
        }
        Arrays.sort(indexedArr, Comparator.comparingInt(o -> o.value));
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            if (indexedArr[start].value + indexedArr[end].value == target) {
                return new int[]{indexedArr[start].index, indexedArr[end].index};
            } else if (indexedArr[start].value + indexedArr[end].value > target) {
                end = end - 1;
            } else {
                start = start + 1;
            }
        }
        return null;
    }

    public static int[] twoSum3(int[] nums, int target) {
        // 建立{索引-值}哈希表，建立后借助哈希表判断期望值是否存在
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(i, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsValue(target - nums[i])) {
                int num2 = target - nums[i];
                Integer j = hashMap.entrySet().stream()
                        .filter(entry -> entry.getValue() == num2)
                        .map(entry -> entry.getKey())
                        .findFirst()
                        .orElse(null);
                if ((j != null) && (j != i)) {
                    return new int[]{j, i};
                }
            }
        }
        return null;
    }

    public static int[] twoSum4(int[] nums, int target) {
        // 建立{索引-值}哈希表，建立时即可判断期望值是否已经在哈希表维护
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.isEmpty()) {
                int addend = target - nums[i];
                if (hashMap.containsValue(addend)) {
                    Integer j = hashMap.entrySet().stream()
                            .filter(entry -> entry.getValue() == addend)
                            .map(entry -> entry.getKey())
                            .findFirst()
                            .orElse(null);
                    return new int[]{j, i};
                }
            }
            hashMap.put(i, nums[i]);
        }
        return null;
    }

    public static int[] twoSum5(int[] nums, int target) {
        // 建立{索引-值}哈希表，哈希表检索key的效率比检索value更高
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.isEmpty()) {
                int addend = target - nums[i];
                if (hashMap.containsKey(addend)) {
                    Integer j = hashMap.get(addend);
                    return new int[]{j, i};
                }
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    static class IndexedNums {
        int index;
        int value;

        public IndexedNums(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum4(nums, target)));
    }
}
