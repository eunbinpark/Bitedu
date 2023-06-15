package calendar.practiceBeforeTest;

import java.util.Scanner;

public class CalendarService {
    public static void main(String[] args) {
        CalendarService cs = new CalendarService();
        cs.StartCalendar();
    }

    // 캘린더를 실행하는 메소드
    public void StartCalendar(){
        Scanner scan = new Scanner(System.in);

        boolean flag = false;
        while(!flag){
            // 연월 입력받기
            System.out.print("\n네자리 연도를 입력하세요 >>> ");
            int year = Integer.parseInt(scan.nextLine());
            System.out.print("월을 입력하세요 >>> ");
            int month = Integer.parseInt(scan.nextLine());
            System.out.println("\n" + year +"년 " + month + "월");

            // 달력 출력하기
            MyCalendar cal = new MyCalendar();
            cal.printCalendar(year, month);

            System.out.print("\n계속하시겠습니까? (y/n) >>> ");
            String command = scan.nextLine();
            if (command.equals("n")){
                flag = true;
            }
        }


    }
}
