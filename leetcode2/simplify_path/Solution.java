public class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/"); 
        Stack<String> s = new Stack<String>(); 
        
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i].equals("") || dirs[i].equals(".")) continue; 
            if (dirs[i].equals("..")) {
                if (s.size() != 0) {
                    s.pop(); 
                }
            }
            else {
                s.push(dirs[i]); 
            }
        }
        
        if (s.size() == 0) return "/"; 
        
        String result = ""; 
        
        while (s.size() != 0) {
            result = "/" + s.pop() + result; 
        }
        
        return result;
    }
}
