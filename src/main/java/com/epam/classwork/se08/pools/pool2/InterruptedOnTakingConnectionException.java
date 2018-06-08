package com.epam.classwork.se08.pools.pool2;

public class InterruptedOnTakingConnectionException extends RuntimeException {

    public InterruptedOnTakingConnectionException(InterruptedException cause) {
        super(cause);
    }
}
