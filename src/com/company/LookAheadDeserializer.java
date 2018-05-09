package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

import dataClasses.BasicInfo;
import dataClasses.DirectDeposit;

public class LookAheadDeserializer extends ObjectInputStream {
    public LookAheadDeserializer(InputStream in) throws IOException {
        super(in);
    }

    /**
     * Only deserialize instances of our expected form classes
     */
    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException{
        if(    !((desc.getName().equals(DirectDeposit.class.getName())) ||
                (desc.getName().equals(BasicInfo.class.getName())))  ){
            throw new InvalidClassException("Unauthorized deserialization attempt", desc.getName());
        }
        return super.resolveClass(desc);
    }
}
