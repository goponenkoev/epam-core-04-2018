package com.epam.classwork.se02;

public class Mathematica {

    public Mathematica(Num obj){}               // 1
    public Mathematica(Int obj){}               // 2
//    public Mathematica(Num obj1, Int obj2){}    // 3
//    public Mathematica(Int obj1, Int obj2) {} // 4
//    public Mathematica(Int val, Num num) {}     //5

    public static void main(String[] args){
        Num o1 = new Num();
        Int o2 = new Int();
        LongInt o3 = new LongInt();
        Num o4 = new Int();



        Mathematica m1 = new Mathematica(o1);
        Mathematica m2 = new Mathematica(o2);
        Mathematica m3 = new Mathematica(o3);
        Mathematica m4 = new Mathematica(o4);
//        Mathematica m5 = new Mathematica(o1, o2);
//        Mathematica m6 = new Mathematica(o3, o2);
//        Mathematica m7 = new Mathematica(o1, (Int) o4);
//        Mathematica m8 = new Mathematica(o3, o4);
//        Mathematica m9 = new Mathematica(o2, o2);
    }

}

class Num {}
class Int extends Num {}
class LongInt extends Int {}

