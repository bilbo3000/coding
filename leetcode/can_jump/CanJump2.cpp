#include <iostream> 

using namespace std; 

class Solution {
public:
    bool canJump(int A[], int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n == 0) {
            return false; 
        }
        
        if (n == 1) {
            return true; 
        }
        
        bool T[n]; 
        T[0] = true; 
        
        for (int i = 1; i < n; i++) {
        	T[i] = false; 
        } 
        
        for (int i = 1; i < n; i++) {
        	for (int j = i - 1; j >= 0; j--) {
        		if (T[j] && (A[j] >= (i - j))) {
        			T[i] = true; 
        			break; 
        		}
        	}
        }
        
        return T[n - 1];
    }
    
};

int main() {
	Solution sln; 
	// A = [2,3,1,1,4], return true.
	// A = [3,2,1,0,4], return false.
	int A[] = {1, 2}; 
	if (sln.canJump(A, 2)) {
		cout << "true" << endl; 
	}
	else {
		cout << "false" << endl; 
	}
}
