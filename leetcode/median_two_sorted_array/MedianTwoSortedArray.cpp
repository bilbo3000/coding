#include <iostream> 

using namespace std; 

class Solution {
public:
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        int total = m + n; 
        
        if (total % 2 == 0) {  // Length is even
            return (findMedianHelper(A, m, B, n, (m + n) / 2) + findMedianHelper(A, m, B, n, (m + n) / 2 + 1)) / 2; 
        }
        else {  // Length is odd 
            return findMedianHelper(A, m, B, n, (m + n) / 2 + 1);
        }
    }
    
    double findMedianHelper(int A[], int m, int B[], int n, int k) {
        if (m > n) {  // Always make sure A is smaller 
            return findMedianHelper(B, n, A, m, k); 
        }
        
        if (m == 0) return B[k - 1]; 
        if (k == 1) return min(A[0], B[0]); 
        
        int pa = min(m, k / 2); 
        int pb = k - pa; 
        
        if (A[pa - 1] < B[pb - 1]) {
            return findMedianHelper(A + pa, m - pa, B, n, k - pa); 
        }
        else if (A[pa - 1] > B[pb - 1]) {
            return findMedianHelper(A, m, B + pb, n - pb, k - pb); 
        }
        else {
            return A[pa - 1]; 
        }
    }
};

int main() {
	Solution sln; 
	int A[] = {1, 2}; 
	int B[] = {1, 2};
	
	cout << sln.findMedianSortedArrays(A, 2, B, 2) << endl; 
	
	return 0; 
}
