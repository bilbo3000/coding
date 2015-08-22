/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Reorder the list such that l1 -> ln -> l2 -> ln-1 -> ...
 * The idea was to go through the list and store each node to a list. Then move the
 * last node after the first node each time and then pop the nodes at two ends each time.
 */
public class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> l = new ArrayList<>(); 
        ListNode curr = head; 
        
        while (curr != null) {
            l.add(curr);
            curr = curr.next; 
        }
        
        while (l.size() > 2) {
            ListNode first = l.get(0); 
            ListNode last = l.get(l.size() - 1);
            ListNode lastPrev = l.get(l.size() - 2);
            
            lastPrev.next = null; 
            last.next = first.next; 
            first.next= last; 
            
            l.remove(l.size() - 1);
            l.remove(0);
        }
    }
}
