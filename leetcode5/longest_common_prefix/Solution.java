public class Solution {
    class TrieNode {
        int val;
        TrieNode[] children = new TrieNode[26];

        TrieNode(int val) {
            this.val = val;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode(0);
        int cnt = strs.length;
        String result = "";

        for (String s : strs) {
            TrieNode curr = root;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = (int) (c - 'a');
                TrieNode[] temp = curr.children;

                if (temp[index] == null) {
                    temp[index] = new TrieNode(0);
                }

                temp[index].val++;
                curr = temp[index];
            }
        }

        TrieNode curr = root;

        while (true) {
            TrieNode[] temp = curr.children;
            int i = 0;
            int len = temp.length;

            while (i < len) {
                if (temp[i] != null && temp[i].val == cnt) {
                    result += (char) (i + 'a');
                    curr = temp[i];
                    break;
                }

                i++;
            }

            if (i == len) {
                break;
            }
        }

        return result;
    }
}
