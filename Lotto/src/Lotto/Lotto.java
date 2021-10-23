package lotto;

import java.util.HashMap;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lotto {
	private WebDriver driver;
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\chromedriver.exe";
//	public static final String WEB_DRIVER_PATH = "E:\\chromedriver.exe";

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		int count = 985;
	
		
		HashMap<String,Integer> number = new HashMap<String, Integer>();
		HashMap<String,Integer> bonusnum = new HashMap<String, Integer>();
		
		for (int i = 1; i < 46; i++) {
			number.put(i+"", 0);
			bonusnum.put(i+"", 0);
		}

		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		lotto.driver = new ChromeDriver(options);

		String url = "https://www.dhlottery.co.kr/common.do?method=main";
		lotto.driver.get(url);

		lotto.driver.findElement(By.id("lottoDrwNo"));

		for (int i = 0; i < 201; i++) {
			int bonus = 1;
			System.out.print(count + " 회차 : ");
			for (WebElement el : lotto.driver.findElements(By.className("ball_645"))) {
				if (bonus == 7) {
					int num = Integer.parseInt(el.getText());
					bonusnum.put(el.getText(), bonusnum.get(el.getText())+1);
					System.out.print("+ " + el.getText());
				} else {
					int num = Integer.parseInt(el.getText());
					number.put(el.getText(), number.get(el.getText())+1);
					System.out.print(el.getText() + " ");
				}
				bonus++;
			}
			count--;
			System.out.println();
			if (i != 200) {
				lotto.driver.findElement(By.className("prev")).click();
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					;
				}
			}

		}
		

		lotto.driver.close();
		lotto.driver.quit();
		
		
		
		System.out.println(number);
		System.out.println(bonusnum);
		
	}

}
