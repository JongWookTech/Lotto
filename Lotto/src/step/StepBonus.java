package step;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import db.Count;
import db.Script;

//보너스 숫자는 도출해낼 필요가 없다.

//각 자리의 수가 몇번마다 등장했는지 계산
public class StepBonus {
	public int[] stepbonus(){
		Script script = new Script();
		Count count = new Count();
		HashMap<Integer, Float> ratiomap = new HashMap<>();
		// 각 숫자의 지금까지의 출현 비율을 도출
		HashMap<Integer, Integer> lasttime = new HashMap<>();
		//마지막에 나온 회차를 담기 위함
		HashMap<Integer, Float> prio = new HashMap<>();
		// 각 숫자와 비율을 map으로 저장
		int[] result = new int[10];
		
		
		for (int i = 1; i < 46; i++) {
			float ratio = 0;
		// 첫번째 자리에 1~45가 몇회차에 나왔는지 결과 도출
			if (script.getB(i).size() == 0) {
			//만약 한번도 나온적이 없는 숫자이면 다음 작업 수행
				continue;
			}
			//각 숫자의 마지막 출현회차 도출
			lasttime.put(i, script.getlastB(i));
			// 각 숫자의 통계적 출현 확률
			ratio = (float) (script.getB(i).size() / (200.00 / 100));
//			ratio = script.getB(i).size() / ((float)count.count() / 1000);
			//HashMap에 각 숫자와 출현 비율 저장
			ratiomap.put(i, ratio);
		}
		ArrayList<Entry<Integer, Float>> ratiosort = new ArrayList<>(ratiomap.entrySet());
		ratiosort.sort(Entry.comparingByValue());
		// value값 정렬
		
		
		
		
		
		for (int i = 1; i < 11; i++) {
			//여기부터 평균적인 출현 주기 도출해내기
			
			int number = ratiosort.get(ratiosort.size()-i).getKey();
			// sort된 ratiosort에서 순차적으로 뽑아낸 key값들
			int previous = count.count() - lasttime.get(ratiosort.get(ratiosort.size()-i).getKey());
			// 몇회 전에 출현 했는지 담은 변수
			
			ArrayList<Integer> lottoCount = script.getB(number);
			int avg = 0;
			int[] avgarr = new int[lottoCount.size()];
			
			for (int j = 0; j < avgarr.length-1; j++) {
				avgarr[j] = lottoCount.get(j+1) - lottoCount.get(j);
			}
			for (int j = 0; j < avgarr.length-1; j++) {
				avg += avgarr[j];
			}
			
			
//			System.out.println(ratiosort.get(ratiosort.size()-i) + "%");
			// 몇퍼센트의 비율을 가지고 있는가?
//			System.out.print(number + " : ");
			//get.key = sort된 ratiosort에서 순차적으로 뽑아낸 key값들
//			System.out.println(previous+ "회 전에 출현");
			// 몇회 전에 출현했는가?
//			System.out.println(number + " : " + avg / (avgarr.length-1) + "회마다 출현");
			//평균적으로 몇회마다 출현하는가?
			float like = (float) ((float) ratiosort.get(ratiosort.size()-i).getValue() + (float)(previous - avg / (avgarr.length-1)) * 0.2 * 1.2);
			prio.put(number, like);			
		}
		
		ArrayList<Entry<Integer, Float>> ratiosort2 = new ArrayList<>(prio.entrySet());
		ratiosort2.sort(Entry.comparingByValue());
//		System.out.println(ratiosort2);
		for (int i = 0; i < result.length; i++) {
			result[i] = ratiosort2.get(result.length-(i+1)).getKey();
		}
//		for (int i = 0; i < result.length; i++) {
//			System.out.println(result[i]);
//		}
		return result;
	}
}




