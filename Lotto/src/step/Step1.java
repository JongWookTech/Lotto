package step;


import java.util.ArrayList;
import db.Count;
import db.Script;

//각 자리의 수가 몇번마다 등장했는지 계산
public class Step1 {
	public static void main(String[] args){
		Script script = new Script();
		Count count = new Count();
		
		for (int i = 0; i < 45; i++) {
			if (script.get(i+1).size() <= 3) {
				// 만약 이 숫자가 firstnum에 통계를 낼 수 없을정도로 적게 나왔다면
				// 작업을 취소시켜 메모리의 효율을 높힌다.
				continue;
			}
			ArrayList<Integer> lottoCount = script.get(i+1);
			int[] avgarr = new int[lottoCount.size()];
			int avg = 0;
			
			System.out.println(lottoCount);
			
			
			// 평균치를 계산할 배열에 1번방 - 0번방 식으로 값을 넣는다.
			for (int j = 0; j < avgarr.length-1; j++) {
				avgarr[j] = lottoCount.get(j+1) - lottoCount.get(j);
			}
			
			// 지금까지 넣은 모든 값을 나누기 위해 합해놓는다.
			for (int j = 0; j < avgarr.length-1; j++) {
				avg += avgarr[j];
			}
			
			
			
			if (lottoCount.size() == 1) {
				//한번밖에 출현 안했을 경우
				avgarr[0] = count.count() / 2; 
				
			}
			if(lottoCount.size() == 2) {
				//두번 출현한 경우
			System.out.println(i+1 + "의 평균 출현 주기 " + avg + "회 마다 출현");
			System.out.println();
			continue;
			}
			System.out.println(i+1 + "의 평균 출현 주기 " + avg / (avgarr.length-1)  + "회 마다 출현");
			System.out.println();
		}
		// 각 자리수 가 몇번마다 출현했는가? 평균치의 계산
		
		
		// 평균치 계산 끝 
		// 출현 횟수가 우선
		// 그 다음 언제 출현했는지?
		
		
		
	}
}
