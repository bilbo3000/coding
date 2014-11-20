import java.util.Arrays;

public class FoxAndWord {
    public int howManyPairs(String[] words) {
        int result = 0;
        int len = words.length;
        Arrays.sort(words);

        for (int i = 0; i < len - 1; i++) {
            while (i > 0 && i < len - 1 && words[i].equals(words[i - 1])) {
                i++;
            }

            if (i == len - 1) {
                break;
            }

            for (int j = i + 1; j < len; j++) {
                while (j > i + 1 && j < len && words[j].equals(words[j - 1])) {
                    j++;
                }

                if (j == len) {
                    break;
                }

                if (words[i].length() != words[j].length()) {
                    break;
                }

                for (int k = 0; k < words[i].length() - 1; k++) {
                    String left = words[i].substring(0, k + 1);
                    String right = words[i].substring(k + 1, words[i].length());

                    if ((right + left).equals(words[j])) {
                        result++;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
