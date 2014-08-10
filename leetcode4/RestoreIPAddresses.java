public class Solution {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length(); 
        List<String> result = new ArrayList<String>();
        
        if (len > 12) {
            return result; 
        }
        
        helper(s, 0, new ArrayList<String>(), result);

        return result;
    }

    private void helper(String s, int index, List<String> path, List<String> result) {
        int len = s.length();

        if (index == len) {
            if (path.size() == 4) {
                String temp = path.get(0);

                for (int i = 1; i < 4; i++) {
                    temp += "." + path.get(i);
                }

                result.add(temp);
            }
            return;
        }
        
        if (path.size() > 4) {
            return; 
        }

        for (int offset = 1; offset <= 3; offset++) {
            if (index + offset <= len) {
                String num = s.substring(index, index + offset);
                int numVal = Integer.parseInt(num);

                if (num.charAt(0) == '0' && num.length() != 1) {
                    continue;
                }

                if (numVal > 255) {
                    continue;
                }

                path.add(num);
                helper(s, index + offset, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}
