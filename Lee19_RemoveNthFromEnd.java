import java.util.Stack;

public class Lee19_RemoveNthFromEnd {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        // 暴力法，先计算链表长度L，然后删除第L-n+1个节点，找到需要删除节点的前一个即可
        ListNode currentNode = head;
        int len = 1;
        while(currentNode.next != null) {
            len = len + 1;
            currentNode = currentNode.next;
        }
        int targetIndex = len - n + 1;
        if (targetIndex == 1) {
            return head.next;
        }
        currentNode = head;
        // 删除第targetIndex个节点，需要定位到第targetIndex-1个节点，执行targetIndex-2次next即可
        for (int i = 0; i < targetIndex - 2; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        // 双指针一次遍历定位到目标节点，两个指针的初始位置距离n个节点，当rear到达链表最后一个节点时，front到达待删除节点的前一个节点
        ListNode front = head;
        ListNode rear = head;
        for (int i = 0; i < n; i++) {
            rear = rear.next;
        }
        // n如果等于链表长度时，rear此时为空，删除第一个节点即可，直接返回head.next
        if (rear == null) {
            return head.next;
        }
        while(rear.next != null) {
            front = front.next;
            rear = rear.next;
        }
        front.next = front.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        // 把每个链表元素压入栈，弹出n个，下一个就是待删除节点的前一个节点
        Stack<ListNode> stack = new Stack<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.next;
        }
        for (int i = 0; i < n; i++) {
            ListNode node = stack.pop();
        }
        // stack内的下一个节点就是待删除节点的前一个节点，如果待删除的就是head节点，stack为空
        if (stack.isEmpty()) {
            return head.next;
        }
        ListNode node = stack.pop();
        node.next = node.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode currentNode = removeNthFromEnd3(listNode1, 2);
        while(currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }
}
