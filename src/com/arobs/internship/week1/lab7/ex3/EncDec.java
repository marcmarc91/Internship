package com.arobs.internship.week1.lab7.ex3;

import java.io.*;
import java.util.ArrayList;

public class EncDec {

    public void encrypt(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName + ".dec");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            ArrayList<String> textDec = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                textDec.add(line);
            }
            reader.close();
            if (textDec.size() > 0) {
                FileOutputStream fileOutputStream = new FileOutputStream(fileName + ".enc");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                BufferedWriter writer = new BufferedWriter(outputStreamWriter);
                for (String lineEnc : textDec) {
                    StringBuilder newLine = new StringBuilder();
                    for (int i = 0; i < lineEnc.length(); i++) {
                        int n = ((int) lineEnc.charAt(i)) - 1;
                        newLine.append((char) n);
                    }
                    writer.write(newLine.toString() + System.lineSeparator());
                }
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decrypt(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName + ".enc");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            ArrayList<String> textDec = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                textDec.add(line);
            }
            reader.close();
            if (textDec.size() > 0) {
                FileOutputStream fileOutputStream = new FileOutputStream(fileName + ".dec");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                BufferedWriter writer = new BufferedWriter(outputStreamWriter);
                for (String lineEnc : textDec) {
                    StringBuilder newLine = new StringBuilder();
                    for (int i = 0; i < lineEnc.length(); i++) {
                        int n = ((int) lineEnc.charAt(i)) + 1;
                        newLine.append((char) n);
                    }
                    writer.write(newLine.toString() + System.lineSeparator());
                }
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
