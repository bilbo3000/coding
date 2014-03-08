public class Solution {
    public String simplifyPath(String path) {
        String[] temp = path.split("/");
        Stack<String> s = new Stack<String>();

        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals("..")) {
                if (s.size() != 0) {
                    s.pop();
                }
            }
            else if (!temp[i].equals(".") && temp[i].length() != 0) {
                s.push(temp[i]);
            }
        }

        if (s.size() == 0) {
            return "/";
        }

        String result = "";

        while (s.size() != 0) {
            result = "/" + s.pop() + result;
        }

        return result;
    }
}
