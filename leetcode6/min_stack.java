/**
 * Implement a min stack which supports push, pop, top and getMin operation. 
 * The difficult part is to implement getMin operation in constant time. The idea was to maintain 
 * a min stack such that only push value of min stack if incoming element is smaller than the top 
 * of min stack, and pop from min stack if its top is the same as the value to be poped. The element 
 * with larger values will be poped first while smallest will still be top of the minStack. After 
 * minStack is poped. The next one would automatically become the min for the rest of elements in 
 * the stack. 
 */ 
class MinStack {
    private Stack<Integer> stack = new Stack<>(); 
    private Stack<Integer> minStack = new Stack<>(); 
    
    public void push(int x) {
        stack.push(x);
        
        if (minStack.size() == 0 || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.size() == 0) {
            return; 
        }
        
        int x = stack.pop(); 
        
        if (minStack.size() != 0 && minStack.peek() == x) {
            minStack.pop(); 
        }
    }

    public int top() {
        return stack.peek(); 
    }

    public int getMin() {
        return minStack.peek(); 
    }
}
