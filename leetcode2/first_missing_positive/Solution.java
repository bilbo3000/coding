public class Solution {
    public int firstMissingPositive(int[] A) {
        int len = A.length;

        int missing = len + 1;

        for (int i = len - 1; i >= 0; i--) {
            if (A[i] <= 0) {
                missing = i + 1;
            }
            else {
                if (A[i] != i + 1) { // Misplace
                    if (A[i] >= 0 && A[i] < len && A[i] != A[A[i] - 1]){
                        swap(A, i, A[i] - 1);
                        i++;
                    }
                    else {
                        missing = i + 1;
                    }
                }
            }
        }

        return missing;
    }

    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
