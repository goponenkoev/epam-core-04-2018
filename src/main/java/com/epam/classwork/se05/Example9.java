package com.epam.classwork.se05;

import java.io.IOException;

public class Example9 {

    public static void main(String[] args) throws Exception {
        D d = new D();
    }
}


class C {

    public C() throws IOException {
    }

    public void method() throws Exception {

    }
}

class D extends C {

    public D() throws Exception {

    }

    @Override
    public void method() {
        System.out.println("123");
    }
}