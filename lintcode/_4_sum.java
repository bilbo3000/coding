public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     * 
     * Note always skip an element if it is the same as previous one. Because 
     * what it can will must already been taken care of by its previous element.
     * O(n^3)
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {   
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                // No need to process the same element. 
                continue; 
            }
            
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    // No need to process the same element. 
                    continue; 
                }
                
                int l = j + 1; 
                int r = numbers.length - 1; 
                
                while (l < r) {
                    int sum = numbers[i] + numbers[j] + numbers[l] + numbers[r]; 
                    
                    if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>(); 
                        temp.add(numbers[i]);
                        temp.add(numbers[j]);
                        temp.add(numbers[l]);
                        temp.add(numbers[r]);
                        result.add(temp);
                        
                        do {
                            l++; 
                        } while (l < r && numbers[l] == numbers[l - 1]); 
                        
                        do {
                            r--; 
                        } while (l < r && numbers[r] == numbers[r + 1]);
                    } else if (sum > target) {
                        do {
                            r--; 
                        } while (l < r && numbers[r] == numbers[r + 1]);
                    } else {
                        do {
                            l++; 
                        } while (l < r && numbers[l] == numbers[l - 1]);
                    }
                }
            }
        }
        
        return result; 
    }
}

