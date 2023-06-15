package lotto.lecture;

// 데이터클래스(DTO 또는 VO 라고 불림): 문제 해결을 위해 필요한 데이터 가져오기
// 은닉성
// implements Comparable<LottoBall>

public class LottoBall{
    private int number;
    private boolean isSelected; //  중복 처리: 로또 자체가 제공해야함

    public LottoBall(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    public boolean isSelected(){
        return isSelected;
    }
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    // getNumber 하지 않아도 오버라이드로 해결 가능
    @Override
    public String toString() {
        return String.valueOf(this.number); // this.number+"" 라고 해도 스트링 만들어짐
    }

//    @Override
//    public int compareTo(LottoBall o) {
//        return Integer.compare(this.getNumber(), o.getNumber());
//    }
}
