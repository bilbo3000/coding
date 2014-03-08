#include <iostream> 
#include <sstream> 
#include <vector> 

using namespace std; 

class Solution {
public:
    string multiply(string num1, string num2) {
        if (num1 == "0" && num2 == "0") {
            return "0"; 
        }
 
        int size1 = num1.size(); 
        int size2 = num2.size(); 
        
        vector<int> vec1(size1, 0);
        vector<int> vec2(size2, 0);
        vector<int> result(size1 + size2, 0);
        
        for (int i = size1 - 1; i >= 0; i--) {
            vec1[size1 - i - 1] = num1[i] - '0'; 
        }   
        
        for (int i = size2 - 1; i >= 0; i--) {
            vec2[size2 - i - 1] = num2[i] - '0'; 
        }
        
        for (int j = 0; j < size2; j++) {
            int carry = 0; 
            for (int i = 0; i < size1; i++) {
                int sum = result[j + i] + vec2[j] * vec1[i] + carry;
                int digit = sum % 10; 
                result[j + i] = digit; 
                carry = sum / 10;  
            }
            
            result[j + size1] += carry; 
        }
        
        string resultStr = ""; 
        int i = result.size() - 1; 
        
        while (i >= 0 && result[i] == 0) {
            i--; 
        }
        
        if (i < 0) {
            return "0"; 
        }
        
        while (i >= 0) {
            stringstream ss; 
            ss << result[i]; 
            resultStr += ss.str(); 
            i--; 
        }
        
        return resultStr; 
    }
};

int main() {
    Solution sln; 
    cout << sln.multiply("999", "0") << endl; 
    return 0; 
}
