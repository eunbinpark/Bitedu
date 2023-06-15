package lotto.practice2;

import java.util.ArrayList;
import java.util.Comparator;

public class Studio {
    public static void main(String[] args) {
        Studio studio = new Studio();
        studio.startGame();
    }

    public LottoMachine ready(){

        // 기계 준비
        LottoMachine machine = new LottoMachine();

        // 공 준비
        ArrayList<LottoBall> balls = new ArrayList<>();
        for(int i=1; i<=45; i++){
            balls.add(new LottoBall(i));
        }

        // 머신에 공 넣기
        machine.setBalls(balls);

        return machine;
    }

    public void startGame(){
        System.out.println("로또 추첨을 시작합니다 ~ !");
        // 공 6개 뽑기
        LottoMachine machine = this.ready();
        ArrayList<LottoBall> selectedBalls = new ArrayList<>();
        while(true){
            LottoBall ball = new LottoBall(machine.getBall());
            if (!ball.isSelected()){
                selectedBalls.add(ball);
                ball.setSelected(true);
                System.out.println(ball);
                try{
                    Thread.sleep(800);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            if (selectedBalls.size() == 6){
                break;
            }
        }

        System.out.print("오늘의 로또 번호는 ");

        selectedBalls.sort(new Comparator<>() {
            @Override
            public int compare(LottoBall o1, LottoBall o2) {
                return o1.getNumber() - o2.getNumber();
            }
        });

        for (LottoBall ball: selectedBalls){
            System.out.print(ball.toString()+ " ");
        }

        System.out.println("입니다.");
        System.out.println("시청해 주셔서 감사합니다.😊");
    }
}
