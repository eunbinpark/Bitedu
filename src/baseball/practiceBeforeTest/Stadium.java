package baseball.practiceBeforeTest;

import java.util.Scanner;

public class Stadium {
    public static void main(String[] args) {
        Stadium sd = new Stadium();
        sd.playBall();
    }

    public void playBall(){
        String[] systemBalls;
        systemBalls = GameHelper.getSystemBalls();
        Game game = new Game(systemBalls);
        int[] result;
        Scanner scan = new Scanner(System.in);
        String[] tryBall;
        boolean flag = false;
        while(!flag){
            while (true){
                System.out.print("중복없는 네자리 숫자를 입력하세요 >>>");
                String tryNumber = scan.nextLine();
                tryBall = GameHelper.checkBalls(tryNumber);
                if(tryBall==null){
                    System.out.println("중복있음. 다시입력");
                }else{
                    break;
                }
            }
            result = game.judgeBalls(tryBall);
            if(result[0] == 4){
                System.out.println("정답입니다!");
                break;
            } else {
                System.out.println(result[0] + "스트라이크 " + result[1] + "볼!");
                System.out.print("기권하시겠습니까?(y/n) >>> ");
                String temp = scan.nextLine();
                if (temp.equals("y")){
                    flag=true;
                    System.out.println("게임을 종료합니다.");
                }
            }
        }
    }
}
