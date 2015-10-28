public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     * Sort the array first. Then for each first element, use collsion two pointers
     * to find the second and the third element. 
     * 
     * O(n^2) time.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(); 
        Arrays.sort(numbers);
        
        for (int i = 0; i < numbers.length - 2; i++) {
            int l = i + 1; 
            int r = numbers.length - 1; 
            
            while (l < r) {
                int sum = numbers[i] + numbers[l] + numbers[r]; 
                
                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<>(); 
                    temp.add(numbers[i]);
                    temp.add(numbers[l]);
                    temp.add(numbers[r]);
                    set.add(temp);
                    l++; 
                    r--; 
                } else if (sum > 0) {
                    r--; 
                } else {
                    l++; 
                }
            }
        }
        
        result.addAll(set);
        
        return result; 
    }
}
