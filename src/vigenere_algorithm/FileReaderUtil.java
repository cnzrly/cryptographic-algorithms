package vigenere_algorithm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class FileReaderUtil {
    final static String filePath  = "src/vigenere_algorithm/PlainText.txt";
    public static String readFile() throws IOException {
        return Files.readString(Path.of(filePath))
                .replaceAll("\\r\\n", "\n") // normalize line endings
                .trim();
    }
    }

