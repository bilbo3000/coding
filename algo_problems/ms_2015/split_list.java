
node * splitlinkedlist (node* head, int n)

Write code in any language to split a linkedlist into two parts. Let me explain what this method does with an example:

Consider an 8 node linked list:

1-> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null

when n = 2, this method takes the above linked list and splits it into two parts:

1-> 2 -> 3 -> 4 -> null
5 -> 6 -> 7 -> 8 -> null

the method returns a pointer to node 5

when n = 4, this method takes the above linked list and splits it into two parts:

1-> 2 -> null
3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null

the method returns a pointer to node 3

Write code in any language (pseudo code is fine) for this method that can take any linked list and any value of n, and split it into two parts

// Define a node class 
class Node {
    int val; 
    Node next; 
    
    Node(int x) {
        this.val = x; 
    }
}

Node splitlinkedlist(Node head, int n) {
    // Step 0: checking some corner cases 
    if (n < 0) {
        return null; 
    }
    
    // Step 1: get the length of the list
    Node temp = null; 
    Node curr = head; 
    int len = 0;
    
    Set<Node> history = new HashSet<>(); 
    
    while (curr != null) {
        if (history.contains(curr)) {
            // Found a circle here, curr is the node where circle starts 
            temp.next = null; // Detach the circle from the joint node
            break; // No need to continue, because we have the len
        } else {
            history.add(curr); // Keep track of the nodes we have visited
            len++; 
            temp = curr; 
            curr = curr.next; 
        }
    }
    
    // Step 2: calculate the number of nodes going to be in the first list
    if (n == 0) {
        // Divisor is 0, all nodes going to be in the first list
        // Second list would be empty, just return null
        return null; 
    }
    
    if (len == 0) {
        // Input list is empty, return null
        return null; 
    }
    
    int cnt = len / n; 
    
    if (cnt == 0) {
        // n is greater than the length of the list, thus 
        // no elements would be in the first list
        
        return head; 
    } else {
        // There will be some nodes in the first list 
        // We need to split the list
        ListNode prev = null; 
        ListNode res = head; 
        
        while (cnt > 0 && res != null) {
            prev = res;  // Maintain previous pointer so we can split the list
            res = res.next; 
            cnt--; 
        }
        
        // Actually split the list here
        if (prev != null) {
            prev.next = null; 
        }
        
        return res; 
    }
}

Test cases: 
- input: null, n = 2; output: null, because the list is empty; 
- input: 1->2, n = -1; output: null, because n is negative; 
- input: 1-> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null, n = 2; output: points to 5, because length is 8, n = 2,
thus cnt is cnt = 8 / 2 = 4. It will start executing the else statement t line 71. Each iteration cnt will 
decrease by 1, res starts with head, after move cnt(4) times, it will point to node 5, and it jumps out of loop
and returns node 5. 
- input: 1->2, n = 3; output: pointer to node 1; Because len is 2, n is 3; thus cnt = 2 / 3 = 0. It will start
execute the if statement in line 65, meaning there is no nodes in first list, all elements would be in the second list, thus return head. 
- input: 1->2, n = 0; output: null; Because len is 2, n is 0, cnt would be infinity, meaning all nodes are in 
the first list, the second list would be empty and thus return null; This is handled at line 52. 
- input: 1->2, n = 2; output: pointer to node 2; Because the length of the list is the same as n, thus cnt = len / n = 1, meaning there will be 1 node in first list and the remaining in the second list. Thus return pointer to node 2 as the result. 
