public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<List<String>> temp = new ArrayList<List<String>>();
        helper(s, 0, new ArrayList<String>(), temp);
        List<String> result = new ArrayList<String>();

        for (List<String> item : temp) {
            String str = item.get(0);

            for (int i = 1; i < item.size(); i++) {
                str += '.' + item.get(i);
            }

            result.add(str);
        }

        return result;
    }

    private void helper(String s, int index, List<String> curr, List<List<String>> result) {
        int len = s.length();
        int size = curr.size();

        if (index == len && size == 4) {
            result.add(new ArrayList<String>(curr));

            return;
        }

        if (index >= len) {
            return;
        }

        if (size > 4) {
            return;
        }

        char c = s.charAt(index);

        if (c < '0' || c > '9') return;

        // Start a new segment
        curr.add(c + "");
        helper(s, index + 1, curr, result);
        curr.remove(curr.size() - 1);

        // Try to merge with previous segment
        if (curr.size() != 0) {
            String prev = curr.get(curr.size() - 1);

            if (prev.charAt(0) == '0') return;
            if (prev.length() == 3) return;
            String save = prev;
            prev = prev + c;

            if (Integer.parseInt(prev) > 255) return;

            curr.set(curr.size() - 1, prev);
            helper(s, index + 1, curr, result);
            curr.set(curr.size() - 1, save);
        }
    }
}
