import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LeapYear {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter a year: ");
        String input = reader.readLine();
        int year = Integer.parseInt(input);

        // Leap year logic: Divisible by 4, but not 100 - unless it is divisible by 400
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is a leap year!");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }
}
