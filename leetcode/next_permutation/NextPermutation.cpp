#include <iostream> 
#include <vector> 
#include <algorithm> 

using namespace std; 

class Solution {
public:
    void swap(int &a, int &b) {
        int temp = a; 
        a = b; 
        b = temp; 
    }
    
    void nextPermutation(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (num.size() <= 1) {
            return; 
        }
        
        int i = num.size() - 2; 
        while (i >= 0 && (num[i] >= num[i + 1])) {
            i--; 
        }
        
        if (i < 0) {
            reverse(num.begin(), num.end()); 
            return; 
        }
        
        int j = i + 1; 
        while (j < num.size() && num[j] > num[i]) {
            j++; 
        }
        
        swap(num[i], num[j - 1]); 
        reverse(num.begin() + i + 1, num.end()); 
    }
};

int main() {
    Solution sln; 
    vector<int> num; 
    num.push_back(1); 
    num.push_back(5); 
    num.push_back(1);
    sln.nextPermutation(num); 
    for (int i = 0; i < num.size(); i++) {
        cout << num[i] << " "; 
    }
    return 0; 
}
