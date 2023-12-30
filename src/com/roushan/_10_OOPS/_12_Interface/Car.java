package com.roushan._10_OOPS._12_Interface;

public class Car implements Engine, Brake, Music {
    @Override
    public void brake() {
        System.out.println("Stopping the car by brake!");
    }

    @Override
    public void start() {
        System.out.println("Starting the car!");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the car!");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating the car!");
    }

}
