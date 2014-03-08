public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return helper(lists, 0, lists.size() - 1); 
    }
    
    private ListNode helper(ArrayList<ListNode> lists, int l, int r) {
        if (l == r) {
            return lists.get(l); 
        }
        
        if (l < r) {
            int mid = (l + r) / 2; 
            ListNode left = helper(lists, l, mid); 
            ListNode right = helper(lists, mid + 1, r); 
            
            ListNode head = null; 
            ListNode tail = null; 
            
            while (left != null && right != null) {
                if (left.val < right.val) {
                    if (tail == null) {
                        head = left; 
                        tail = left; 
                        left = left.next; 
                    }
                    else {
                        tail.next = left; 
                        tail = tail.next; 
                        left = left.next; 
                    }
                }
                else {
                    if (tail == null) {
                        head = right; 
                        tail = right; 
                        right = right.next; 
                    }
                    else {
                        tail.next = right; 
                        tail = tail.next; 
                        right = right.next; 
                    }
                }
            }
            
            if (left != null) {
                if (tail == null) {
                    head = left; 
                    tail = left;  
                }
                else {
                    tail.next = left; 
                }
            }
            
            if (right != null) {
                if (tail == null) {
                    head = right; 
                    tail = right; 
                }
                else {
                    tail.next = right; 
                }                
            }
            
            return head; 
        }
        
        return null; 
    }
}
