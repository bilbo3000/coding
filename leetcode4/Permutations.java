public class Solution {
    public List<List<Integer>> permute(int[] num) {
        int len = num.length; 
        List<List<Integer> > result = new ArrayList<List<Integer> >(); 
        
        if (len == 0) {
            return result; 
        }
        
        return helper(num, 0); 
    }
    
    public List<List<Integer> > helper(int[] num, int index) {
        List<List<Integer> > result = new ArrayList<List<Integer> >();;
        
        if (index == num.length - 1) {
            result.add(new ArrayList<Integer>(Arrays.asList(num[index])));
            return result; 
        }
        
        List<List<Integer> > temp = helper(num, index + 1);
        
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < temp.get(i).size(); j++) {
                List<Integer> p = new ArrayList<Integer>(temp.get(i));
                p.add(j, num[index]); 
                result.add(p); 
            }
            
            temp.get(i).add(num[index]);
            result.add(temp.get(i)); 
        }
        
        return result; 
    }
}
