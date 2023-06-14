package bitedu.bipa.test;

// 데이터클래스(DTO,VO)
public class LottoBall {
	private int number;
	private boolean isSelected;
	
	public LottoBall(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
//	public void setNumber(int number) {
//		this.number = number;
//	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(this.number); //this.number+""
	}

}
