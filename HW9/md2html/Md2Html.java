package md2html;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Md2Html {
    public static void main(String[] args) {
        StringBuilder processed = new StringBuilder();
        try {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]),
                            StandardCharsets.UTF_8
                    )
            )) {
                String curIn;
                StringBuilder paragraph = new StringBuilder();
                while ((curIn = in.readLine()) != null) {
                    while (curIn != null && !curIn.equals("")) {
                        paragraph.append(curIn).append('\n');
                        curIn = in.readLine();
                    }
                    if (paragraph.length() != 0) {
                        paragraph.setLength(paragraph.length() - 1);
                        new ParseBlocks(paragraph).toHtml(processed);
                        processed.append('\n');
                        paragraph.setLength(0);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Write error: " + e.getMessage());
        }
        try {
            try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]),
                            StandardCharsets.UTF_8)
            )) {
                out.write(processed.toString());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Output file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Write error: " + e.getMessage());
        }
    }
}