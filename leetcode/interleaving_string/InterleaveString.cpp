#include <iostream> 
#include <vector>

using namespace std; 

class Solution {
public:
    bool helper(string &s1, string &s2, string &s3, int i, int j, int k, vector<vector<bool> > &T) {
        if (!T[i][j]) {
            return false; 
        }
        
        if (k == s3.size() && i == s1.size() && j == s2.size()) {
            return true; 
        }
        
        bool result = false; 
        
        if (i != s1.size() && s1[i] == s3[k]) {
            result = helper(s1, s2, s3, i + 1, j, k + 1, T); 
            if (!result) T[i + 1][j] = false;
        }
        
        if (!result && j != s2.size() && s2[j] == s3[k]) {
            result = helper(s1, s2, s3, i, j + 1, k + 1, T); 
            if (!result) T[i][j + 1] = false; 
        }
        
        return result; 
    }
    
    bool isInterleave(string s1, string s2, string s3) {
        
        if ((s1.size() + s2.size()) != s3.size()) return false; 
        if (s3.size() == 0) return true; 
        if (s1.size() == 0) {
        	if (s2 != s3) return false; 
        	else return true; 
        }
        if (s2.size() == 0) {
        	if (s1 != s3) return false; 
        	else return true; 
        }
        
        string temp1 = s1 + s2; 
        string temp2 = s3; 
        sort(temp1.begin(), temp1.end()); 
        sort(temp2.begin(), temp2.end()); 
        
        if (temp1 != temp2) return false;
        
        vector<vector<bool> > T; 
        
        for (int i = 0; i <= s1.size(); i++) {
            vector<bool> temp(s2.size() + 1, true); 
            T.push_back(temp); 
        }
        
        int i = 0; 
        int j = 0; 
        int k = 0; 
        
        return helper(s1, s2, s3, i, j, k, T); 
    }
};

int main() {
	Solution sln; 

	// "aa", "ab", "aaba"
	if (sln.isInterleave("aa", "ab", "aaba")) {
		cout << "true" << endl; 
	}
	else {
		cout << "false" << endl; 
	}
}