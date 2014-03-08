public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> line = new ArrayList<String>();
        int linelength = 0;

        for (int i = 0; i < words.length; i++) {
            if (linelength + words[i].length() + line.size() <= L) {  // Can fit into current line
                line.add(words[i]);
                linelength += words[i].length();
            }
            else {  // Cannot fit into current line
                int totalSpace = L - linelength;

                if (line.size() == 1) {
                    StringBuilder currline = new StringBuilder();
                    currline.append(line.get(0));

                    for (int j = 0; j < totalSpace; j++) {
                        currline.append(" ");
                    }

                    result.add(currline.toString());
                }
                else {
                    int betweenSpace = totalSpace / (line.size() - 1);
                    int remainSpace = totalSpace % (line.size() - 1);
                    StringBuilder currline = new StringBuilder();
                    currline.append(line.get(0));

                    for (int j = 1; j < line.size(); j++) {
                        // Add bewteen spaces
                        for (int k = 0; k < betweenSpace; k++) {
                            currline.append(" ");
                        }

                        // Add remain space (if any)
                        if (remainSpace > 0) {
                            currline.append(" ");
                            remainSpace--;
                        }

                        // Add word
                        currline.append(line.get(j));
                    }

                    result.add(currline.toString());
                }

                line.clear();
                line.add(words[i]);
                linelength = words[i].length();
            }
        }

        // Dealing with last line
        if (line.size() != 0) {
            int remainSpace = L - linelength - (line.size() - 1);
            StringBuilder currline = new StringBuilder();
            currline.append(line.get(0));

            for (int i = 1; i < line.size(); i++) {
                currline.append(" ");
                currline.append(line.get(i));
            }

            for (int i = 0; i < remainSpace; i++) {
                currline.append(" ");
            }

            result.add(currline.toString());
        }

        return result;
    }
}
