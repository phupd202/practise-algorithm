package week_2;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> residualStack = new Stack<Integer>();
        residualStack.push(0);

        // iterate over items of the two linked lists
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode fakeHead = new ListNode();
        ListNode current = fakeHead;

        int sum;
        while (p1 != null || p2 != null) {
            //lấy phần dư của phần tử trước
            int residual = residualStack.pop();

            // tổng 2 số
            sum = (p1 != null ? p1.val : 0) + (p2 != null ? p2.val : 0) + residual;

            // cập nhật node
            current.next  = new ListNode(sum % 10);
            current = current.next;

            // push phần dư vào stack
            residualStack.push(sum / 10);

            // dịch chuyển tới vị trí tiếp theo để tính tổng
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        // node cuối cùng
        if (residualStack.peek() > 0) {
            current.next = new ListNode(residualStack.pop());
        }

        return fakeHead.next;
    }
}
