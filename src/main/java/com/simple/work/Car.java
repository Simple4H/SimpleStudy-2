package com.simple.work;

import com.simple.util.Const;
import lombok.extern.slf4j.Slf4j;

/**
 * Create By S I M P L E On 2019/02/15 16:38:45
 */
@Slf4j
public class Car extends Thread {

    private Light light;

    private String carName;

    private int isPressureLine;

    // 0 右拐 1直行 2左拐
    private int turnDirection;

    public Car(Light light, String carName, int isPressureLine, int turnDirection) {
        this.light = light;
        this.carName = carName;
        this.isPressureLine = isPressureLine;
        this.turnDirection = turnDirection;
    }

    public void run() {
        if (light.state.equals(Const.LIGHT.RED)) {
            if (turnDirection == 0) {
                log.info("Car:{}红灯右拐通行", carName);
            } else if (turnDirection == 1) {
                log.info("Car:{}红灯直行停", carName);
            } else if (turnDirection == 2) {
                log.info("Car:{}红灯左拐停", carName);
            }
        } else if (light.state.equals(Const.LIGHT.YELLOW)) {
            if (isPressureLine == 0) {
                log.info("Car:{}黄灯压线通行", carName);
            } else if (isPressureLine == 1) {
                log.info("Car:{}黄灯停", carName);
            }
        } else if (light.state.equals(Const.TURNLIGHT.RIGHT)) {
            log.info("Car:{}绿灯右拐", carName);
        } else if (light.state.equals(Const.TURNLIGHT.PASS)) {
            log.info("Car:{}绿灯直行", carName);
        } else if (light.state.equals(Const.TURNLIGHT.LEFT)) {
            log.info("Car:{}绿灯左拐", carName);
        }
    }
}
