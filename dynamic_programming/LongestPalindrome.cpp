#include <iostream> 

using namespace std; 

void LongestPalindrome(string s) {
    int size = s.size(); 
    
    // T[i][j]: if s[i..j] is a palindrome
    bool T[size][size]; 
    
    
    // Initialization 
    for (int i = 0; i < size; i++) {
        T[i][i] = true;  // A single letter is always a palindrome
        
        if (((i + 1) < size) && (s[i] == s[i + 1])) {
            // Two consecutive letters also forms a palindrome
            T[i][i + 1] = true; 
        }
    }
    
    for (int i = 0; i < size - 2; i++) {
        for (int j = i + 2; j < size; j++) {
            if (s[i] == s[j]) {
                T[i][j] = T[i + 1][j - 1] && true; 
            }
            else {
                T[i][j] = false; 
            }
        }
    }
    
    // Restore 
    int maxLength = 0; 
    int maxFront = 0; 
    int maxBack = 0; 
    
    for (int i = 0; i < size; i++) {
        for (int j = i; j < size; j++) {
            if (T[i][j] && ((j - i + 1) > maxLength)) {
                maxFront = i; 
                maxBack = j; 
                maxLength = j - i + 1; 
            }
        }
    }
    
    for (int i = maxFront; i <= maxBack; i++) {
        cout << s[i] << " "; 
    }
}

// Test driver 
int main() {
    string s = "xxabay"; 
    LongestPalindrome(s);
     
    return 0; 
}
