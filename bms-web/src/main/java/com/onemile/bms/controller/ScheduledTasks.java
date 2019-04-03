package com.onemile.bms.controller;

import com.onemile.bms.controller.device.DeviceInfoController;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ericma
 */
@Component
@Configurable
@EnableScheduling
public class ScheduledTasks{

//    @Scheduled(fixedRate = 1000 * 30)
//    public void reportCurrentTime(){
//        System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date()));
//    }


    /**
     * 定时处理设备状态
     */
    @Scheduled(cron = "0 */59 *  * * * ")
    public void reportCurrentByCron(){

        //更新
        DeviceInfoController  deviceInfoController=new DeviceInfoController();
        deviceInfoController.updateDeviceInfoOnline();


        System.out.println ("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date ()));
    }

    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("HH:mm:ss");
    }

}