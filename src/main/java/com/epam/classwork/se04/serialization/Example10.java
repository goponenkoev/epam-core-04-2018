package com.epam.classwork.se04.serialization;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.*;

public class Example10 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Mask mask = new Mask((byte) 0, (byte) 1, (byte) 2, (byte) 3);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(out);
        objectOut.writeObject(mask);

        byte[] bytes = out.toByteArray();
        System.out.println(bytes.length);
        System.out.println(new String(bytes));

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream objectIn = new ObjectInputStream(in);
        Mask anotherRef = (Mask) objectIn.readObject();

        System.out.println(mask.equals(anotherRef));
    }
}

@EqualsAndHashCode
class Mask implements Externalizable {

    transient private Byte _1;
    private Byte _2;
    private Byte _3;
    private Byte _4;

    public Mask() {
        System.out.println("NoArgsConstructor called");
    }

    public Mask(Byte _1, Byte _2, Byte _3, Byte _4) {
        System.out.println("AllArgsConstructor called");
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeByte(_1);
        out.writeByte(_2);
        out.writeByte(_3);
        out.writeByte(_4);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        _1 = in.readByte();
        _2 = in.readByte();
        _3 = in.readByte();
        _4 = in.readByte();
    }
}