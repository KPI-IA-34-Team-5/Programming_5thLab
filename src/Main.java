import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\user\\Desktop\\кпи\\1 курс\\2 семестр\\програмування лаби\\lab5\\io-rarest-word\\src\\file.txt";
        String rarestWord = rarestWord(filePath);
        System.out.println("rarest ford in file: "  + rarestWord);
    }

    public static String rarestWord(String filePath) throws IOException {
        Map<String, Integer> wordOccurrences = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+|\\p{Punct}");
                for (String word : words) {
                    if (!word.isEmpty() && Character.isLetter(word.charAt(0))) {
                        wordOccurrences.put(word, wordOccurrences.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        Map.Entry<String, Integer> total = Collections.min(wordOccurrences.entrySet(), Map.Entry.comparingByValue());

        return total.getKey();
    }
}
