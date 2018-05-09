package com.company;

import dataClasses.DirectDeposit;


import java.io.*;
import java.nio.file.Files;

import javax.crypto.SecretKey;

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
            System.out.println("Serialized data:");
            System.out.println(f); //Serialize
            f.close();

            byte[] b = Files.readAllBytes(new File("testObject.txt").toPath());
            System.out.println("\nByte Array Data:");
            System.out.println(b); //Convert to byte array

            //Setup encrypt
            String xform = "DES/CBC/PKCS5Padding";
            SecretKey finalKey = EncryptDecryptStringWithDES.generateKey();

            //Encrypt
            byte[] encBytes = EncryptDecryptStringWithDES.encrypt(b, finalKey, xform);
            System.out.println("\nEncrypted data:");
            System.out.println(encBytes);

            //Decrypt
            byte[] decBytes = EncryptDecryptStringWithDES.decrypt(encBytes, finalKey, xform);
            System.out.println("\nDecrypted Data:");
            System.out.println(decBytes);

            //Test it worked
            DirectDeposit testInput = (DirectDeposit) deSerialize.DeSerialize(decBytes);
            System.out.println(testInput.getFirstName());

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error Initializing stream");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
