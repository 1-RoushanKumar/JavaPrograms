package com.roushan._10_OOPS._12_Interface;

public class NiceCar {
    private Engine engine;
    private Music player = new MusicPlayer();

    public NiceCar() {
        engine = new CarEngine();
    }

    public void start() {
        engine.start();
    }

    public void stop() {
        engine.stop();
    }

    public void accelerate() {
        engine.accelerate();
    }

    public void startMusic() {
        player.start();
    }

    public void stopMusic() {
        player.stop();
    }
}
