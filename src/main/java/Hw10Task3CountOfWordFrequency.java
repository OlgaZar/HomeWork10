import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class Hw10Task3CountOfWordFrequency {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("word.txt");
        InputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);

        Map<String, Integer> map = new HashMap<>();


        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] words = s.split(" ");
            for (String word : words) {
                if (!word.equals("")) {
                    if (!map.containsKey(word)) {
                        map.put(word, 1);
                    } else {
                        map.put(word, map.get(word) + 1);
                    }
                }
            }
        }
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1)<map.get(o2)? 1 : -1;
            }
        };
        Map <String, Integer> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map);
        System.out.println("sortedMap = " + sortedMap);
    }
}
