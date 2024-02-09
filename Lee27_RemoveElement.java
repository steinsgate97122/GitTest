import java.util.Arrays;

public class Lee27_RemoveElement {
    public static int removeElement1(int[] nums, int val) {
        // 准备forward和backward两个指针，当forward命中val时，与backward当前元素交换
        int forward = 0;
        int backward = nums.length - 1;
        while (forward <= backward) {
            if (nums[forward] == val) {
                nums[forward] = nums[backward];
                backward--;
            } else {
                forward++;
            }
        }
        return forward;
    }

    public static int removeElement2(int[] nums, int val) {
        // 也可以准备fast和slow指针，当fast未命中val时，赋值给slow（本质上和上面是一回事）
        int fast = 0, slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = removeElement2(nums, 2);
        System.out.println(Arrays.toString(nums));
        System.out.println("length is " + i);
    }
}
