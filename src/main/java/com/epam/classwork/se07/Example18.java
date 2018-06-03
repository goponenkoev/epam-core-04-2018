package com.epam.classwork.se07;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Example18 {

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Runnable operator = new Runnable() {
            @Override
            @SneakyThrows
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    bank.transferAtoB();
                }
            }
        };

        Thread operator1 = new Thread(operator);
        Thread operator2 = new Thread(operator);

        operator1.start();
        operator2.start();

        TimeUnit.MILLISECONDS.sleep(600);
        operator1.stop();

        operator1.join();
        operator2.join();

        System.out.println(bank.getAccountA());
        System.out.println(bank.getAccountB());
    }
}

// accountA + accountB = 100
class Bank {

    private int accountA = 100;
    private int accountB = 0;

    synchronized void transferAtoB() throws InterruptedException {
        --accountA;
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        ++accountB;
    }

    public int getAccountA() {
        return accountA;
    }

    public int getAccountB() {
        return accountB;
    }
}