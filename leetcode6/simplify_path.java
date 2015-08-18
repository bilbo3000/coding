/**
 * Simplify the given Unix like path. 
 * The idea was to use a stack. First split the string at "\\/+". Then go 
 * through the results, if find ".", continue; if find ".." and stack is not 
 * empty, pop from the stack; otherwise, push the item to the stack. In the 
 * end, concatenate all items left in the stack to form the resulting path. 
 */ 
public class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("\\/+");
        Stack<String> stack = new Stack<>(); 
        
        for (String item : arr) {
            if (item.length() > 0) {
                if (item.equals(".")) {
                    continue; 
                } else if (item.equals("..")) {
                    if (stack.size() != 0) {
                        stack.pop(); 
                        continue; 
                    }
                } else {
                    stack.push(item); 
                }
            }
        }
        
        if (stack.size() == 0) {
            return "/"; 
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        while (stack.size() > 0) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        
        return sb.toString(); 
    }
}
