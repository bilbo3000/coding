public class Solution {
    private int cnt = 0; 
    
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num); 
        return helper(num, 0); 
    }
    
    private List<List<Integer> > helper(int[] num, int index) {
        List<List<Integer> > result = new ArrayList<List<Integer> >(); 
        int len = num.length; 
        
        if (index == len) {
            result.add(new ArrayList<Integer>()); 
            cnt = 1; 
            return result; 
        }
        
        List<List<Integer> > temp = helper(num, index + 1);
        result.addAll(temp);
        
        if (index < len - 1 && num[index] == num[index + 1]) {
            for (int i = temp.size() - cnt; i < temp.size(); i++) {
                List<Integer> l = new ArrayList<Integer>(temp.get(i));
                l.add(num[index]);
                Collections.sort(l); 
                result.add(l); 
            }
        } else {
            for (int i = 0; i < temp.size(); i++) {
                List<Integer> l = new ArrayList<Integer>(temp.get(i));
                l.add(num[index]);
                Collections.sort(l); 
                result.add(l);
            }
            cnt = temp.size(); 
        }
        
        return result; 
    }
}
