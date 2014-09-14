public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len1 = A.length;
        int len2 = B.length;

        if ((len1 + len2) % 2 == 0) {
            int k = (len1 + len2) / 2;
            return (findKthSmallest(A, 0, len1 - 1, B, 0, len2 - 1, k) + findKthSmallest(A, 0, len1 - 1, B, 0, len2 - 1, k + 1)) / 2.0;
        } else {
            int k = (len1 + len2 + 1) / 2;
            return findKthSmallest(A, 0, len1 - 1, B, 0, len2 - 1, k) * 1.0;
        }
    }

    public int findKthSmallest(int A[], int l1, int r1, int B[], int l2, int r2, int k) {
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;

        if (len1 == 0) {
            return B[l2 + k - 1];
        }

        if (len2 == 0) {
            return A[l1 + k - 1];
        }

        if (k == 1) {
            return A[l1] < B[l2] ? A[l1] : B[l2];
        }

        int k1 = k / 2;
        int k2 = k - k1;

        if (k2 > len2) {
            k2 = len2;
            k1 = k - k2;
        } else if (k1 > len1) {
            k1 = len1;
            k2 = k - k1;
        }

        if (A[l1 + k1 - 1] > B[l2 + k2 - 1]) {
            return findKthSmallest(A, l1, r1, B, l2 + k2, r2, k - k2);
        } else if (A[l1 + k1 - 1] < B[l2 + k2 - 1]) {
            return findKthSmallest(A, l1 + k1, r1, B, l2, r2, k - k1);
        } else {
            return A[l1 + k1 - 1];
        }
    }
}
