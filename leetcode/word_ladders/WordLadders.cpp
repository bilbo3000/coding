class Solution {
public:
    int ladderLength(string start, string end, unordered_set<string> &dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int result = 0;   // Number of words (levels) between start and end 
        if (start == end) {
            return result; 
        }
        
        queue<string> q; 
        unordered_set<string> history;  // Track words that already been added, avoid cycle
        int lev1 = 1;  // Number of words at current to be process
        int lev2 = 0;  // Number of words in the next level
        
        q.push(start); 
        history.insert(start); 
        
        while (q.size() != 0) {
            string curr = q.front(); 
            q.pop(); 
            lev1--;  // One element less need to be processed
            
            // Collect all the dict words current word can lead to
            for (int i = 0; i < curr.size(); i++) {
                for (int j = 0; j < 26; j++) {
                    string temp = curr; 
                    temp[i] = 'a' + j;  // Change current letter
                    if (temp == end) {  // If find at current level
                        return result + 2;  // +2 because we need to cound starting and ending word
                    }
            
                    if (dict.find(temp) != dict.end() && history.find(temp) == history.end()) {
                        q.push(temp);
                        lev2++; 
                        history.insert(temp); 
                    }
                }
            }
            
            if (lev1 == 0) {  // Finish processing all words at current level
                lev1 = lev2; 
                lev2 = 0; 
                
                // After processing current level and coundn't find, means we have 
                // one more level between start and end
                result++;  
            }
        }
        
        return 0; 
    }
};
