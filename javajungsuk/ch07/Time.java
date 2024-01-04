package ch07;

public class Time {
    /**
     * private -> 같은 클래스 내에서만 접근할 수 있다.
     */
    private int hour, minute, second;

    /**
     * 생성자 -> setter로 매개변수 지정하겠다.
     */
    public Time(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        /**
         * 조건이 있다면, 검사 후 지정
         */
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
