package work;

import java.util.Calendar;
import java.util.Date;

public class DateRelated {


    /**
     * 使用jdk的java.util.Date获取一个月的最后一天
     * 可以动态判断每个月的最后一天
     * 衍生：
     * 1.详细了解Date相关api，除了平常用到的，还有些不常用但是很有用的
     * 2.需要了解jdk8新增的LocalDatetime和LocalDate相关api
     * 3.需要了解jodaTime的时间相关api
     */
    public static void getLastDayOfMonthToJdkDate(){

        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        /**
         * 一个月最大一天
         */
        int lastDay = instance.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println(lastDay);
        /**
         * 一个月最小一天
         */
        int actualMinimum = instance.getActualMinimum(Calendar.DAY_OF_MONTH);
        System.out.println(actualMinimum);

        int firstDayOfWeek = instance.getFirstDayOfWeek();

        int minimalDaysInFirstWeek = instance.getMinimalDaysInFirstWeek();
        System.out.println(minimalDaysInFirstWeek);

        System.out.println(firstDayOfWeek);

        /**
         * 最大值
         */
        int maximum = instance.getMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(maximum);

        /**
         * 最小值
         */
        int minimum = instance.getMinimum(Calendar.DAY_OF_MONTH);
        System.out.println(minimum);

        /**
         * 最小最大值
         */
        int leastMaximum = instance.getLeastMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(leastMaximum);

        /**
         * 最大最小值
         */
        int greatestMinimum = instance.getGreatestMinimum(Calendar.DAY_OF_MONTH);
        System.out.println(greatestMinimum);
    }

    public static void main(String[] args) {
        getLastDayOfMonthToJdkDate();
    }



}
