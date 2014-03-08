#include <iostream> 
#include <stack> 

using namespace std; 

void LongestSubsequence(string a, string b) {
    int sizea = a.size(); 
    int sizeb = b.size(); 
    stack<char> s; 
    
    // T[i][j]: length of longest sub sequence of a[0..i] and b[0..j]
    int T[sizea][sizeb];  
    
    // D[i][j]: 0: diagonal; 1: horizontal; 2: vertical; 
    int D[sizea][sizeb]; 
    
    // Initialization 
    for (int i = 0; i < sizea; i++) {
        T[i][0] = 0; 
        D[i][0] = 2; 
    }
    
    for (int j = 0; j < sizeb; j++) {
        T[0][j] = 0; 
        D[0][j] = 1; 
    }
    
    for (int i = 1; i < sizea; i++) {
        for (int j = 1; j < sizeb; j++) {
            if (a[i] == b[j]) {  // Last char are the same 
                T[i][j] = T[i - 1][j - 1] + 1; 
                D[i][j] = 0; 
            } else {
                int max = T[i - 1][j]; 
                D[i][j] = 2; 
                
                if (T[i][j - 1] > max) {
                    max = T[i][j - 1]; 
                    D[i][j] = 1;
                }
                
                if (T[i - 1][j - 1] > max) {
                    max = T[i - 1][j - 1]; 
                    D[i][j] = 0; 
                }
                
                T[i][j] = max; 
            }
        }
    }
    
    for (int i = 0; i < sizea; i++) {
        for (int j = 0; j < sizeb; j++) {
            cout << T[i][j] << " "; 
        }
        cout << endl; 
    }
    
    cout << endl; 
    
    for (int i = 0; i < sizea; i++) {
        for (int j = 0; j < sizeb; j++) {
            cout << D[i][j] << " "; 
        }
        cout << endl; 
    }
    
    
    int i = sizea - 1; 
    int j = sizeb - 1; 
    
    while (i >= 0 && j >= 0) {
        int tempd = D[i][j]; 
        int tempt = T[i][j]; 
        
        if (tempd == 0) {  // Move diagonal
            i--; 
            j--; 
            if (T[i][j] < tempt) {
                s.push(a[i + 1]); 
            }
        }
        else if (tempd == 1) {  // Move horizontal 
            j--; 
            if (T[i][j] < tempt) {
                s.push(a[i + 1]); 
            }
        } else { // Move vertical 
            i--; 
            if (T[i][j] < tempt) {
                s.push(b[j + 1]); 
            }
        }
    }
    
    while (s.size() != 0) {
        cout << s.top() << " "; 
        s.pop(); 
    } 
    
    cout << endl; 
}

// Test driver 
int main() {
    string a = "abcdexxfg"; 
    string b = "xxbxxdxxfxx";  
    
    LongestSubsequence(a, b);
     
    cout << "a: " << a << endl; 
    cout << "b: " << b << endl;
    
    return 0; 
}
