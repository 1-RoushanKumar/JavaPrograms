package com.roushan._10_OOPS._12_Interface;

public class Main {
    public static void main(String[] args) {
//        Car carr = new Car();
//        carr.start();
//        carr.accelerate();
//        carr.brake();
//        carr.stop();

        //but there is a one problem, when we implement Music
        //calling we want to start music by calling start but
        //it,s starting the car.Because already there is one method
        //with name start and stop in Engine interface, so we are not able to
        //make other method with same method.Similarly, vice versa when music
        //is defined then Engine will become a problem.
//        Music carMedia = new Car();
//        carMedia.stop();// when i try to stop a music it's stopping car.

        //So get rid of these problem we implement each interface to class and created NiceCar class
        //where we created constructor of all then accessing it.

        NiceCar newCar = new NiceCar();
        newCar.start();
        newCar.stop();
        newCar.accelerate();
        newCar.startMusic();
        newCar.stopMusic();
    }
}
