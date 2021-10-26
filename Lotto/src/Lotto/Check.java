package Lotto;

public class Check {
	public static void main(String[] args) {
		MainLotto lotto2 = new MainLotto();
		int[][] number = lotto2.mainnumber();
		for (int i = 0; i < number.length; i++) {
			System.out.print(i + "번째 조합 : ");
			for (int j = 0; j < number[i].length; j++) {
				System.out.print(number[i][j] + " ");

			}
			System.out.println();
		}
		int zero = 0;
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;

		for (int h = 0; h < 2; h++) {
			int count = 0;
			int lotto[] = new int[6];

			// 번호 생성
			for (int i = 0; i < 6; i++) {
				lotto[i] = (int) (Math.random() * 45) + 1;

				// 중복 번호 제거
				for (int j = 0; j < i; j++) {
					if (lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}
			}

			for (int k = 0; k < lotto.length - 1; k++) {

				for (int i = 0; i < lotto.length - 1; i++) {
					if (lotto[i] > lotto[i + 1]) {
						int temp = lotto[i];

						lotto[i] = lotto[i + 1];
						lotto[i + 1] = temp;
					}
				}
			}

			// 번호 출력
			for (int i = 0; i < number[3].length; i++) {
				for (int j = 0; j < lotto.length; j++) {
					if (lotto[j] == number[3][i]) {
						count++;
					}
				}
			}
			if (count >= 5) {
				System.out.println();
				System.out.println();
				for (int i = 0; i < number[3].length; i++) {
					System.out.print(lotto[i] + " ");
				}
				System.out.println();
				for (int i = 0; i < number[3].length; i++) {
					System.out.print(number[3][i] + " ");
				}
				System.out.println();
				System.out.print(count + "개");
			}
			if (count == 0) {
				zero++;
			}
			if (count == 1) {
				one++;
			}
			if (count == 2) {
				two++;
			}
			if (count == 3) {
				three++;
			}
			if (count == 4) {
				four++;
			}
			if (count == 5) {
				five++;
			}
			if (count == 6) {
				six++;
			}
		}
		System.out.println();
		System.out.println("0 개 : " + zero);
		System.out.println("한 개 : " + one);
		System.out.println("두 개 : " + two);
		System.out.println("세 개 : " + three);
		System.out.println("네 개 : " + four);
		System.out.println("다섯 개 : " + five);
		System.out.println("여섯 개 : " + six);
	}
}
