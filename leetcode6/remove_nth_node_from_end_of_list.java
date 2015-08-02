/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Remove nth node from the end of list. 
 * The idea was to traverse through the list and put all nodes in a list. Then 
 * retrieve the nth node from the end list and the one before that, then remove 
 * that node by updating the reference. Remember to discuss edge cases such as 
 * removing head, etc. 
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null; 
        }
        
        List<ListNode> list = new ArrayList<>(); 
        ListNode curr = head; 
        
        while (curr != null) {
            list.add(curr);
            curr = curr.next; 
        }
        
        int len = list.size();
        
        if (n > len) {
            return head; 
        }
        
        if (n == len) {
            return head.next; 
        }
        
        ListNode prev = list.get(len - n - 1); 
        ListNode node = list.get(len - n);
        
        prev.next = node.next; 
        
        return head; 
    }
}
