package bitedu.bipa.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//로직클래스(Service)
public class LottoMachine {
	private ArrayList<LottoBall> balls;
	
	//6개의 로또볼을 꺼내겠다!
	public LottoBall[] startMachine() {
		LottoBall[] selectedBalls = null;
		selectedBalls = new LottoBall[6];
		for(int i=0;i<selectedBalls.length;i++) {
			Collections.shuffle(balls); //섞어주는 코드
			//6번 반복
			selectedBalls[i] = this.getBall();
			System.out.println(selectedBalls[i]+"번이 선택되었습니다.");
			try {
				Thread.sleep(1500); //일정간격
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return selectedBalls;
	}
	private LottoBall getBall() {
		LottoBall ball = null;
		Random rnd = new Random();
		int index = rnd.nextInt(balls.size());
		ball = balls.remove(index); //완전히 꺼내므로 자동으로 중복처리
		return ball;
	}
	
	//1개의 로또볼을 꺼낸다.
	private LottoBall getBallOld() {
		LottoBall ball = null;
		Random rnd = new Random();
		//중복처리를 한다.(중복아닌 공이 나올때까지 반복)
		while(true) {
			//저장소에서 꺼낼 공 결정
			int index = rnd.nextInt(balls.size());
			//공을 꺼낸다.
			ball = balls.get(index);
			//꺼낸 공 중복 체크
			if(!ball.isSelected()) {
				//중복이 아닐 경우 중복체크 후 빠져나감 
				ball.setSelected(true);
				break;
			} 
		}
		return ball;
	}
	
	public void setBalls(ArrayList<LottoBall> balls) {
		this.balls = balls;
	}
}
