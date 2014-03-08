#include <iostream> 
#include <string> 

using namespace std; 

void RemoveDuplicates(string s) {
    int history = 0; 
    int i = 0; 
    while (i < s.size()) {  // Loop through the string
        int value = 1 << (s[i] - 'a'); 
        if (!(history & value)) {  // First time seen
            history = history | value;  // Absorb
            i = i + 1;  
        }
        else {  // Already seen, move rest of the string
            s.erase(i, 1); 
        }
    }
    
    cout << s << endl; 
}

// Test driver 
int main() {
    string s1 = "abcd"; 
    string s2 = "aaaa"; 
    string s3 = "";
    string s4 = "aaabbb";  
    RemoveDuplicates(s1); 
    RemoveDuplicates(s2); 
    RemoveDuplicates(s3); 
    RemoveDuplicates(s4); 
    return 0; 
}
