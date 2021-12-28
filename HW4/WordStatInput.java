import java.util.*;
import java.io.*;

public class WordStatInput {
    public static void main(String[] args) {
        Map<String, Integer> wordsCount = new LinkedHashMap<>();
        StringBuilder str = new StringBuilder();

        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "utf-8"));
            while (true) {
                String line = buf.readLine();
                if (line == null) {
                    break;
                }

                int size = line.length();
                for (int i = 0; i < size; i++) {
                    char cur = line.charAt(i);
                    boolean letterCheck = (Character.getType(cur) == Character.DASH_PUNCTUATION
                            || Character.isLetter(cur) || cur == '\'');

                    if (i != size - 1 && letterCheck) {
                        str.append(cur);
                    } else if (str.length() != 0) {
                        if (i == size - 1 && letterCheck) {
                            str.append(cur);
                        }
                        String word = str.toString().toLowerCase();

                        if (!wordsCount.containsKey(word)) {
                            wordsCount.put(word, 1);
                        } else {
                            wordsCount.put(word, wordsCount.get(word) + 1);
                        }
                        str.delete(0, str.length());
                    }
                }
            }
            buf.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            OutputStreamWriter cout = new OutputStreamWriter(new FileOutputStream(args[1]), "utf-8");
            try {
                for (Map.Entry word : wordsCount.entrySet()) {
                    cout.write(word.getKey() + " " + word.getValue() + "\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                cout.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}