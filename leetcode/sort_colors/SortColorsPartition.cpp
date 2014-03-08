class Solution {
public:
    void sortColors(int A[], int n) {
        int a = -1; 
        int b = -1; 
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                if (A[b + 1] == 2) {
                    swap(A[a + 1], A[b + 1]); 
                }
                swap(A[a + 1], A[i]); 
                a++; 
                b++; 
            }
            else if (A[i] == 1) {
                swap(A[b + 1], A[i]); 
                b++; 
            }
        }
    }
    
    void swap(int &a, int &b) {
        int temp = a; 
        a = b; 
        b = temp; 
    }
};
