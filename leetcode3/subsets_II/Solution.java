public class Solution {
    private int prevCount = 0; 
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);

        return helper(num, num.length - 1);
    }

    private ArrayList<ArrayList<Integer>> helper (int[] num, int index) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int cnt = 0; 

        if (index < 0) {
            result.add(new ArrayList<Integer>());
            prevCount = 1; 
            return result;
        }

        result = helper(num, index - 1);
        int len = result.size();
        int left = 0; 

        if (index > 0 && num[index] == num[index - 1]) {
            left = len - prevCount;
        }

        for (int i = left; i < len; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>(result.get(i));
            temp.add(num[index]);
            result.add(temp);
            cnt++; 
        }
        
        prevCount = cnt; 

        return result;
    }
}
