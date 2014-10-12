public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<List<Integer>> temp = new HashSet<List<Integer>>();
        int len = num.length;

        for (int i = 0; i < len - 2; i++) {
            int l = i + 1;
            int r = len - 1;

            while (l < r) {
                int sum = num[i] + num[l] + num[r];

                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(num[i]);
                    triplet.add(num[l]);
                    triplet.add(num[r]);
                    if (!temp.contains(triplet)) {
                        temp.add(triplet);
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        result.addAll(temp);

        return result;
    }
}
