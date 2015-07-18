/**
 * Implement stack using queues. 
 * The idea was to two queues. One primary queue and one secondary 
 * queue. Use primary queue as the container and use secondary queue 
 * as a temporary place to store items. For empty operation, just 
 * simply check whether the primary queue is empty. For top and pop 
 * operation, we need to move elements to secondary queue in order 
 * to access and top element, then move elements back from secondary 
 * to primary queue. 
 */ 
class MyStack {
    private Queue<Integer> q1 = new LinkedList<>(); 
    private Queue<Integer> q2 = new LinkedList<>(); 
    
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x); 
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (q1.size() != 0) {
            if (q1.size() == 1) {
                q1.remove(); 
            } else {
                q2.add(q1.remove()); 
            }
        }
        
        while (q2.size() != 0) {
            q1.add(q2.remove()); 
        }
    }

    // Get the top element.
    public int top() {
        int result = q1.remove(); 
        q2.add(result); 
        
        while (q1.size() != 0) {
            result = q1.remove(); 
            q2.add(result); 
        }
        
        while (q2.size() != 0) {
            q1.add(q2.remove()); 
        }
        
        return result; 
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty(); 
    }
}
