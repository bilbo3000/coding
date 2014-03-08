#include <iostream> 
#include <map> 
#include <vector> 

using namespace std; 

class Solution {
public:
    int removeDuplicates(int A[], int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        map<int, int> table; 
        int result = 0; 
        
        int i = 0; 
        while (i < n) {
            int key = A[i]; 
            
            if (table.find(key) == table.end()) {
                table[key] = 1; 
            }
            else {
                if (table[key] < 2) {
                    table[key]++; 
                }
            }
            
            i++; 
        }
        
        vector<int> output; 
        for (map<int, int>::iterator it = table.begin(); it != table.end(); it++) {
        	int temp = it->second; 
        	for (int i = 0; i < temp; i++) {
        		output.push_back(it->first); 
        	}
        	
            result += temp; 
        }
        
        for (int i = 0; i < result; i++) {
        	A[i] = output[i]; 
        }
        
        return result; 
    }
};

int main() {
	Solution sln; 
	int A[] = {1,1,1,2,2,3}; 
	int result = sln.removeDuplicates(A, 6); 
	cout << result << endl; 
	
	int i = 0; 
	while (i < result) {
		cout << A[i] << " "; 
		i++; 
	}
	
	return 0; 
}
