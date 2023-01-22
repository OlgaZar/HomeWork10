import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hw10Task1PhoneNumberList {
     public static void main(String[] args) throws FileNotFoundException {
          File file = new File("file.txt");
          InputStream fis = new FileInputStream(file);
          Scanner scanner = new Scanner(fis);
          Pattern pattern1 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
          Pattern pattern2 = Pattern.compile("\\(\\d{3}\\)\\s\\d{3}-\\d{4}");

          while (scanner.hasNext()) {
               String s = scanner.nextLine();
               Matcher matcher1 = pattern1.matcher(s);
               Matcher matcher2 = pattern2.matcher(s);
               if (matcher1.matches() || matcher2.matches()) {
                    System.out.println(s);
               }
          }
     }
}

