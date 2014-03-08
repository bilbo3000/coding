class Solution {
public:
    int maxArea(vector<int> &height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i = 0; 
        int j = height.size() - 1; 
        int maxArea = 0; 
        
        while (i <= j) {
            int currArea = min(height[i], height[j]) * (j - i); 
            
            if (currArea > maxArea) {
                maxArea = currArea;  
            }
            
            if (height[i] <= height[j]) {
                i++; 
            }
            else {
                j--; 
            }
        }
        
        return maxArea; 
    }
};
