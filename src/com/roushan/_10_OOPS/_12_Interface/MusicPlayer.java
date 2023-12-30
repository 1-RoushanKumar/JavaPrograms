package com.roushan._10_OOPS._12_Interface;

public class MusicPlayer implements Music {

    @Override
    public void start() {
        System.out.println("Music Start");
    }

    @Override
    public void stop() {
        System.out.println("Music Stop");
    }
}
