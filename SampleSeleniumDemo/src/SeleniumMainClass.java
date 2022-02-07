import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMainClass {

	public static WebDriver driver = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\90542\\Downloads\\New folder\\chromedriver_win32\\chromedriver.exe");
	
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//open the web app
		driver.navigate().to("https://www.orioninc.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		
		if(title.equals("Orion Innovation | Digital Transformation | Digital Product Development - Orion Innovation")) {
			System.out.println("Hello World!");
			System.out.println("------ Success !!! ------");
			System.out.println("This is the website's current URL: " + driver.getCurrentUrl());
		}
		
		driver.close();
	}

}
