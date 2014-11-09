public class PeopleCircle {
    public String order(int numMales, int numFemales, int K) {
        String result = "";
        int len = numFemales + numMales;
        char[] arr = new char[len];
        int curr = 0;

        for (int i = 0; i < numFemales; i++) {
            int pos = (curr + K - 1) % len;
            arr[pos] = 'F';
            curr = (curr + K) % len;
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] != 'F') {
                arr[i] = 'M';
            }
        }

        result = String.valueOf(arr);

        return result;
    }
}
