public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     * Sort the array first. Then for each first element, use collsion two pointers
     * to find the second and the third element. 
     * 
     * ** NOTE ** for first element, skip first element if it is the same as 
     * the previous one as in the array. Also, each time move pointers, need to 
     * keep moving till a different number. 
     * 
     * O(n^2) time.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(numbers);
        
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                // If current element is the same as previous element, then
                // everything start from this element has already been taken 
                // care of by its previous element. 
                continue; 
            }
            
            int l = i + 1; 
            int r = numbers.length - 1; 
            
            while (l < r) {
                int sum = numbers[i] + numbers[l] + numbers[r]; 
                
                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<>(); 
                    temp.add(numbers[i]);
                    temp.add(numbers[l]);
                    temp.add(numbers[r]);
                    result.add(temp);
                    
                    do {
                        l++; 
                    } while (l < r && numbers[l] == numbers[l - 1]);
                    
                    do {
                        r--; 
                    } while (l < r && numbers[r] == numbers[r + 1]);
                } else if (sum < 0) {
                    do {
                        l++; 
                    } while (l < r && numbers[l] == numbers[l - 1]); 
                } else {
                    do {
                        r--; 
                    } while (l < r && numbers[r] == numbers[r + 1]); 
                }
            }
        }
        
        return result; 
    }
}
