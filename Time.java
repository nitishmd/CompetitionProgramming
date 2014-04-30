/*
 * Author: Nitish
 * Problem: TopCoder SRM 144 Div 2
 */
public class Time {
  
  public String whatTime(int seconds) {
    int hour = (seconds / 3600) % 24;
    int min = (seconds / 60) % 60;
    int sec = seconds % 60;
    return  "" + hour + ":" + min + ":" + sec;
  }

  public static void main(String[] args) {
    Time t = new Time();
    System.out.println(t.whatTime(86399));
  }
}
