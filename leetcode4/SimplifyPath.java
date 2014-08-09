public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/"); 
        Stack<String> stack = new Stack<String>(); 
        
        for (String item : paths) {
            if (!item.equals(".")) {
                if (item.equals("..")) {
                    if (stack.size() != 0) {
                        stack.pop(); 
                    }
                } else if (item.length() != 0) {
                    stack.push(item); 
                }
            }
        }
        
        if (stack.size() == 0) {
            return "/"; 
        }
        
        String result = ""; 
        
        while (stack.size() != 0) {
            result = "/" + stack.pop() + result; 
        }
        
        return result; 
    }
}
