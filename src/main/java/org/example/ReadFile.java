package org.example;

import org.example.exceptions.EmptyFileException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;

public class ReadFile {

    private Path path;

    public ReadFile(String path) {
        validateFilePath(path);
    }

    //Why does not the invalid path is not caught? It seems that it is caught when reading the line
    private void validateFilePath(String path) {
        try {
            this.path = Paths.get(path);

        } catch (InvalidPathException e) {
            System.out.println("Invalid path " + e.getMessage());
        }

    }

    public String readFileLineByLine() {
        StringBuilder content = null;

        try {
            BufferedReader br = Files.newBufferedReader(this.path);

            content = new StringBuilder();
            String line;

            if ((br.readLine()) == null) {
                throw new EmptyFileException("This file is empty");
            } else {
                while ((line = br.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }



            return content.toString();

        } catch (NoSuchFileException e) {
//            System.out.println("File not found " + e.getMessage());
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to read file: " + e.getMessage());
        }

        return content.toString();
    }
}
