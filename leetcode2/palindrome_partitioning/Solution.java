public class Solution {
    private ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<Integer>> T = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<String>> partition(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            T.add(new ArrayList<Integer>());

            for (int j = i; j >= 0; j--) {
                if (isPalin(s.substring(j, i + 1))) {
                    T.get(i).add(j);
                }
            }
        }

        // Reconstruct 
        reconstruct(s, n - 1, new ArrayList<String>());

        return result;
    }

    public void reconstruct(String s, int currIndex, ArrayList<String> currResult) {
        ArrayList<Integer> temp = T.get(currIndex);

        for (int i = 0; i < temp.size(); i++) {
            ArrayList<String> tempResult = new ArrayList<String>(currResult);

            if (temp.get(i) == 0) {
                tempResult.add(0, s.substring(0, currIndex + 1));
                result.add(tempResult);
            }
            else {
                tempResult.add(0, s.substring(temp.get(i), currIndex + 1));
                reconstruct(s, temp.get(i) - 1, tempResult);
            }
        }
    }

    public boolean isPalin(String s) {
        int n = s.length();
        if (n == 0) return false;

        int i = 0;
        int j = n - 1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;

            i++;
            j--;
        }

        return true;
    }
}
