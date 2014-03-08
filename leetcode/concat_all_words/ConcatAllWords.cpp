#include <iostream> 
#include <vector> 
#include <map> 

using namespace std; 

class Solution {
public:
    vector<int> findSubstring(string S, vector<string> &L) {
        vector<int> result; 
        int cnt = L.size(); 
        
        if (cnt == 0) {
            return result; 
        }
        
        int len = L[0].size(); 
        
        if (S.size() < cnt * len) {
            return result; 
        }
        
        map<string, int> needToFind; 
        
        for (int i = 0; i < cnt; i++) {
            if (needToFind.find(L[i]) == needToFind.end()) {
                needToFind[L[i]] = 1; 
            }
            else {
                needToFind[L[i]]++; 
            }
        }
        
        int i = 0;

        while (i <= S.size() - cnt * len) {
            map<string, int> hasFound;
            int counter = 0; 
            int j = i; 
            
            while (j <= S.size() - len && j < i + cnt * len) {
                string tempStr = S.substr(j, len);
                if (needToFind.find(tempStr) == needToFind.end()) break;
                
                if (hasFound.find(tempStr) == hasFound.end()) {
                    hasFound[tempStr] = 1; 
                    counter++; 
                }
                else {
                    if (hasFound[tempStr] < needToFind[tempStr]) {
                        hasFound[tempStr]++; 
                        counter++; 
                    }
                    else {
                        break; 
                    }
                }
                
                if (counter == cnt) {
                    result.push_back(i);
                    break; 
                }
                
                j = j + len; 
            }
            
            i++; 
        }
        
        return result; 
    }
};

int main() {
	Solution sln; 
	
	//S = “mississippi”, L = {“si”,”is”)
	//string S = "barfoothefoobarman"; 
	string S = "mississippi"; 
	vector<string> L; 
	// L.push_back("bar");
	// L.push_back("foo");
	L.push_back("si");  
	L.push_back("is"); 
	 
	vector<int> result = sln.findSubstring(S, L); 
	
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << " "; 
	}
	
	cout << endl; 
}
