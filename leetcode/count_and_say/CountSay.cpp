#include <iostream> 

using namespace std; 

class Solution {
public:
    string countAndSay(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n < 1) {
            return ""; 
        }
        
        if (n == 1) {
            return "1"; 
        }
        
        string result = "1"; 
        int i = 2; 
        
        while (i <= n) {  // Look for nth number
            string temp = ""; 
            char prev = '\0'; 
            int cnt = 0; 
            
            for (int j = 0; j < result.size(); j++) {
                char curr = result[j]; 
                
                if (curr != prev && prev != '\0') {
                    temp += (char)(cnt + '0'); 
                    temp += prev; 
                    cnt = 0; 
                }
                
                cnt++; 
                prev = curr; 
            }
            
            temp += (char)(cnt + '0'); 
            temp += prev; 
            
            result = temp; 
            i++; 
        }
        
        return result; 
    }
};

int main() {
	Solution sln; 
	cout << sln.countAndSay(4) << endl; 
	return 0; 
}
