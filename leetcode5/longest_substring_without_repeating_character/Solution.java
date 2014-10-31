public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hasFound = new HashMap<Character, Integer>();
        int result = 0;

        int l = 0;
        int r = 0;
        int len = s.length();

        while (r < len && l <= r) {

            while (r < len && (!hasFound.containsKey(s.charAt(r)) || hasFound.get(s.charAt(r)) == 0)) {
                hasFound.put(s.charAt(r), 1);

                result = Math.max(r - l + 1, result);
                r++;
            }

            hasFound.put(s.charAt(l), hasFound.get(s.charAt(l)) - 1);

            l++;
        }

        return result;
    }
}
