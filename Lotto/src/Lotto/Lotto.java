package Lotto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lotto {
	private WebDriver driver;
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "E:\\chromedriver.exe";

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		int count = 985;
		
		String [][] number = new String[count][7];

		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		lotto.driver = new ChromeDriver(options);

		String url = "https://www.dhlottery.co.kr/common.do?method=main";
		lotto.driver.get(url);
		
		lotto.driver.findElement(By.id("lottoDrwNo"));
		
		
		for (int i = 0; i < 985; i++) {
			System.out.print(count + " 회차 : ");
			for (WebElement el : lotto.driver.findElements(By.className("ball_645"))) {
				System.out.print(el.getText() + " ");
			}
			count--;
			System.out.println();
			
			lotto.driver.findElement(By.className("prev")).click();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				;
			}	
		}
		


		lotto.driver.close();
		lotto.driver.quit();
	}
}
