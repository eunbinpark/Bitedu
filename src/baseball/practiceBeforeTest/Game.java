package baseball.practiceBeforeTest;

public class Game {

    private String[] hiddenNumber;

    public Game(String[] hiddenNumber){
        this.hiddenNumber = hiddenNumber;
    }

    // 로직: 스트라이크, 볼 판단
    public int[] judgeBalls(String[] tryNumber){
        int[] result = new int[2];
        for(int i=0; i<hiddenNumber.length; i++){
            for(int j=0; j<tryNumber.length; j++){
                if(hiddenNumber[i].equals(tryNumber[j])){
                    if(i==j){
                        result[0]++;
                    }else{
                        result[1]++;
                    }
                }
            }
        }
        return result;
    }
}
