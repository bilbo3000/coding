#include <iostream> 

using namespace std; 

class Solution {
public:
    string getPermutation(int n, int k) {
        string result = ""; 
        for (int i = 1; i <= n; i++) {
            result += (char)(i + '0'); 
        }
        
        k--; 
        while (k > 0) {
            nextPermutation(result); 
            k--; 
        }
        
        return result; 
    }
    
    void nextPermutation(string &s) {
        if (s.size() <= 1) {
            return; 
        }
        
        int first = -1; 
        for (int i = s.size() - 2; i >= 0; i--) {
            if (s[i] < s[i + 1]) {
                first = i; 
                break; 
            }
        }
        
        if (first == -1) {
            return; 
        }
        
        int second = first + 1; 
        for (int j = s.size() - 1; j >= first + 1; j--) {
            if (s[j] > s[first]) {
                second = j; 
                break; 
            }
        } 
        
        // Swap
        swap(s[first], s[second]);  
        
        // Reverse
        int a = first + 1; 
        int b = s.size() - 1; 
        
        while (a < b) {
            swap(s[a], s[b]); 
            a++; 
            b--; 
        } 
    }
    
    void swap(char &a, char & b) {
        char temp = b; 
        b = a; 
        a = temp; 
    }
};

int main() {
	Solution sln; 
	cout << sln.getPermutation(9, 219601) << endl; 
}
