class Solution {
public:
    int singleNumber(int A[], int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        map<int, int> m; 
        for (int i = 0; i < n; i++) {
            if (m.find(A[i]) == m.end()) {
                m[A[i]] = 1; 
            }
            else {
                m[A[i]]++; 
            }
        }
        
        for (map<int, int>::iterator it = m.begin(); it != m.end(); it++) {
            if (it->second == 1) {
                return it->first; 
            }
        }
    }
};
