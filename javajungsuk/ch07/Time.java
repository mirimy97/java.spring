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

    /**
     * 멤버 변수를 다루기 위한 setter는 접근 제어자로 public을 사용했다.
     * -> t.hour = 13; 과 같은 직접 접근은 허용되지 않고,
     * t.setHour(13); 과 같이 메서드를 통한 접근만 허용된다.
     */
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
