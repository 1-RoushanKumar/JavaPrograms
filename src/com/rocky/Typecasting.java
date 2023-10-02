package com.rocky;

public class Typecasting {
    public static void main(String[] args) {
//        int num = 67.56; //show error bcoz i assignning float value in integer datatype.
        //type casting
        int num = (int) (67.56);
        System.out.println(num); //output 67

        //automatic type promotion
        int a = 257;
        byte b = (byte) (a);
        //output will 1 because byte range from (0to255)
        //and here b = 257 so it will give b = 257%256 = 1
        System.out.println(b);

        int number = 'A';
        System.out.println(number);

        //java is unicode.
        System.out.println("रौशन कुमार");
        System.out.println("ロウシャン・クマール");
    }
}
