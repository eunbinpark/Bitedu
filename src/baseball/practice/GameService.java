package baseball.practice;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class GameService {

    public static final int MAX_NUM = 10;
    public static final int NUM_OF_BALLS = 4;
    public ArrayList<Integer> sysBalls = new ArrayList<>();


    public static void main(String[] args) {
        GameService gs = new GameService();
        gs.ready();
        gs.startGame();
    }

    // 정답값(sysBalls) 세팅하는 메소드
    public void ready(){
        Random rnd = new Random();
        while (true) {
            int index = rnd.nextInt(MAX_NUM);
            if (!sysBalls.contains(index)) {
                sysBalls.add(index);
            }
            if (sysBalls.size() == NUM_OF_BALLS && sysBalls.get(0) != 0) {
                break;
            }
        }
    }

    // 입력값 중복 체크하는 메소드
    public boolean isIn(ArrayList<Integer> userBalls){
        for (int i=0; i<userBalls.size(); i++){
            for(int j=i+1; j<userBalls.size(); j++){
                if (Objects.equals(userBalls.get(i), userBalls.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }


    // 게임을 실행시키는 메소드
    public void startGame(){
        System.out.println("⚾ 숫자야구를 시작합니다 ! ⚾");
        System.out.println(" ");
        Game game= new Game();
        ArrayList<Integer> userBalls;
        String tmpInput;

        // 반복해서 정답 판단하기
        while (true) {

            // 반복해서 사용자 입력 받기
            while (true) {

                // 사용자 숫자 입력
                userBalls = new ArrayList<>();
                System.out.println("네자리 숫자를 중복없이 입력하세요. (기권: gg)");
                Scanner sc = new Scanner(System.in);
                tmpInput = sc.nextLine();

                // 기권
                if (tmpInput.equals("gg")){
                    break;
                }

                // 기권 아닐 경우 - int 리스트 생성
                for (int i = 0; i< tmpInput.length(); i++) {
                    userBalls.add(Character.getNumericValue(tmpInput.charAt(i)));
                }

                // 입력값 예외처리
                if (userBalls.size() != 4) {
                System.out.println("💥 네자리가 아닙니다 !!");
                } else if (isIn(userBalls)) {
                    System.out.println("💥 중복이 있습니다 !!");
                } else {
                    break;
                }
            }

            // 게임 종료 조건
            if (tmpInput.equals("gg") || game.runGame(sysBalls, userBalls)) {
                System.out.println("게임을 종료합니다.😎");
                break;
            }

        }
    }
}
