/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
 Merge k sorted lists. 
 
 The idea is to use a min heap (priority queue). 
 
 Initialize the min heap with the first node of each list (if not null). 
 Then each iteration poll the smallest from the min heap (min heap propertiey)
 and append to the resulting list. If the next of this node is not null, 
 add it to the list. Repeat the process until the queue become empty. 
 
 Time: O(nlogn), for each node, need to insert into the priority queue. Each insert takes O(logn), 
 there are n nodes --> O(nlogn); 
 Space: O(k), min heap to store k at most k nodes; 
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null; 
        }
        
        int len = lists.length; 
        
        if (len == 0) {
            return null; 
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy; 
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(len, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val; 
            }
        }); 
        
        // Add the head of the each list to priority queue 
        for (ListNode node : lists) {
            if (node != null) {
                // Add to min heap iff not null
                minHeap.add(node);
            }
        }
        
        while (minHeap.size() != 0) {
            ListNode node = minHeap.remove(); 
            tail.next = node; 
            tail = tail.next; 
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        
        return dummy.next; 
    }
}
