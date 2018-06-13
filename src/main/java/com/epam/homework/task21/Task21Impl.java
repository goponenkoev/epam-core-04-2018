package com.epam.homework.task21;

import javafx.print.Collation;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Task21Impl implements Task21 {
    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> resList = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {

            String strIn;
            while ((strIn = reader.readLine()) != null){
                resList.add(0,strIn);
            }

            for (String str: resList) {
                writer.write(str);
                writer.newLine();
            }
        }

        Collections.reverse(resList);
        return resList;
    }
}
