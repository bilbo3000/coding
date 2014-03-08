public class Solution {
    ListNode head = null;

    public ListNode deleteDuplicates(ListNode h) {
        this.head = h;
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            boolean dup = false;

            while (curr.next != null && curr.val == curr.next.val) {
                dup = true;
                delete(curr, curr.next);
            }

            if (dup) {
                delete(prev, curr);

                if (prev != null) {
                    curr = prev.next;
                }
                else {
                    curr = head;
                }
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }

    public void delete(ListNode prev, ListNode curr) {
        if (curr == null) return;

        if (prev == null) {
            head = curr.next;
        }
        else {
            prev.next = curr.next;
        }
    }
}
