package calendar.practiceBeforeTest;

import java.time.LocalDate;

// 로직 클래스
public class MyCalendar {
    public static final String[] DAYS = {"월", "화", "수", "목", "금", "토", "일"};
    public static final int WEEKDAYS = 7;
    private int[][] calendar = new int[6][7];


    // 달력을 만드는 메소드
    public int[][] makeCalendar(int year, int month) {
        LocalDate input = LocalDate.of(year, month, 1);
        int daysOfMonth = input.lengthOfMonth();
        int firstDayIndex = input.getDayOfWeek().getValue();

        int date = 1;
        for (int i = firstDayIndex - 1; i < WEEKDAYS; i++) {
            calendar[0][i] = date;
            date++;
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < WEEKDAYS; j++) {
                if (date > daysOfMonth) {
                    break;
                }
                calendar[i][j] = date;
                date++;
            }

        }

        return calendar;
    }

    // 달력을 출력하는 메소드
    public void printCalendar(int year, int month){
        int[][] calendar = this.makeCalendar(year, month);

        for(String day: DAYS){
            System.out.print(day + "\t");
        }

        System.out.println();

        for(int i=0; i<6; i++){
            for(int j=0; j<WEEKDAYS; j++){
                if(calendar[i][j] != 0){
                    System.out.print(calendar[i][j] + "\t");
                } else{
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }
    }
}
