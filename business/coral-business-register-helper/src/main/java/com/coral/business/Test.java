package com.coral.business;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String argus[]){

        String day1="20200413";
        String day2="20210101";
        caculateDay(day1,day2);

    }

    static void caculateDay(String day1,String day2){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dayTemp=day1;
        try{
            String dayEnd=simpleDateFormat.format(simpleDateFormat.parse(day2).getTime() + 3600*24*1000);
            while(!dayTemp.equals(dayEnd)){
                System.out.println(dayTemp);
                dayTemp=simpleDateFormat.format(simpleDateFormat.parse(dayTemp).getTime() + 3600*24*1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
