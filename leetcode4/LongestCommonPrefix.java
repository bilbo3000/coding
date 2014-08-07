public class Solution {
    class TrieNode {
        int cnt;
        public TrieNode(int x) {
            cnt = x;
        }
        TrieNode[] children = new TrieNode[26];
    }

    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        TrieNode root = new TrieNode(0);

        for (int i = 0; i < len; i++) {
            String s = strs[i];
            TrieNode curr = root;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                int digit = c - 'a';

                if (curr.children[digit] == null) {
                    TrieNode node = new TrieNode(1);
                    curr.children[digit] = node;
                } else {
                    curr.children[digit].cnt++;
                }

                curr = curr.children[digit];
            }
        }

        String result = "";
        TrieNode curr = root;

        while (curr != null) {
            TrieNode[] children = curr.children;

            int i = 0;
            while (i < 26) {
                TrieNode node = children[i];
                if (node != null && node.cnt == len) {
                    result += (char)(i + 'a');
                    curr = node;
                    break;
                }

                i++;
            }

            if (i == 26) {
                break;
            }
        }

        return result;
    }
}
