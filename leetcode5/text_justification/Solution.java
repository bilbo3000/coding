import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<List<String>> lines = new ArrayList<List<String>>();
        int row = 0;
        lines.add(new ArrayList<String>());
        int currLen = 0;

        for (String word : words) {
            int len = word.length();
            List<String> curr = lines.get(row);

            if (currLen == 0) {
                curr.add(word);
                currLen += len;
            } else if (currLen + 1 + len <= L) {
                curr.add(word);
                currLen += len + 1;
            } else if (currLen + 1 + len > L) {
                lines.add(new ArrayList<String>());
                row++;
                lines.get(row).add(word);
                currLen = len;
            }
        }

        List<String> result = new ArrayList<String>();

        // First n - 1 lines
        for (int i = 0; i < lines.size() - 1; i++) {
            List<String> currLine = lines.get(i);
            int minLen = currLine.get(0).length();

            for (int j = 1; j < currLine.size(); j++) {
                minLen += 1 + currLine.get(j).length();
            }

            int remainLen = L - minLen;

            if (currLine.size() == 1) {
                String temp = currLine.get(0);

                for (int j = 0; j < remainLen; j++) {
                    temp += " ";
                }

                result.add(temp);
            } else {
                int spaceInBetween = remainLen / (currLine.size() - 1);
                int remainSpace = remainLen % (currLine.size() - 1);
                String temp = currLine.get(0);

                for (int j = 1; j < currLine.size(); j++) {
                    if (remainSpace > 0) {
                        remainSpace--;
                        temp += " ";
                    }

                    for (int k = 0; k < spaceInBetween; k++) {
                        temp += " ";
                    }

                    temp += " " + currLine.get(j);
                }

                result.add(temp);
            }
        }

        // Last line
        if (lines.size() > 0) {
            List<String> lastLine = lines.get(lines.size() - 1);
            String temp = lastLine.get(0);
            int tempLen = temp.length();

            for (int i = 1; i < lastLine.size(); i++) {
                temp += " " + lastLine.get(i);
                tempLen += 1 + lastLine.get(i).length();
            }

            int remainLen = L - tempLen;

            for (int i = 0; i < remainLen; i++) {
                temp += " ";
            }

            result.add(temp);
        }

        return result;
    }
}
