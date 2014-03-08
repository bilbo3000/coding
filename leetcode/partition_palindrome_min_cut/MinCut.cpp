#include <iostream> 
#include <cmath> 

using namespace std; 

class Solution {
public:
    /*
    bool isPalindrome(string s) {
        if (s.size() == 0) {
            return false; 
        }
        if (s.size() == 1) {
            return true; 
        }
        
        int i = 0; 
        int j = s.size() - 1; 
        
        while (i <= j) {
            if (s[i] != s[j]) {
                return false; 
            }
            
            i++; 
            j--; 
        }
        
        return true; 
    }
    */
    
    int minCut(string s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s.size() == 0) {
            return 0; 
        }
        
        int size = s.size(); 
        // Build palindrome DP table 
        bool palinT[size][size]; 
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                palinT[i][j] = false; 
            }
        }
        
        int T[size + 1]; 
        for (int i = 0; i <= size; i++) {
            T[i] = i;  
        } 
        
        for (int i = 0; i < size; i++) {
            for (int j = i; j >= 0; j--) {
                if (s[j] == s[i] && (i - j < 2 || palinT[j + 1][i - 1])) {  // s[j+1..i] is a palindrome
                    palinT[j][i] = true; 
                    T[i + 1] = min(T[j] + 1, T[i + 1]); 
                }
            }
        } 
        
        for (int i = 0; i < size + 1; i++) {
            cout << T[i] << " "; 
        }
        cout << endl; 
        
        return T[size] - 1; 
    }
};

int main() {
    Solution sln; 
    //cout << sln.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp") << endl; 
    cout << sln.minCut("abcccb") << endl; 
    return 0; 
}
