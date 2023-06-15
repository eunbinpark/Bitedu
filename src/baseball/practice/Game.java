package baseball.practice;

import java.util.ArrayList;

public class Game {
    public boolean runGame(ArrayList<Integer> sysNUmber, ArrayList<Integer> userNumber){

        int strike = 0;
        int ball = 0;

        for (int i=0; i < sysNUmber.size(); i++) {
            if (sysNUmber.get(i).equals(userNumber.get(i))){
                strike++;
            }else if (sysNUmber.contains(userNumber.get(i))){
                ball++;
            }
        }

        if (strike == 4){
            System.out.println("정답입니다!");
            return true;
        }

        if (strike == 0 && ball == 0){
            System.out.println("아웃!");
        } else {
            System.out.println(strike + " 스트라이크");
            System.out.println(ball + " 볼");
        }
        return false;
    }
}

