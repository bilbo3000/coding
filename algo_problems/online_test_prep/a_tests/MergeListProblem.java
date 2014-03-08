/*
 Document your assumptions
 -- The assumption here is that client would invoke the mergeLists method such as
    Node result = MergeListProblem.mergeLists(head1, head2);

Explain your approach and how you intend to solve the problem
-- The idea here is to have two pointers walk through each list until either one
    reaches null. 
-- At each step, compare the values of nodes pointed by two pointers. Add the node with
    smaller value to the result list.
-- A helper method is provided to add a given node to the result list.
-- A tricky part is that when either pointer reaches end of list, we need to append 
    the other list (if not null) to the end of the result list.

Provide code comments where applicable
Explain the big-O run time complexity of your solution. Justify your answer.
-- Traverse two lists requires O(m + n) where m, n are the length of two lists
-- No additional space is required
-- Thus, this is an linear algorithm. 

Identify any additional data structures you used and justify why you used them.
-- A helper function is provided to reuse the "add node" functionality.
-- No additional data structures are used.

Only provide your best answer to each part of the question.
 */


public class Node {
	public int value;
	public Node next;
	public Node() {
		value = 0;
		next = null;
	}
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
}
 
public class MergeListProblem {
    private static Node head = null;  // Head of result list
    private static Node tail = null;  // Tail of result list

    public static Node mergeLists(Node head1, Node head2) {
        // Traverse through the list
        while (head1 != null && head2 != null) {
            // Add smaller node to the result list
            if (head1.value < head2.value) {
                addNode(head1);
                head1 = head1.next;
            }
            else {
                addNode(head2);
                head2 = head2.next;
            }
        }

        // Check if any left over nodes
        if (head1 != null) {
            addNode(head1);
        }

        if (head2 != null) {
            addNode(head2);
        }

        return head;
    }

    /*
     * Helper function that merges two lists 
     */
    private static void addNode(Node node) {
        if (tail == null) {  // Adding the first node
            head = node;
            tail = node;
        }
        else {  // Append to the end
            tail.next = node;
            tail = tail.next;
        }
    }
}
