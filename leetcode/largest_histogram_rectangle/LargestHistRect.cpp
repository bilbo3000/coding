class Solution {
public:
    int largestRectangleArea(vector<int> &height) {
        if (height.size() == 0) {
            return 0; 
        }
        
        height.push_back(0);  // Put a zero at the end for termination
        stack<int> s;  // Stack to store index of rect that may grow
        int maxArea = 0;  // Maximum area
        
        for (int i = 0; i < height.size(); i++) {
            if (s.size() == 0 || height[i] >= height[s.top()]) {
                s.push(i);  // Max area start with current element may grow, put into stack 
            }
            else {  // Need to finalize all elements that cannot grow
                int tosIndex = s.top(); 
                int tosHeight = height[tosIndex]; 
                s.pop(); 
                maxArea = max(maxArea, tosHeight * (s.empty() ? i : (i - 1 - s.top()))); 
                i--; 
            }
        }
        
        return maxArea; 
    }
};
