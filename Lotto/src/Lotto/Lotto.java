package Lotto;

import java.util.HashMap;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import db.Script;

public class Lotto {
	private WebDriver driver;
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
//	public static final String WEB_DRIVER_PATH = "C:\\chromedriver.exe";
	public static final String WEB_DRIVER_PATH = "E:\\chromedriver.exe";

	public static void main(String[] args) {
		Script script = new Script();
		Lotto lotto = new Lotto();
		int count = 986;
	
		
		

		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		lotto.driver = new ChromeDriver(options);

		String url = "https://www.dhlottery.co.kr/common.do?method=main";
		lotto.driver.get(url);
		
		
		
		lotto.driver.findElement(By.id("lottoDrwNo"));
		
		for (int i = 0; i < 986; i++) {
			int[] number = new int[8];
			int bonus = 1;
			System.out.print(count + " 회차 : ");
			for (WebElement el : lotto.driver.findElements(By.className("ball_645"))) {
				if (bonus == 7) {
					int num = Integer.parseInt(el.getText());
					number[bonus] = num;
					System.out.print("+ " + el.getText());
				} else {
					int num = Integer.parseInt(el.getText());
					number[bonus] = num;
					System.out.print(el.getText() + " ");
				}
				bonus++;
			}
			script.put(count,number);
			System.out.println();
			if (i != 985) {
				lotto.driver.findElement(By.className("prev")).click();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					;
				}
			}
			count--;
		}
		

		lotto.driver.close();
		lotto.driver.quit();
		
		
	}

}