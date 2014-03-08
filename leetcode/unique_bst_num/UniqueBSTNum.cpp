class Solution {
public:
    int numTrees(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int result = 0; 
        if (n <= 1) {
            return 1; 
        }
        
        for (int i = 0; i < n; i++) {
            int left = numTrees(i);
            int right = numTrees(n - i - 1); 
            result += left * right; 
        }
        
        return result; 
    }
};
