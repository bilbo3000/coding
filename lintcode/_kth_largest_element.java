
class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    // O(n) time, O(1) space
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        return helper(k, numbers, 0, numbers.size() - 1); 
    }
    
    private int helper(int k, ArrayList<Integer> numbers, int l, int r) {
        int index = partition(numbers, l, r); 
        
        if (r + 1 - index == k) {
            return numbers.get(index);
        }
        
        if (r + 1 - index < k) {
            return helper(k - (r + 1 - index), numbers, l, index - 1); 
        } else {
            return helper(k, numbers, index + 1, r); 
        }
    }
    
    private int partition(ArrayList<Integer> numbers, int l, int r) {
        if (l == r) {
            return l; 
        }
        
        int pivot = numbers.get(r);
        int last = l - 1; 
        
        for (int i = l; i <= r - 1; i++) {
            if (numbers.get(i) <= pivot) {
                last++; 
                swap(numbers, last, i);
            }
        }
        
        swap(numbers, last + 1, r); 
        
        return last + 1; 
    }
    
    private void swap(ArrayList<Integer> numbers, int l, int r) {
        int temp = numbers.get(l);
        numbers.set(l, numbers.get(r));
        numbers.set(r, temp);
    }
};
