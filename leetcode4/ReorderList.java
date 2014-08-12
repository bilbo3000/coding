public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode front = head;
        ListNode temp = head;
        Stack<ListNode> s = new Stack<ListNode>();
        while (temp != null) {
            s.push(temp);
            temp = temp.next;
        }

        while (s.size() != 0) {
            ListNode curr = s.pop();

            if (front == curr || front.next == curr) {
                break;
            }

            ListNode prev = s.peek();
            prev.next = null;
            curr.next = front.next;
            front.next = curr;
            front = curr.next;
        }
    }
}
