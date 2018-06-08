package com.epam.classwork.se06;

import lombok.Getter;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class Example5 {

    public static void main(String[] args) throws InterruptedException {
        MyClass strongReference = new MyClass();
//        PhantomReference phantomReference = new PhantomReference()

        ReferenceQueue<MyClass> queue = new ReferenceQueue<>();
        SoftReference<MyClass> softReference = new MySoftRefernce<>(strongReference, queue, 0);

        strongReference = null;

        System.gc();

        MySoftRefernce<? extends MyClass> removed1 = (MySoftRefernce<? extends MyClass>) queue.remove();
        System.out.println(removed1.getId());
    }

}

@Getter
class MySoftRefernce<T> extends SoftReference<T> {

    private final int id;

    public MySoftRefernce(T referent, int id) {
        super(referent);
        this.id = id;
    }

    public MySoftRefernce(T referent, ReferenceQueue<? super T> q, int id) {
        super(referent, q);
        this.id = id;
    }
}

class MyClass {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
