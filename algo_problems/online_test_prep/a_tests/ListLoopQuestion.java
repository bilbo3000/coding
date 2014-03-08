/*
Document your assumptions
-- The assumption made here is that the client invokes the method as
    Boolean result = ListLoopQuestion.hasLoops(myList);

Explain your approach and how you intend to solve the problem
-- The idea here is that we can use two pointers to traverse the given list simultaneously.
    The trick here is to allow one pointer (fast) move twice as fast as the other
    pointer (slow).
-- If the linked list does not have a cycle, the fast pointer would eventually reaches
    the end of list (null). The method would return false.
-- If the linked list has a cycle, both pointers would be trapped in the cycle. However,
    the fast pointer moves twice as fast as slow. The fast pointer would eventually
    meet the slow pointer. Then, the method would return true.

Provide code comments where applicable
Explain the big-O run time complexity of your solution. Justify your answer.
-- The method has two pointers traverse the list simultaneously. Thus, the run
    time complexity would be O(n). This is a linear algorithm. 

Identify any additional data structures you used and justify why you used them.
-- No additional data structures is used.

Only provide your best answer to each part of the question.
 */

public class ListLoopQuestion {
    public static class ListNode {
        public int value;
        public ListNode next;
    }

    public static boolean hasLoops( ListNode myList ) {
        if (myList == null) {  // Empty list does not have cycle
            return false;
        }

        // Use two pointers to traverse the list
        // fast moves twice as fast as slow, if they meet eventually, there must be
        // a cycle, otherwise, there is no cycle.
        ListNode slow = myList;
        ListNode fast = myList.next;

        while (fast != null) {
            fast = fast.next;

            if (fast != null) {  // Move slow only if fast is not null
                slow = slow.next;
                fast = fast.next;
            }

            if (fast == slow) {  // If two pointers meet, there is a cycle
                return true;
            }
        }

        // fast pointer reaches the end, there is no cycle
        return false;
    }
}
