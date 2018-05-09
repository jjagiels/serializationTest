package com.company;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializationClass {
    public static byte[] serialization(Object object) throws IOException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out;
        byte[] sObject;
        try{
            out = new ObjectOutputStream(bos);
            out.writeObject(object);
            out.flush();
            sObject = bos.toByteArray();
            bos.close();
        }finally{
            bos.close();
        }
        return sObject;
    }
}
