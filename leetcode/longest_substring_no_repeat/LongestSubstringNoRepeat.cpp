class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int size = s.size(); 
        
        if (size == 0) {
            return 0; 
        }
        
        int T[size];
        
        for (int i = 0; i < size; i++) {
            T[i] = 0; 
        }
        
        for (int i = 0; i < size; i++) {
            bool arr[26]; 
            
            for (int k = 0; k < 26; k++) {
                arr[k] = false; 
            }
            
            arr[s[i] - 'a'] = true; 
            int cnt = 1; 
            int j = i - 1;
            
            while (j >= 0) {
                int index = s[j] - 'a'; 
                
                if (arr[index]) {
                    break; 
                }
                
                arr[index] = true; 
                cnt++; 
                j--; 
            }
            
            T[i] = cnt; 
        }
        
        int max = T[0]; 
        
        for (int i = 1; i < size; i++) {
            if (T[i] > max) {
                max = T[i]; 
            }
        }
        
        return max; 
    }
};
