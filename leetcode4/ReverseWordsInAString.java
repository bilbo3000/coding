public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        int len = words.length;
        String result = "";

        int i = len - 1;

        while (i >= 0 && (words[i] == " " || words[i].length() == 0)) {
            i--;
        }

        if (i >= 0) {
            result = words[i];
            i--;
        }

        while (i >= 0) {
            if (words[i].length() > 0 && words[i] != " ") {
                result += " " + words[i];
            }

            i--;
        }

        return result;
    }
}
