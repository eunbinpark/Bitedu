package baseball.practiceBeforeTest;

import java.util.Arrays;
import java.util.Random;

public class GameHelper {


    // 랜덤 공 네개 뽑는 메소드
    public static String[] getSystemBalls(){
        String[] systemBalls;
        Random rnd = new Random();
        while(true){
            int rndNumber = rnd.nextInt(9000)+1000;
            systemBalls = checkBalls(String.valueOf(rndNumber));
            System.out.println(Arrays.toString(systemBalls));
            if(systemBalls!=null){
                break;
            }
        }
        return systemBalls;
    }

    // 공 중복 확인 메소드
    public static String[] checkBalls(String numbers){
        String[] tryBall = new String[4];
        int[] test = new int[10];
        for(int i=0; i<numbers.length(); i++){
            int index =Integer.parseInt(String.valueOf(numbers.charAt(i)));
            if(test[index] != 0){
                tryBall = null;
                break;
            }else {
                if(index==0){
                    test[index]=index+1;
                }else{
                    test[index]=index;
                }
                tryBall[i] = String.valueOf(index);
            }
        }
        return tryBall;
    }
}
