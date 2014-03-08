import java.util.*;

public class Main {
    public static void main(String [] args) {
        Solution sln = new Solution();
        long result = sln.stringToLong("123");

        if (result == 123) {
            System.out.println("Success");
        }
        else {
            System.out.println("Failure");
        }
    }
}
