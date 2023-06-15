package lotto.practice2;

public class LottoBall {

    private int number;

    private boolean isSelected= false;


    public LottoBall(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        int number = this.number;
        return Integer.toString(number);
    }
}
