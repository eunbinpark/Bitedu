package lotto.lecture;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Studio {
    public static void main(String[] args) {
        // 6개의 무작위 숫자 뽑아내기
        // ready()를 호출할 수가 없음 (non-static 이므로) : 객체를 생성해서 호출하기
        Studio sbs = new Studio();
        sbs.onAir();
    }

    // 로또 머신과 로또 볼을 준비해야함 : 아래 메소드에서 사용할 수 있도록 로또 머신을 리턴해야함
    // 최근 추세가 프로터티를 웬만하면 안만드는 추세임 - 쓰레드 때문에 ?

    public LottoMachine ready() {

        // 로또 머신과 로또 볼을 준비
        LottoMachine machine = new LottoMachine();
        ArrayList<LottoBall> balls = new ArrayList<>();
        for (int i=0; i<45; i++){
            balls.add(new LottoBall(i+1));
        }

        // 머신에 볼 세팅
        machine.setBalls(balls);
        return machine;
    }

    // 로또 머신에게 볼을 뽑도록 지시
    public void onAir() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("🎉" + date.format(formatter) + " 로또 추첨을 시작합니다 !");

        LottoMachine machine = this.ready();
        LottoBall[] balls = machine.startMachine();

        // balls의 내용을 출력
        System.out.println("오늘의 로또 번호는 .. ! 😮");

        try{
            Thread.sleep(1000); // 일정간격
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        // ball 순서 정렬.. 정렬 알고리즘 ?..
        for (int i=0; i<balls.length-1; i++){
            for (int j=i+1; j < (balls.length); j++) {
                if (balls[i].getNumber() > balls[j].getNumber()) {
                    LottoBall temp = balls[j];
                    balls[j] = balls[i];
                    balls[i] = temp;
                }
            }
        }

//        Arrays.sort(balls, new Comparator<LottoBall>() {
//            @Override
//            public int compare(LottoBall b1, LottoBall b2) {
//                return Integer.compare(b1.getNumber(), b2.getNumber());
//            }
//        });

//        Arrays.sort(balls);


        for(LottoBall ball: balls) {
            System.out.println(ball.toString() + "번"); // getNumber 라고 안해도 숫자 출력하도록
        }
        System.out.println("입니다. 시청해주셔서 감사합니다.😸");

    }


}
