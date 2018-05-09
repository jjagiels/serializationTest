// File: src\jsbook\ch3\SymmetricCipherTest.java
package com.company;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;

public class EncryptDecryptStringWithDES {
  private static byte[] iv =
      { 0x0a, 0x01, 0x02, 0x03, 0x04, 0x0b, 0x0c, 0x0d };

  public static byte[] encrypt(byte[] inpBytes,SecretKey key, String xform) throws Exception {
    Cipher cipher = Cipher.getInstance(xform);
    IvParameterSpec ips = new IvParameterSpec(iv);
    cipher.init(Cipher.ENCRYPT_MODE, key, ips);
    return cipher.doFinal(inpBytes);
  }

  public static byte[] decrypt(byte[] inpBytes, SecretKey key, String xform) throws Exception {
    Cipher cipher = Cipher.getInstance(xform);
    IvParameterSpec ips = new IvParameterSpec(iv);
    cipher.init(Cipher.DECRYPT_MODE, key, ips);
    return cipher.doFinal(inpBytes);
  }
  public static SecretKey generateKey() throws Exception{
      // Generate a secret key
      KeyGenerator kg = KeyGenerator.getInstance("DES");
      kg.init(56); // 56 is the keysize. Fixed for DES
      SecretKey key = kg.generateKey();
      System.out.println("\nKey:");
      System.out.println(key);

      return key;
  }

}