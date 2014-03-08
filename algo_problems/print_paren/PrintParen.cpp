#include <iostream> 

using namespace std; 

// l: how many ( remains; r: how many ) remains; 
void PrintParen(int l, int r, char s[], int index) {
    if (l == 0 && r == 0) {  // Nothing remaining 
        cout << s << endl; 
        return; 
    }
     
    if (l > 0) {
        s[index] = '('; 
        PrintParen(l - 1, r, s, index + 1); 
    }
    
    if (r > l) {
        s[index] = ')'; 
        PrintParen(l, r - 1, s, index + 1); 
    }
    
}

// Test driver
int main() {
    char c[3 * 2]; 
    PrintParen(3, 3, c, 0);
     
    return 0; 
}
