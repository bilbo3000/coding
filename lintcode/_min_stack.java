public class Solution {
    private Stack<Integer> s1;
    private Stack<Integer> s2; 
    
    public Solution() {
        s1 = new Stack<Integer>(); 
        s2 = new Stack<Integer>(); 
    }

    // O(1)
    public void push(int number) {
        s1.push(number);
        
        if (s2.isEmpty() || s2.peek() >= number) {
            s2.push(number);
        }
    }

    // O(1)
    public int pop() {
        int result = s1.pop(); 
        
        if (result == s2.peek()) {
            s2.pop();
        }
        
        return result; 
    }

    // O(1)
    public int min() {
        return s2.peek();
    }
}

