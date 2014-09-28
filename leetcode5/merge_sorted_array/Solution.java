public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int ptr1 = m - 1; 
        int ptr2 = n - 1; 
        int ptr = m + n - 1; 
        
        while (ptr1 >= 0 && ptr2 >= 0) {
            if (A[ptr1] > B[ptr2]) {
                A[ptr] = A[ptr1]; 
                ptr1--; 
                ptr--; 
            } else {
                A[ptr] = B[ptr2]; 
                ptr2--; 
                ptr--; 
            }
        }
        
        while (ptr2 >= 0) {
            A[ptr] = B[ptr2]; 
            ptr--; 
            ptr2--; 
        }
    }
}
