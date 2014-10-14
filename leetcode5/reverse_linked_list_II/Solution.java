/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode prev1 = null;
        ListNode curr1 = null;

        int cnt = 0;

        while (curr != null) {
            cnt++;

            if (cnt == m) {
                prev1 = prev;
                curr1 = curr;
                ListNode next = curr.next;
                curr.next = null;
                prev = curr;
                curr = next;
                break;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        while (curr != null) {
            cnt++; 
            
            if (cnt == n) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                break;
            } else {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
        }

        if (prev1 != null) {
            prev1.next = prev;
            curr1.next = curr;
        } else {
            head = prev;
            curr1.next = curr;
        }

        return head;
    }
}
