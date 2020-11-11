package com.k.java基础;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * Created by k on 2020/2/1.
 */
public class TryCatchFinally {


    public static void main(String[] args) {
        int cal = cal();
        System.out.println(cal);
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()){
            System.out.println(drivers.nextElement());
        }
//        DriverManager.getDriver("");
    }

    public static int cal(){
        int i ;
        try {
            i=1;
            if(true){
                throw new RuntimeException();
            }
            return i;
        }catch (Exception e){
            i=2;
            return i;
        }finally {
            i=3;
        }
    }

}
