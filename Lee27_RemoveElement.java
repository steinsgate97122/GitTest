import java.util.Arrays;

public class Lee27_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        // 准备forward和backward两个指针，当forward命中val时，与backward当前元素交换
        int forward = 0;
        int backward = nums.length - 1;
        int result = 0;
        while (forward <= backward) {
            if (nums[forward] == val) {
                nums[forward] = nums[backward];
                backward--;
            } else {
                forward++;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = removeElement(nums, 2);
        System.out.println(Arrays.toString(nums));
        System.out.println("length is " + i);
    }
}
