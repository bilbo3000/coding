public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return helper(lists, 0, lists.size() - 1); 
    }
    
    private ListNode helper(ArrayList<ListNode> lists, int l, int r) {
        if (l > r) {
            return null; 
        }
        
        if (l == r) {
        	return lists.get(l); 
        } 
        
        int mid = (l + r) / 2; 
        ListNode temp1 = helper(lists, l, mid); 
        ListNode temp2 = helper(lists, mid + 1, r); 
        ListNode head = null; 
        ListNode tail = null; 
        
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                if (tail == null) {
                    head = temp1; 
                    tail = temp1; 
                }
                else {
                    tail.next = temp1; 
                    tail = tail.next; 
                } 
                
                temp1 = temp1.next; 
            }
            else {
                if (tail == null) {
                    head = temp2; 
                    tail = temp2; 
                }
                else {
                    tail.next = temp2; 
                    tail = tail.next; 
                }
                temp2 = temp2.next; 
            }
        }
        
        if (temp1 != null) {
            if (tail == null) {
                head = temp1; 
                tail = temp1; 
            }
            else {
                tail.next = temp1; 
                tail = tail.next; 
            } 
        }
        
        if (temp2 != null) {
            if (tail == null) {
                head = temp2; 
                tail = temp2; 
            }
            else {
                tail.next = temp2; 
                tail = tail.next; 
            } 
        }
    
        return head; 
    }
}
