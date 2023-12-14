package ch06;

import java.time.Duration;
import java.time.LocalTime;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) return;
        this.hour = hour;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) return;
        this.minute = minute;
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) return;
        this.second = second;
    }

}

class TimeTest {
    public static void main(String args[]) {
        Time t1 = new Time();
        Time t2 = new Time();

        t1.setHour(3);
        t1.setMinute(32);
        t1.setSecond(58);
        System.out.println("t1은 현재 " + t1.getHour() + "시 " + t1.getMinute() + "분 " + t1.getSecond() + "초입니다.");

        t2.setHour(5);
        t2.setMinute(22);
        t2.setSecond(52);
        System.out.println("t2는 현재 " + t2.getHour() + "시 " + t2.getMinute() + "분 " + t2.getSecond() + "초입니다.");

        diff(t1, t2);
    }

    // 심화) 시간의 차 구하는 메서드
    public static void diff(Time t1, Time t2) {
        int h1 = t1.getHour();
        int m1 = t1.getMinute();
        int s1 = t1.getSecond();
        int h2 = t2.getHour();
        int m2 = t2.getMinute();
        int s2 = t2.getSecond();

        LocalTime t1ToTime = LocalTime.of(h1, m1, s1);
        LocalTime t2ToTime = LocalTime.of(h2, m2, s2);
        Duration diff = Duration.between(t1ToTime, t2ToTime);

        System.out.println("시간 차이는 " + diff + "입니다.");
    }
}