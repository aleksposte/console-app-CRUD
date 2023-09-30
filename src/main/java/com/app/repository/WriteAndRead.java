package com.app.repository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class WriteAndRead {

    public static void WriteToFile(String data, File filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error write: " + e.getMessage());
//            e.printStackTrace();
        }
    }

    public static ArrayList<String> ReadFromFile(File filename) throws FileNotFoundException {
        ArrayList<String> myList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null)
            {
                myList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error read: "  + e.getMessage());
        }
        return myList;
    }
}
