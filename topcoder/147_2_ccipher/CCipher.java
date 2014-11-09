public class CCipher {
    public String decode(String cipherText, int shift) {
        shift = shift % 26;
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < cipherText.length(); i++) {
            char c = (char)((int)cipherText.charAt(i) - shift);

            if (c < 'A') {
                int remain = shift - (int) (cipherText.charAt(i) - 'A');
                c = (char) ('Z' - remain + 1);
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
