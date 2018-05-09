package com.company;

import dataClasses.DirectDeposit;

import java.io.*;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) {
        DirectDeposit testClass = new DirectDeposit();

        testClass.setFirstName("Justin");
        testClass.setMiddleName("Richard");
        testClass.setLastName("Jagielski");

        testClass.setAddress("123 Foo St.");
        testClass.setCity("Somewhere");
        testClass.setState("Delaware");
        testClass.setZipCode("12345");

        testClass.setCheckOrSaving(true);
        testClass.setSaveAcct("123456789");
        testClass.setRoutNum("987654321");

        try {
            FileOutputStream f = new FileOutputStream(new File("testObject.txt"));
            f.write(SerializationClass.serialization(testClass));

            f.close();

            byte[] b = Files.readAllBytes(new File("testObject.txt").toPath());

            Object testInput =  deSerialize.DeSerialize(b);

            String inputName = testInput.getClass().getSimpleName().toLowerCase();

            System.out.println(inputName);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error Initializing stream");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
