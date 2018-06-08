package com.epam.classwork.se02.anonymous;

import java.util.Comparator;
import java.util.Date;

public class Example1 {

    private static final Date date = new Date() {

        @Override
        public int getYear() {
            return 2007;
        }
    };

    public static void main(String[] args) {

        class MyDate extends Date {
            public int value = 56;
        }
        MyDate myDate = new MyDate();
        System.out.println(myDate.value);

        Date date = getDate();
        System.out.println(date);
        System.out.println(new Date());

        Comparator<String> comparator = new Comparator<>() {

            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        CharSequence sequence = new CharSequence() {
            @Override
            public int length() {
                return 0;
            }

            @Override
            public char charAt(int index) {
                return 0;
            }

            @Override
            public CharSequence subSequence(int start, int end) {
                return null;
            }
        };

        sequence.charAt(0);

    }

    private static Date getDate() {
        return new Date() {

            public int value = 55;

            public void myMethod() {
                Date another = new Date() {

                    @Override
                    public Object clone() {
                        Date deeper = new Date() {

                        };
                        return null;
                    }
                };
            }

            @Override
            public String toString() {
                return super.toString() + "new version toString method";
            }
        };
    }
}


