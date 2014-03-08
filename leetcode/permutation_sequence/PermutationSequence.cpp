#include <iostream> 
#include <vector> 

using namespace std; 

class Solution {
public:
    string getPermutation(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        vector<int> num; 
        for (int i = 1; i <= n; i++) {
            num.push_back(i); 
        }
        vector<string> result = helper(num); 
        if (k <= result.size() && k > 0) {
            return result[k - 1]; 
        }
        else {
            return ""; 
        }
    }
    
    vector<string> helper(vector<int> num) {
        vector<string> result; 
        if (num.size() == 0) {
            return result; 
        }
        
        if (num.size() == 1) {
            string temp = ""; 
            temp += (char)('0' + num[0]); 
            result.push_back(temp);
            return result; 
        }
        
        for (int i = 0; i < num.size(); i++) {
            vector<int> nextNum(num);
            nextNum.erase(nextNum.begin() + i);
            vector<string> tempResult = helper(nextNum);
            for (int j = 0; j < tempResult.size(); j++) {
                string permutation = (char)(num[i] + '0') + tempResult[j]; 
                result.push_back(permutation); 
            }
        }
        
        return result; 
    }
};

int main() {
	Solution sln; 
	cout << sln.getPermutation(9, 54494) << endl; 
	return 0; 	
}
