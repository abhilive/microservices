package com.abhilive.hotel.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

    public boolean doesStringContainVisibleCharacters(String input) {
        // Java 11 introduced a special String's method that could replace the expression below
        return !input.trim().isEmpty();
        // return !input.trim().equals("");
    }

    public List<String> splitToLines(String input) {
        // Java 11 introduced a special String's method that could replace the expression below
        // String[] lines = input.split("\n");
        return input.lines().collect(Collectors.toList());
    }

    public String trimUnicodeString(String input) {
        // Java 11 introduced a special String's method that could replace the expression below
        // Note: The final implementation should operate on wider spectrum of whitespace characters than trim method
        return input.strip();
        // return input.trim();
    }

    public String trimLeft(String input) {
        // Java 11 introduced a special String's method that could replace the expression below
        // return input.replaceAll("^\\s*", "");
        return input.stripLeading();
    }

    public String trimRight(String input) {
        // Java 11 introduced a special String's method that could replace the expression below
        // return input.replaceAll("\\s*$", "");
        return input.stripTrailing();
    }

    public String repeatStringFiveTimes(String input) {
        // Java 11 introduced a special String's method that could replace the expression below
        StringBuilder sb = new StringBuilder();
        /* for (int i = 0; i < 5; i++) {
            sb.append(input);
        }
        return sb.toString(); */
        return input.repeat(5);
    }

    public void saveStringInFile(String fileContents, String filename) throws Exception {
        Path file = Paths.get(filename);
        // Please implement the rest of this method using one of the methods of the Files class
        // The function should write the given string to the file with the given name
        Files.writeString(file, fileContents);
    }

    public String readFileContents(String filename) throws Exception {
        Path file = Paths.get(filename);
        // Please implement the rest of this method using one of the methods of the Files class
        // The function should read the contents of the file and return it as a single String value
        return Files.readString(file);
    }

    public List<String> filterOutEmptyStrings(List<String> input) {
        // Java 11 introduces new type of Predicate - please use it here
        return input.stream().filter(Predicate.not(String::isEmpty)).collect(Collectors.toList());
        /* return input.stream()
                 .filter(s -> !"".equals(s))
                 .collect(Collectors.toList());*/
    }
}
