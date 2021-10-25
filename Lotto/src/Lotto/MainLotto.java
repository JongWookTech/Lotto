package Lotto;

import step.Step1;
import step.Step2;
import step.Step3;
import step.Step4;
import step.Step5;
import step.Step6;
import step.StepBonus;

public class MainLotto {
	public int[][] mainnumber() {
		int[] firstnum = new int[10];
		int[] secondnum = new int[10];
		int[] thirdnum = new int[10];
		int[] fourthnum = new int[10];
		int[] fifthnum = new int[10];
		int[] sixthnum = new int[10];

		Step1 step1 = new Step1();
		firstnum = step1.step1();

		Step2 step2 = new Step2();
		secondnum = step2.step2();

		Step3 step3 = new Step3();
		thirdnum = step3.step3();

		Step4 step4 = new Step4();
		fourthnum = step4.step4();

		Step5 step5 = new Step5();
		fifthnum = step5.step5();

		Step6 step6 = new Step6();
		sixthnum = step6.step6();


		System.out.println();
		
		int[][] number = new int[10][6];

		for (int i = 0; i < 10; i++) {
			number[i][0] = firstnum[i];
			number[i][1] = secondnum[i];
			number[i][2] = thirdnum[i];
			number[i][3] = fourthnum[i];
			number[i][4] = fifthnum[i];
			number[i][5] = sixthnum[i];

			while (true) {
				// 1 == 2
				for (int j = 0; j < 10; j++) {
					if (number[i][0] == number[i][1] && i != 9) {
						number[i][1] = secondnum[i + j];
					} else {
						break;
					}
				}

				for (int j = 0; j < 10; j++) {
					if (number[i][0] == number[i][1] && i == 9) {
						number[i][1] = secondnum[i - j];
					} else {
						break;
					}
				}

				// 2 == 3
				for (int j = 0; j < 10; j++) {
					if (number[i][1] == number[i][2] && i != 9) {
						number[i][2] = thirdnum[i + j];
					} else {
						break;
					}
				}

				for (int j = 0; j < 10; j++) {
					if (number[i][1] == number[i][2] && i == 9) {
						number[i][2] = thirdnum[i - j];
					} else {
						break;
					}
				}

				// 3==4
				for (int j = 0; j < 10; j++) {
					if (number[i][2] == number[i][3] && i != 9) {
						number[i][3] = fourthnum[i + j];
					} else {
						break;
					}
				}

				for (int j = 0; j < 10; j++) {
					if (number[i][2] == number[i][3] && i == 9) {
						number[i][3] = fourthnum[i - j];
					} else {
						break;
					}
				}

				// 4==5
				for (int j = 0; j < 10; j++) {
					if (number[i][3] == number[i][4] && i != 9) {
						number[i][4] = fifthnum[i + j];
					} else {
						break;
					}
				}

				for (int j = 0; j < 10; j++) {
					if (number[i][3] == number[i][4] && i == 9) {
						number[i][4] = fifthnum[i - j];
					} else {
						break;
					}
				}

				// 5==6
				for (int j = 0; j < 10; j++) {
					if (number[i][4] == number[i][5] && i != 9) {
						number[i][5] = sixthnum[i + j];
					} else {
						break;
					}
				}

				for (int j = 0; j < 10; j++) {
					if (number[i][4] == number[i][5] && i == 9) {
						number[i][5] = sixthnum[i - j];
					} else {
						break;
					}
				}
				break;
			}


		}

		for (int i = 0; i < number.length; i++) {
			for (int j = 0; j < number[i].length -1; j++) {
				if(number[i][j] > number[i][j+1]) {
					int temp = number[i][j];
					number[i][j] = number[i][j+1];
					number[i][j+1] = temp;
				}
			}
		}
	

		return number;		
	}

	public int[] bonusnum() {
		int[] bonusnum = new int[10];
		int[] realBonus = new int[10];
		int[][] number = mainnumber();
		StepBonus bonus = new StepBonus();
		bonusnum = bonus.stepbonus();
		for (int i = 0; i < bonusnum.length; i++) {
			realBonus[i] = bonusnum[i];

		}
		

		while (true) {
			// bonus가 겹치는가?
				
				for (int i = 0; i < number.length; i++) {
					if (realBonus[i] == number[i][0]) {
						int exp = realBonus[i + 1];
						realBonus[i + 1] = realBonus[i];
						realBonus[i] = exp;
					}
					if (realBonus[i] == number[i][1]) {
						int exp = realBonus[i + 1];
						realBonus[i + 1] = realBonus[i];
						realBonus[i] = exp;
					}
					if (realBonus[i] == number[i][2]) {
						int exp = realBonus[i + 1];
						realBonus[i + 1] = realBonus[i];
						realBonus[i] = exp;
					}
					if (realBonus[i] == number[i][3]) {
						int exp = realBonus[i + 1];
						realBonus[i + 1] = realBonus[i];
						realBonus[i] = exp;
					}
					if (realBonus[i] == number[i][4]) {
						int exp = realBonus[i - 3];
						realBonus[i - 2] = realBonus[i];
						realBonus[i] = exp;

					}
					// 중복체크 문제 밠애
					if (realBonus[i] == number[i][5]) {
						int exp = realBonus[i + 1];
						realBonus[i + 1] = realBonus[i];
						realBonus[i] = exp;
					}
				}
				// 정렬 문제 발생
			break;
		}
		return realBonus;
	}
}
