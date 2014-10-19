public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.addAll(helper(num, 0));

        return result; 
    }

    private Set<List<Integer>> helper(int[] num, int index) {
        int len = num.length;
        Set<List<Integer>> result = new HashSet<List<Integer>>();

        if (index == len) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        Set<List<Integer>> temp = helper(num, index + 1);

        for (List<Integer> item : temp) {
            for (int i = 0; i < item.size(); i++) {
                if (item.get(i) != num[index]) {
                    List<Integer> p = new ArrayList<Integer>(item);
                    p.add(i, num[index]);

                    if (!result.contains(p)) {
                        result.add(p);
                    }
                }
            }

            item.add(num[index]);

            if (!result.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }
}
