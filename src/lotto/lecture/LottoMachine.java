package lotto.lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// 로직 클래스(service)
public class LottoMachine {
    private ArrayList<LottoBall> balls; // 저장소

    public LottoBall[] startMachine() {
        // 로또볼 6개 꺼내기
        LottoBall[] selectedBalls = null;

        selectedBalls = new LottoBall[6];
        for(int i=0; i<selectedBalls.length; i++){ // 6번 반복한다.(하드코딩 X) - 어쩔 수 없는 경우 제외하고는 쓰지 말자
            Collections.shuffle(balls);
            selectedBalls[i] = this.getBall();
            System.out.println(selectedBalls[i] + "번이 선택되었습니다!");
            try{
                Thread.sleep(200); // 일정간격
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return selectedBalls;
    }

    private LottoBall getBall() {
        // 1개의 로또볼을 꺼내기
        LottoBall ball = null;
        Random rnd = new Random();
        int index = rnd.nextInt(balls.size());
        ball =balls.remove(index);
        return ball;

//        while (true) {
//            // 저장소에서 꺼낼 공 결정
//            int index = rnd.nextInt(balls.size());
//            // 공을 꺼낸다.
//            ball = balls.get(index);
//            // 꺼낸 공 중복 체크
//            if (!ball.isSelected()) {
//                // 중복이 아닐 경우 중복 체크 후 빠져나감
//                ball.setSelected(true);
//                break;
//            }
//        }
//
    }

    public void setBalls(ArrayList<LottoBall> balls) {
        this.balls = balls;
    }
}
