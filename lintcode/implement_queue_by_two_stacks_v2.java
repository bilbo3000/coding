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

    // O(n) in worse case; O(1) when stack2 contains element.
    public int pop() {
        // write your code here
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.pop();
    }

    // O(n) in worse case; O(1) when stack2 contains element. 
    public int top() {
        // write your code here
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.peek();
    }
}

