public class Solution {
    public int firstMissingPositive(int[] A) {
        int len = A.length;
        int i = 0;

        while (i < len) {
            if (A[i] > 0 && A[i] <= len && A[i] != i + 1 && A[i] != A[A[i] - 1]) {
                int temp =A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
                i--;
            }

            i++;
        }

        for (int j = 0; j < len; j++) {
            if (A[j] != j + 1) {
                return j + 1;
            }
        }

        return len + 1;
    }
}
