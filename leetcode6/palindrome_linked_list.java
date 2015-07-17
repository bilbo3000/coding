/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Check whether a given linked list is a palindrome. 
 * The idea was to use recursion. Having one pointer keep going 
 * down the recursion calls until it reaches the end of list, then 
 * let it back track while moving another pointer forward. Meanwhile
 * compare values. We need to maintain two flags. One says whether 
 * we need to stop the comparision. This happens once two pointers 
 * cross. The other says whether the list is palindrome. This flag 
 * is set only when two pointers cross each other and they have 
 * been satisfying palindrome properties previously. 
 */
public class Solution {
    private boolean isPalin = false; 
    private boolean isDone = false; 
    private ListNode prev; 
    
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true; 
        }
        
        prev = head; 
        helper(head);
        
        return isPalin; 
    }
    
    private void helper(ListNode curr) {
        if (curr == null) {
            return; 
        }
        
        helper(curr.next); 
        
        if (isDone) {
            return; 
        }
        
        if (prev.val != curr.val) {
            isDone = true; 
            return; 
        }
        
        if (prev == curr || prev.next == curr) {
            isPalin = true; 
            isDone = true; 
        }
        
        prev = prev.next; 
    }
}
