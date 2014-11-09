public class FormatAmt {
    public String amount(int dollars, int cents) {
        String result = "";

        if (dollars < 1) {
            result = "$0.";
        }else {
            while (dollars > 0) {
                int temp = dollars % 1000;
                String tempStr = String.valueOf(temp);

                if (temp == 0) {
                    tempStr = "000";
                }

                dollars /= 1000;
                if (result.isEmpty()) {
                    result = tempStr;
                } else {
                    result = tempStr + "," + result;
                }
            }

            result = "$" + result + ".";
        }

        if (cents >= 10) {
            result += String.valueOf(cents);
        } else {
            result += "0" + String.valueOf(cents);
        }

        return result;
    }
}
