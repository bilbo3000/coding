/**
 * Implement the queue with stack. 
 * 
 * The idea was to use two stacks to simulate the behavior of a queue. 
 * The first stack is primary. It contains the elements of the queue. 
 * The second stack is secondary. It is used as a temporary place to 
 * hold elements in reverse order (poping from stack 1 and push to stack 2)
 * such that the front of the queue can be accessed. 
 */
class MyQueue {
    private Stack<Integer> s1 = new Stack<>(); 
    private Stack<Integer> s2 = new Stack<>(); 
    
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x); 
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (!s1.empty()) {
            s2.add(s1.pop()); 
        }
        
        s2.pop(); 
        
        while (!s2.empty()) {
            s1.add(s2.pop()); 
        }
    }

    // Get the front element.
    public int peek() {
        while(!s1.empty()) {
            s2.add(s1.pop());
        }
        
        int result = s2.peek(); 
        
        while (!s2.empty()) {
            s1.add(s2.pop()); 
        }
        
        return result; 
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty(); 
    }
}
