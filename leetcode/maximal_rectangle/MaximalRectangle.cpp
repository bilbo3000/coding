#include <iostream> 
#include <vector> 

using namespace std; 

class Solution {
public:
    int maximalRectangle(vector<vector<char> > &matrix) {
        int m = matrix.size(); 
        
        if (m == 0) {
            return 0; 
        }
        
        int n = matrix[0].size(); 
        
        // Simplify to vectors. Reuse them for next row
        vector<int> H(n, 0);  // Length of hang-line ending at current element 
        vector<int> L(n, 0);  // Index of first valid in this stripe to the left
        vector<int> R(n, n);  // Index of first invalid in this stripe to the right
        int maxArea = 0; 
        
        for (int i = 0; i < m; i++) {
            int left = 0;  // First valid to the left 
            int right = n;  // First invalid to the right 
            
            // Calculate L --> move left to right (because of 'left')
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    H[j]++; 
                    L[j] = max(L[j], left); 
                }
                else {
                    H[j] = 0; 
                    left = j + 1; 
                    L[j] = 0;
                    R[j] = n; 
                }
            }
            
            // Calculate R --> move right to left (because of 'right')
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    R[j] = min(R[j], right); 
                    maxArea = max(maxArea, H[j] * (R[j] - L[j])); 
                }
                else {
                    right = j; 
                }
            }
        }
        
        return maxArea; 
    }
};

int main() {
	Solution sln; 
	vector<vector<char> > matrix; 
	vector<char> row(1, '1'); 
	matrix.push_back(row); 
	
	cout << sln.maximalRectangle(matrix) << endl; 
}
