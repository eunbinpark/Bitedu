package bitedu.bipa.test;

import java.util.ArrayList;

public class Studio {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Studio sbs = new Studio();
		//sbs.ready();  --> onAir에서 준비 요청하고 있음
		sbs.onAir();
	}
	
	
	public LottoMachine  ready() {
		//로또 머신과 로또 볼을 준비해야 함
		LottoMachine machine = null;
		//머신 준비
		machine = new LottoMachine();
		//볼 준비
		ArrayList<LottoBall> balls = new ArrayList<LottoBall>();
		for(int i=0;i<45;i++) {
			balls.add(new LottoBall(i+1));
		}
		//머신에 볼 셋팅
		machine.setBalls(balls);
		return machine;
		
	}
	
	
	public void onAir() {
		//로또 머신에게 볼을 뽑도록 지시
		System.out.println("지금부터 로또 추첨 방송을 시작합니다.");
		LottoMachine machine = this.ready();
		System.out.println("추첨을 시작합니다.");
		LottoBall[] balls = machine.startMachine();
		//정렬로직(오름차순)
		// 주어진 길이만큼 반복
		LottoBall target = null;
		for(int k=0;k<balls.length;k++) {
			for(int i=k+1;i<balls.length;i++) {
				target = balls[k];
				//비교
				if(target.getNumber()>balls[i].getNumber()) {
					//교환
					LottoBall temp = balls[k];
					balls[k] = balls[i];
					balls[i] = temp;
				}
			}
		}
		
		//balls의 내용을 출력
		System.out.println("제XXX회 로또 번호는");
		for(LottoBall ball : balls) {
			System.out.println(ball+"번");
		}
		System.out.println("이었습니다.");
		System.out.println("지금까지 시청해주셔서 감사합니다.\n이것으로 제XXX회 로또추첨방송을 마치겠습니다.");
	}
}
