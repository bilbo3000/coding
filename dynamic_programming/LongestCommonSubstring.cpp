#include <iostream> 

using namespace std; 

void LongestCommonSubstring(string a, string b) {
    int size_a = a.size(); 
    int size_b = b.size(); 
    
    // Let T[i, j] be the length LCS ending at ith a and jth b
    int T[size_a + 1][size_b + 1]; 
    
    for (int i = 0; i <= size_a; i++) {  // Initialize first column
        T[i][0] = 0; 
    }
    
    for (int j = 0; j < size_b; j++) {  // Initialize first row
        T[0][j] = 0; 
    }
    
    int maxLength = 0; 
    int maxRow = 0; 
    int maxColumn = 0; 
    
    for (int i = 1; i <= size_a; i++) {
        for (int j = 1; j <= size_b; j++) {
            if (a[i - 1] == b[j - 1]) {
                T[i][j] = T[i - 1][j - 1] + 1; 
                
                if (T[i][j] > maxLength) {
                    maxLength = T[i][j]; 
                    maxRow = i; 
                    maxColumn = j; 
                }
            }
            else {
                T[i][j] = 0; 
            }
        }
    }
    
    for (int i = maxRow - maxLength; i <= maxRow - 1; i++) {
        cout << a[i] << " "; 
    }
}

// Test Driver 
int main() {
    string a = "my hello world"; 
    string b = "hell"; 
    
    LongestCommonSubstring(a, b);
     
    return 0; 
}
