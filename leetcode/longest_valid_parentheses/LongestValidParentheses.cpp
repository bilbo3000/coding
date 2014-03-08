class Solution {
public:
    int longestValidParentheses(string s) {
        int last = -1; 
        int maxLength = 0; 
        stack<int> stk; 
        
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                stk.push(i); 
            }
            else {
                if (stk.size() == 0) {  // ) is a seperator 
                    last = i; 
                }
                else {  // Match 
                    stk.pop(); 
                    
                    if (stk.size() == 0) {  // After matching, stack becomes empty
                        maxLength = max(maxLength, i - last); 
                    }
                    else {
                        maxLength = max(maxLength, i - stk.top()); 
                    }
                }
            }
        }
        
        return maxLength; 
    }
};
