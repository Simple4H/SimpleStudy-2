package com.simple.work;

import com.simple.util.Const;
import lombok.extern.slf4j.Slf4j;

/**
 * Create By S I M P L E On 2019/02/15 16:29:24
 */
@Slf4j
public class Light extends Thread {

    String state;

    public void run() {
        while (true) {
            try {
                state = Const.LIGHT.RED;
                log.info("Light现在是红灯");
                Thread.sleep(3000);

                state = Const.LIGHT.YELLOW;
                log.info("Light现在是黄灯");
                Thread.sleep(1000);

                state = Const.TURNLIGHT.RIGHT;
                log.info("Light现在是右拐绿灯");
                Thread.sleep(2000);

                state = Const.TURNLIGHT.PASS;
                log.info("Light现在是直行绿灯");
                Thread.sleep(2000);

                state = Const.TURNLIGHT.LEFT;
                log.info("Light现在是左拐绿灯");
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                log.error("Exception:{}", e);
            }
        }
    }
}
