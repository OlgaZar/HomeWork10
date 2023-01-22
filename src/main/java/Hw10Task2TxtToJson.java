import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hw10Task2TxtToJson {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("file2.txt");
        InputStream fis = new FileInputStream(file);
        Scanner scanner  = new Scanner(fis);
        String f = scanner.nextLine();
        List<Hw10Task2User> listOfHw10Task2User = new ArrayList<>();
        while (scanner.hasNext()) {
            String s= scanner.nextLine();
            String [] words = s.split(" ");
            Hw10Task2User hw10Task2User = new Hw10Task2User(words[0], Integer.parseInt(words[1]));
            listOfHw10Task2User.add(hw10Task2User);
        }


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(listOfHw10Task2User);
        //System.out.println("result = " + result);
        OutputStream fos = new FileOutputStream("user.gson");
        try {
            fos.write(result.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }
