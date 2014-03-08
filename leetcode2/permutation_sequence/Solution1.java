public class Solution1 {
    public String getPermutation(int n, int k) {
        char[] arr = new char[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (char)(i + '1');
        }

        while (k > 1) {
            nextPermutation(arr);
            k--;
        }

        return new String(arr);
    }

    private void nextPermutation(char[] arr) {
        int len = arr.length;
        int i = len - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = len - 1;

            while (j > i && arr[j] <= arr[i]) {
                j--;
            }

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        Arrays.sort(arr, i + 1, len);
    }
}
