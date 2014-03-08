class Solution {
public:
    bool searchHelper(int A[], int l, int r, int target) {
        if (l > r) {
            return false; 
        }
        else {
            int mid = (l + r) / 2; 
            if (A[mid] == target) {
                return true; 
            }
            else if (A[mid] < target) {
                return searchHelper(A, mid + 1, r, target); 
            }
            else {
                return searchHelper(A, l, mid - 1, target); 
            }
        }
    }
    
    bool search(int A[], int n, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n == 0) {
            return false; 
        }
        
        int i = 1; 
        
        while (i < n && A[i] >= A[i - 1]) {
            i++; 
        }
        
        return searchHelper(A, 0, i - 1, target) || searchHelper(A, i, n - 1, target);  
    }
};
