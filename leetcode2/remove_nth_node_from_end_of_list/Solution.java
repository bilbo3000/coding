public class Solution {
    int cnt = 0;
    int n = 0;
    ListNode newhead = null;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.newhead = head;
        this.n = n;
        helper(null, head);

        return newhead;
    }

    public void helper(ListNode prev, ListNode curr) {
        if (curr == null) return;

        helper(curr, curr.next);

        cnt++;

        if (cnt == n) {
            if (prev == null) {
                newhead = curr.next;
            }
            else {
                prev.next = curr.next;
            }
        }
    }
}
