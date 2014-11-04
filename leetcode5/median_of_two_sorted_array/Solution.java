public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if (m == 0 && n == 0) {
            return 0.0;
        }

        if (m == 0) {
            if (n % 2 == 0) {
                return (B[n / 2 - 1] + B[n / 2]) / 2.0;
            } else {
                return (double) B[n / 2];
            }
        }

        if (n == 0) {
            if (m % 2 == 0) {
                return (A[m / 2 - 1] + A[m / 2]) / 2.0;
            } else {
                return (double) A[m / 2];
            }
        }

        if ((m + n) % 2 == 0) {
            return (findKth(A, B, 0, 0, (m + n) / 2) + findKth(A, B, 0, 0, (m + n) / 2 + 1)) / 2.0;
        } else {
            return findKth(A, B, 0, 0, (m + n + 1) / 2);
        }
    }

    private int findKth(int A[], int B[], int i, int j, int k) {
        // System.out.println("i: " + String.valueOf(i) + "; j: " + String.valueOf(j) + "; k: " + String.valueOf(k));

        if (i >= A.length) {
            return B[k - 1];
        }

        if (j >= B.length) {
            return A[k - 1];
        }

        if (k == 1) {
            return A[i] < B[j] ? A[i] : B[j];
        }

        int l = k / 2;
        int r = k - l;

        if (A.length - i < l) {
            l = A.length - i;
            r = k - l;
        } else if (B.length - j < r) {
            r = B.length - j;
            l = k - r;
        }

        if (A[i + l - 1] == B[j + r - 1]) {
            return A[i + l - 1];
        } else if (A[i + l - 1] > B[j + r - 1]) {
            return findKth(A, B, i, j + r, k - r);
        } else {
            return findKth(A, B, i + l, j, k - l);
        }
    }
}
