package lotto.practice2;

import java.util.ArrayList;
import java.util.Random;

public class LottoMachine {

    private ArrayList<LottoBall> balls;

    // 랜덤으로 공 뽑기
    public int getBall() {
        Random rnd = new Random();
        int index = rnd.nextInt(balls.size())+1;
        LottoBall ball = new LottoBall(index);
        return ball.getNumber();
    }

    // 공 세팅하기
    public void setBalls(ArrayList<LottoBall> balls) {
        this.balls = balls;
    }
}
