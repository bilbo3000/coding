#include <iostream> 
#include <set>
#include <vector> 

using namespace std; 

class Solution {
public:
    vector<string> wordBreak(string s, set<string> &dict) {
        int n = s.size(); 
        vector<vector<string> > T(n);  // T[i]: the sentences formed by first ith letter in s
        vector<bool> flag(n, false); 
        
        for (int i = 0; i < n; i++) {
            int j = i; 
            
            while (j >= 0) {
                string seg = s.substr(j, i - j + 1); 
                
                if (dict.find(seg) != dict.end()) {
                    if (j == 0) {
                    	if (!flag[i]) {
                    		vector<string> temp; 
                    		T[i] = temp; 
                    		flag[i] = true; 
                    	}

                        T[i].push_back(seg); 
                    }
                    else {
                        if (flag[j - 1]) {
                            for (int k = 0; k < T[j - 1].size(); k++) {
                                if (!flag[i]) {
                                	vector<string> temp; 
                                	T[i] = temp; 
                                	flag[i] = true; 
                                }
                                	
                                T[i].push_back(T[j - 1][k] + " " + seg); 
                            }
                        }
                    }
                }
                
                j--; 
            }
        }
        
        return T[n - 1]; 
    }
};

int main() {
	Solution sln; 
	string s = "catsanddog"; 
	set<string> dict; 
	dict.insert("cat"); 
	dict.insert("cats"); 
	dict.insert("and"); 
	dict.insert("sand"); 
	dict.insert("dog"); 
	
	vector<string> result = sln.wordBreak(s, dict);
	
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << endl; 
	} 
	return 0; 
}