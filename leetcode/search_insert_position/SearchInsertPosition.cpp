#include <iostream> 

using namespace std; 

class Solution {
public:
    int searchInsert(int A[], int n, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n == 0) {
            return 0; 
        }
        
        return searchInsertHelper(A, 0, n - 1, target); 
    }
    
    int searchInsertHelper(int A[], int left, int right, int target) {
        if (left == right) {
            if (A[left] == target) {
                return left; 
            }
            else if (A[left] > target) {
                return left; 
            }
            else {
                return left + 1; 
            }
        }
        else {
            int mid = (left + right) / 2; 
            if (A[mid] == target) {
                return mid; 
            }
            else if (A[mid] < target) {
            	if (mid == right) {
            		return mid + 1; 
            	}
            	else {
            		return searchInsertHelper(A, mid + 1, right, target); 
                }
            }
            else {
            	if (mid == left) {
            		return mid; 
            	}
            	else {
                	return searchInsertHelper(A, left, mid - 1, target); 
                }
            }
        }
    }
};

int main() {
	Solution sln; 
	int A[] = {1, 3}; 
	cout << sln.searchInsert(A, 2, 0) << endl; 
	return 0; 
}
