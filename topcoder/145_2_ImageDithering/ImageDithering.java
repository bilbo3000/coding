/**
 * Created by Dongpu on 11/8/14.
 */
public class ImageDithering {
    public int count(String dithered, String[] screen) {
        int cnt = 0;
        boolean [] arr = new boolean[26];

        for (int i = 0; i < dithered.length(); i++) {
            int index = (int) (dithered.charAt(i) - 'A');
            arr[index] = true;
        }

        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[i].length(); j++) {
                int index = (int) (screen[i].charAt(j) - 'A');

                if (arr[index]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
