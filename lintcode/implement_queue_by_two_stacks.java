public class Solution {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution() {
       // do initialization if necessary
       stack1 = new Stack<>(); 
       stack2 = new Stack<>();
    }
    
    // O(1)
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    // O(n)
    public int pop() {
        // write your code here
        while (stack1.size() != 0) {
            stack2.push(stack1.pop());
        }
        
        int result = stack2.pop();
        
        while (stack2.size() != 0) {
            stack1.push(stack2.pop());
        }
        
        return result; 
    }

    // O(n)
    public int top() {
        // write your code here
        while (stack1.size() != 0) {
            stack2.push(stack1.pop());
        }
        
        int result = stack2.peek();
        
        while (stack2.size() != 0) {
            stack1.push(stack2.pop());
        }
        
        return result;
    }
}

