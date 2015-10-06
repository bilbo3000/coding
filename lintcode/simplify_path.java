public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     * 
     * O(n)
     */
    public String simplifyPath(String path) {
        String[] arr = path.split("\\/");
        Stack<String> stack = new Stack<>(); 
        
        for (String item : arr) {
            if (item.equals(".")) {
                continue; 
            } else if (item.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (item.length() != 0) {
                stack.push(item);
            }
        }
        
        if (stack.size() == 0) {
            return "/"; 
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        while (stack.size() != 0) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        
        return sb.toString(); 
    }
}
