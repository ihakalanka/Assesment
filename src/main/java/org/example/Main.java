package org.example;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        String[][] available_slots = {{"09:00", "10:00"}, {"11:00", "11:40"},
        {"14:00", "15:00"}, {"16:00", "17:30"}};
        int duration = 60;

        String[] slot = schedule(available_slots, duration);
        if(slot != null){
            System.out.println(slot[0] + ","+ slot[1]);
        }else {
            System.out.println("Null");
        }
    }

    public static String[] schedule(String[][] arrs, int duration){
        for(String[] arr: arrs){
            LocalTime time1 = LocalTime.parse(arr[0]);
            LocalTime time2 = LocalTime.parse(arr[1]);

            long dura = ChronoUnit.MINUTES.between(time1, time2);

            if(dura >= duration){
                return arr;
            }
        }
        return null;
    }
}