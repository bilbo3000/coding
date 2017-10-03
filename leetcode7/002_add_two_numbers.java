/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
 Add two numbers represented as reversed linked list. 
 
 Going through two lists simultaneously as long as any list is not null. 
 Add values (if any) together with previous carry to get sum. Then 
 the digit and next carry can be calculated. 
 
 Cool trick is to use a dummy node to start with. It avoids null checkings. 
 
 Time: O(max(n, m)), time complexity is dominated by the longer list; 
 Space: O(max(n, m)), the result length is at most max(n, m);  
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy; 
        int carry = 0; 
        
        while (l1 != null || l2 != null) {
            int sum = carry; 
            
            if (l1 != null) {
                sum += l1.val; 
                l1 = l1.next; 
            } 
            
            if (l2 != null) {
                sum += l2.val; 
                l2 = l2.next; 
            }
            
            int digit = sum % 10; 
            carry = sum / 10; 
            tail.next = new ListNode(digit);
            tail = tail.next; 
        }
        
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        
        return dummy.next; 
    }
}
