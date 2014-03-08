public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len1 = A.length;
        int len2 = B.length;
        int len = len1 + len2;

        if (len % 2 != 0) {  // Odd number
            return helper(A, B, 0, 0, len / 2 + 1);
        }
        else {
             return (helper(A, B, 0, 0, len / 2) + helper(A, B, 0, 0, len / 2 + 1)) / 2;
        }
    }

    private double helper(int A[], int B[], int i, int j, int k) {
        if (i == A.length) return B[j + k - 1];
        if (j == B.length) return A[i + k - 1];
        if (k == 1) {
            return Math.min(A[i], B[j]);
        }

        int len1 = A.length - i;
        int len2 = B.length - j;
        int cutlen = k / 2;

        if (cutlen <= len1 && cutlen <= len2) {
            if (A[i + cutlen - 1] == B[j + cutlen - 1]) {
                if (k % 2 != 0) {
                    return helper(A, B, i + cutlen, j + cutlen, 1);
                }
                else {
                    return A[i + cutlen - 1];
                }
            }
            else if (A[i + cutlen - 1] > B[j + cutlen - 1]) {  // Remove first part of B
                return helper(A, B, i, j + cutlen, k - cutlen);
            }
            else {  // Remove first part of A
                return helper(A, B, i + cutlen, j, k - cutlen);
            }
        }
        else {
            if (len1 < cutlen) {  // A is shorter
                if (A[len1 - 1] == B[k - len1 - 1]) {
                    return A[len1 - 1];
                }
                else if (A[len1 - 1] > B[k - len1 - 1]) {
                    return helper(A, B, i, j + len1, k - len1);
                }
                else {
                    return helper(A, B, i + len1, j, k - len1);
                }
            }
            else {  // B is shorter
                if (A[k - len2 - 1] == B[len2 - 1]) {
                    return B[len2 - 1];
                }
                else if (A[k - len2 - 1] > B[len2 - 1]){
                    return helper(A, B, i, j + len2, k - len2);
                }
                else {
                    return helper(A, B, i + len2, j, k - len2);
                }
            }
        }
    }
}
