public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if ((m + n) % 2 != 0) {
            return findKth(A, B, 0, 0, (m + n - 1) / 2 + 1);
        }
        else {
            return (findKth(A, B, 0, 0, (m + n - 1) / 2 + 1) + findKth(A, B, 0, 0, (m + n - 1) / 2 + 2)) / 2.0;
        }
    }

    private int findKth(int A[], int B[], int i, int j, int k) {
        int m = A.length;
        int n = B.length;

        if (m == i) {
            return B[j + k - 1];
        }

        if (n == j) {
            return A[i + k - 1];
        }

        if (k == 1) {
            return A[i] < B[j] ? A[i] : B[j];
        }

        int index1;
        int index2;

        if (k / 2 + i <= m && k / 2 + j <= n) {
            index1 = k / 2 - 1 + i;
            index2 = k / 2 - 1 + j;
        }
        else {
            if (k / 2 + i > m) {
                index1 = m - 1;
                index2 = j + (k - m + i) - 1;
            }
            else {
                index1 = i + (k - n + j) - 1;
                index2 = n - 1;
            }
        }
        
        if (A[index1] > B[index2]) {
            return findKth(A, B, i, index2 + 1, k - (index2 - j + 1));
        }
        else {
            return findKth(A, B, index1 + 1, j, k - (index1 - i + 1));
        }
    }
}