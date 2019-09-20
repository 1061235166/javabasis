package com.k.jdk;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * jdk1.8的 LocalDate,LocalTime,LocalDateTime
 * @author wyk
 * @date 2019/9/16 20:09
 **/
public class NewDateTime {

	public static void main(String[] args) {
		//只有时分秒
		LocalTime now = LocalTime.now();
		//只有年月日
		LocalDate now1 = LocalDate.now();
		//包含了年月日时分秒
		LocalDateTime now2 = LocalDateTime.now();

    	System.out.println(now);
    	System.out.println(now1);
    	System.out.println(now2);
    	//使用格式化
		String format = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		String format1 = now1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String format2 = now2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(format);
		System.out.println(format1);
		System.out.println(format2);

		Instant instant = Instant.now();
    	System.out.println(instant.toString());

		String s = instant.toString();
    	System.out.println(s);

		String s2 = now2.format(DateTimeFormatter.ISO_LOCAL_DATE);
    	System.out.println(s2);
	}
}
