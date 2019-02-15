package com.simple.work;

import lombok.extern.slf4j.Slf4j;

/**
 * Create By S I M P L E On 2019/02/15 16:55:50
 */
@Slf4j
public class Test extends Thread {

    public static void main(String[] args) throws InterruptedException {
        Light light = new Light();
        light.start();
        for (int i = 0; i < 2000; i++) {
            Car car = new Car(light, "i" + i, (int) (Math.random() * 2), (int) (Math.random() * 3));
            Thread.sleep(100);
            car.start();
        }
    }
}
