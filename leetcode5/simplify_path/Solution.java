public class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String> stack = new Stack<String>(); 
        
        for (String s : str) {
            if (s.equals(".") || s.length() == 0) {
                continue; 
            } else if (s.equals("..")) {
                if (stack.size() != 0) {
                    stack.pop(); 
                }
            } else {
                stack.push(s); 
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
