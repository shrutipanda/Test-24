package test;

import java.util.*;

class Task1 extends TimerTask {


    int count = 1;

    // run is a abstract method that defines task performed at scheduled time.
    public void run() {
        System.out.println(count+" : Shruti_Sravani");
        count++;
    }
}

class TaskScheduling {

   public static void main(String[] args) {
       Timer timer = new Timer();


       // Schedule to run after every 3 second(3000 millisecond)
       timer.schedule( new Task1(),0,2000);   
   }
}