package calendar.test;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class MyCalendar {

    private String[][] calendar = new String[6][7];

    public static final String[] DAYS = {"일\t", "월\t", "화\t", "수\t", "목\t", "금\t", "토\t"};

    public static final int WEEKDAYS = 7;
    public static final int START_DATE = 1;

//    public void viewMonth(int year, int month) {
//        System.out.println(year + "년 " + month + "월");
//    }

    // 해당 연월의 1일에 해당하는 요일 찾는 메소드
    public int getDay(int year, int month){
        LocalDate day = LocalDate.of(year, month, START_DATE);
        DayOfWeek dayOfWeek = day.getDayOfWeek();
        return dayOfWeek.getValue();
    }

    // 해당 연월의 마지막 날짜 찾는 메소드
    public int getLengthOfMonth(int year, int month) {
        LocalDate date = LocalDate.of(year, month,START_DATE);
        int lengthOfMon = date.lengthOfMonth();
        return lengthOfMon;
    }

    // 달력을 출력하는 메소드
    public void getCalendar(int year, int month){
        System.out.println(year + "년 " + month + "월");

        for( String day : DAYS){
            System.out.print(day + " ");
        }
        System.out.println();

        // 첫번째 배열: 1일의 요일을 구해서, 해당인덱스부터 넣음
        int index= this.getDay(year, month);
        int dayCount = 1;
        for (int i=0; i<calendar.length; i++){
            if(i == 0){
                for (int j=0; j<WEEKDAYS; j++){
                    if (j < index) {
                        calendar[i][j] = "\t";
                    } else {
                        calendar[i][j] = dayCount+"\t";
                        dayCount++;
                    }
                }
            } else {
                for (int j=0; j<WEEKDAYS; j++){
                    if (dayCount <= this.getLengthOfMonth(year, month)) {
                        calendar[i][j] = dayCount + "\t";
                        dayCount++;
                    } else {
                        calendar[i][j] = "\t";
                    }
                }
            }
        }
    }

    public void printCalendar(){
        for (int i = 0; i < this.calendar.length; i++) {
            String[] inArr = this.calendar[i];
            for (int j = 0; j < inArr.length; j++) {
                System.out.print(inArr[j]);
            }
            System.out.println();
        }
    }


}
