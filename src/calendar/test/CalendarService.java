package calendar.test;

import java.util.Scanner;

public class CalendarService {

    public static void main(String[] args) {
        CalendarService cs = new CalendarService();
        cs.startService();
    }

    public void startService() {
        // 달력을 만들어내는 객체를 이용하여 서비스하는 내용
        // 원하는 만큼 달력을 만들어 낼 수 있다.
        // 원하는 달, 원하는 년도의 모든 월을 볼 수 있다.
        Scanner input = new Scanner(System.in);
        MyCalendar myCal = new MyCalendar();

        System.out.println("서비스를 시작합니다.");
        boolean flag = false;
        while (!flag) {
            // 년도를 입력받고
            System.out.println("연도를 입력하세요[4자리] >>> ");
            String temp = input.nextLine();
            int year = Integer.parseInt(temp);

            // 월을 입력받고(월 전체 인지, 1개월 인지)
            System.out.println("월을 입력하세요[해당년도 월 전체출력: 13입력] >>> ");
            temp = input.nextLine();
            int month = Integer.parseInt(temp);

            // 객체에게 요청
            if (month == 13) {
                for(int i=0; i<12; i++){
                    myCal.getCalendar(year, i+1);
                    myCal.printCalendar();
                }
            } else {
                myCal.getCalendar(year, month);
                myCal.printCalendar();
            }

            // 계속 서비스 이용할지 물어보기
            System.out.println("계속 이용 하시겠습니까? [예: yes, 아니오: no]");
            String cmd = input.nextLine();
            if (cmd.equals("no")) {
                System.out.println("이용해 주셔서 감사합니다.");
                flag = true;
            }
        }
    }
}
