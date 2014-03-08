#include <iostream> 

using namespace std; 

class Solution {
public:
    int binarySearch(int A[], int l, int r, int target) {
        if (l > r) {
            return -1; 
        }
        
        int mid = (l + r) / 2; 
        if (A[mid] == target) {
            return mid; 
        }
        else if (target < A[mid]) {
            return binarySearch(A, l, mid - 1, target); 
        }
        else {
            return binarySearch(A, mid + 1, r, target); 
        }
    } 
    
    int search(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (n <= 0) {
            return -1; 
        }
        
        int pivot = 0; 
        
        for (int i = 1; i < n; i++) {
            if (A[i - 1] > A[i]) {
                pivot = i; 
                break; 
            }
        }
        
        if (target >= A[pivot] && target <= A[n - 1]) {
            return binarySearch(A, pivot, n - 1, target); 
        }
        else if (pivot > 0 && target <= A[pivot - 1] && target >= A[0]) {
            return binarySearch(A, 0, pivot - 1, target); 
        }
        else {
            return -1; 
        }
    }
};

int main() {
    int A[] = {4, 5, 6, 7, 1, 2, 3}; 
    Solution sln; 
    cout << sln.search(A, 7, 7) << endl; 
    return 0; 
}
