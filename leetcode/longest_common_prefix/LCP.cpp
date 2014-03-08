#include <iostream> 
#include <vector> 
#include <sstream> 

using namespace std; 
    typedef struct Node {
        int cnt; 
        Node * next[26]; 
    } Node;
    
class Solution {
public:
 
    
    string longestCommonPrefix(vector<string> &strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Node * root = new Node(); 
        string result = ""; 
        
        for (int i = 0; i < strs.size(); i++) {
            mapToTrie(root, strs[i]); 
        }
        
        int size = strs.size(); 
        Node * curr = root; 
        while (curr != NULL) {
            int i = 0; 
            while (i < 26) {
                if (curr->next[i] != NULL && curr->next[i]->cnt == size) {
                    curr = curr->next[i]; 
                    stringstream ss; 
                    ss << (char)('a' + i);
                    string tempstr; 
                    ss >> tempstr;  
                    result = result + tempstr; 
                    break; 
                }
                i++; 
            }
            if (i == 26) {
            	break; 
            }
        }
        
        return result; 
    }
    
    void mapToTrie(Node * root, string s) {
        Node * curr = root; 
        curr->cnt++; 
        for (int i = 0; i < s.size(); i++) {
            int index = s[i] - 'a'; 
            if (!curr->next[index]) {
                Node * newNode = new Node(); 
                curr->next[index] = newNode; 
                curr = curr->next[index]; 
                curr->cnt++; 
            }
            else {
                curr = curr->next[index]; 
                curr->cnt++; 
            }
        }
    }
};

int main() {
	Solution sln; 
	vector<string> strs; 
	strs.push_back("abcde"); 
	strs.push_back("abcd");
	strs.push_back("bc");

	cout << sln.longestCommonPrefix(strs) << endl; 
	return 0; 
}
