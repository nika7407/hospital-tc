package com.solvd.hospitaltc.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TextBookUtil {

    public static void CountUniqueWords(File book) throws IOException {
        if (!book.canRead() || !book.exists()) {
            System.out.println("dont exists or cannot be read");
        }
        String bookName = book.getName();

        String stringOfBook = FileUtils.readFileToString(book, Charset.defaultCharset());

        String stripped = StringUtils.strip(stringOfBook)
                .toLowerCase()
                .replaceAll("[^a-zA-Z0-9\\s]", " ")
                .replaceAll("\\s+", " ")
                .trim();

        String[] wordsArray = stripped.split(" ");
        Set<String> uniqueWords = new HashSet<>(List.of(wordsArray));
        File file = new File("src/main/resources/bookReport For '" + bookName +"' .txt");
        FileUtils.write(file, "\nThe book name: " + bookName + "\n The amount of unique Words:" + uniqueWords.size());
        System.out.println("\nthe amount of unique words counted for " + bookName);
    }
}
