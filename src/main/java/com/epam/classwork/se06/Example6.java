package com.epam.classwork.se06;

import lombok.Getter;
import lombok.Value;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class Example6 {

    public static void main(String[] args) throws InterruptedException {
        int id = 10;
        User strongReference = new User(id);
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<User> phantomReference = new UserPhantomReference(strongReference, queue, id, strongReference.getBytes());

        System.out.println(phantomReference.get());

        strongReference = null;

        System.gc();

        Reference<?> preparedToRemove = queue.remove();
        UserPhantomReference preparedToRemove1 = (UserPhantomReference) preparedToRemove;
        System.out.println(preparedToRemove1.getId());
        preparedToRemove.clear();
    }
}

@Value
class User {
    int id;
    byte[] bytes = new byte[10_000_000];
}

@Getter
class UserPhantomReference extends PhantomReference<User> {

    private int id;
    private WeakReference<byte[]> bytes;

    public UserPhantomReference(User referent, ReferenceQueue<? super User> q, int id, byte[] bytes) {
        super(referent, q);
        this.id = id;
        this.bytes = new WeakReference<>(bytes);
    }

    @Override
    public void clear() {
        bytes = null;
        super.clear();
    }
}
