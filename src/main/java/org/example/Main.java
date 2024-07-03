package org.example;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile("  src/main/resources/books.csv  ");

        //GOOD PATH
        //ReadFile readFile = new ReadFile("src/main/resources/books.csv")
        String file = readFile.readFileLineByLine();

        System.out.println(file);
    }
}