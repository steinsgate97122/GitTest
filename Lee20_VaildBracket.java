import java.util.HashMap;
import java.util.Stack;

public class Lee20_VaildBracket {

    public static boolean isValid(String s) {
        // 对于左括号，压入栈；对于右括号，弹出栈，对比弹出的括号是否匹配；遍历完成后，栈为空则合法
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('{', '}');
        hashMap.put('[', ']');
        hashMap.put('(', ')');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (!hashMap.containsKey(cur)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character left = stack.pop();
                if (hashMap.get(left) != cur) {
                    return false;
                }
            } else {
                stack.push(cur);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
        System.out.println(isValid(""));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid(")](["));
    }
}
