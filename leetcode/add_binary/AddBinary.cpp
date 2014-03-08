#include <iostream> 

using namespace std; 

class Solution {
public:
    string addBinary(string a, string b) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (a.size() == 0) {
            return b; 
        }
        
        if (b.size() == 0) {
            return a; 
        }
        
        int i = a.size() - 1; 
        int j = b.size() - 1; 
        int carry = 0; 
        int digit = 0; 
        string result = ""; 
        
        while (i >= 0 && j >= 0) {
            int temp = (a[i] - '0') + (b[j] - '0') + carry; 
            carry = temp / 2; 
            digit = temp % 2; 
            
            if (digit == 0) {
                result = "0" + result; 
            }
            else {
                result = "1" + result; 
            }
            
            i--; 
            j--; 
        }
        
        if (i < 0) {
            while (j >= 0) {
                int temp = (b[j] - '0') + carry; 
                carry = temp / 2; 
                digit = temp % 2; 
                
                if (digit == 0) {
                    result = "0" + result; 
                }
                else {
                    result = "1" + result; 
                } 
                
                j--; 
            }
        }
        else if (j < 0) {
            while (i >= 0) {
                int temp = (a[i] - '0') + carry; 
                carry = temp / 2; 
                digit = temp % 2; 
                
                if (digit == 0) {
                    result = "0" + result; 
                }
                else {
                    result = "1" + result; 
                }
                
                i--; 
            }
        }
        
        if (carry == 1) {
            result = "1" + result; 
        }
        
        return result; 
    }
};

int main() {
    Solution sln; 
    cout << sln.addBinary("1", "1") << endl; 
    return 0; 
}
