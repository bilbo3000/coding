class Solution {
public:
    vector<int> searchRangeHelper(int A[], int l, int r, int n, int target) {
        if (l <= r) {
            int mid = (l + r) / 2; 
            
            if (A[mid] > target) {
                return searchRangeHelper(A, l, mid - 1, n, target); 
            }
            else if (A[mid] < target) {
                return searchRangeHelper(A, mid + 1, r, n, target); 
            }
            else {
                int i = mid; 
                int j = mid; 
                
                while (i >= 0 && A[i] == A[mid]) {
                    i--; 
                }
                
                i = i + 1; 
                
                while (j < n && A[j] == A[mid]) {
                    j++; 
                }
                
                j = j - 1; 
                
                vector<int> result; 
                result.push_back(i);
                result.push_back(j);
                return result; 
            }
        }
        else {
            vector<int> result; 
            result.push_back(-1);
            result.push_back(-1); 
            return result; 
        }
    }
    
    vector<int> searchRange(int A[], int n, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return searchRangeHelper(A, 0, n - 1, n, target); 
    }
};
