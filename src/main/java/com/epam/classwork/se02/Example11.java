package com.epam.classwork.se02;

import java.util.Objects;

public class Example11 {

    public static void main(String[] args) {
        X x = new X();
        Number num = x.getNum();


        X t = new T();
        Number num1 = t.getNum();


        T tObject = new T();
        tObject.setField(1);
        tObject.setField(2);
        tObject.setField(3);

    }

}

class X {

    private int privateField;
    private String val = "123";

    public Number getNum() {
        return 42;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        X x = (X) o;
        return privateField == x.privateField &&
                Objects.equals(val, x.val);
    }

    @Override
    public int hashCode() {

        return Objects.hash(privateField, val);
    }
}

final class T extends X {

    private int field;

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    @Override
    public Double getNum() {
        return 56.5;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        T t = (T) o;

        return field == t.field;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + field;
        return result;
    }
}
