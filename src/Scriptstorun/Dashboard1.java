package Scriptstorun;

import java.io.FileNotFoundException;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import codes.Ridesrch;
import codes.loginpage;
import codes.verifylogin;
import codes.FileReader;
import codes.takescreenshots;


public class Dashboard1 {
	
	
	loginpage log;
	Ridesrch rs;
	verifylogin vflogin ;
	takescreenshots tscr;
	Random rand = new Random();
	
	
	@Test(dataProvider="inputs")
	public void login1(String username1,String password1) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\Documents\\selenium_cls\\chromedriver.exe");
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.blablacar.in/register");
		System.out.println("Execution started");
		System.out.println(username1);
		System.out.println(password1);
		
		log = new loginpage();
		log.clickLoginButton(driver);
		log.enterLoginName(driver,username1);
		log.enterLoginPassword(driver, password1);
		log.clicksubmitbutton(driver);
		Reporter.log("login complete");
		tscr=new takescreenshots();
		int  n = rand.nextInt(50) + 1;
		tscr.takeshot(n,driver);
		
		vflogin = new verifylogin();
		vflogin.clickDashboardTab(driver);
		boolean result=vflogin.isLinkPresent(driver, "Dashboard");
		Assert.assertTrue(result);
		boolean result2=vflogin.isEditYourProfileLinkPresent(driver);
		Assert.assertTrue(result2);
		System.out.println("COMPLETED");
		
		rs = new Ridesrch();
		rs.clickridesrch(driver);
		
		Thread.sleep(1000);
		System.out.println("ended  ");
		}
	
	
	@DataProvider(name="inputs")
	public Object[][] inputs() throws FileNotFoundException{
		Object[][] data = null;
		String datafile="C:\\Users\\IBM_ADMIN\\Documents\\eclipsework\\Blablaproject\\src\\Data\\DashboardVerifyDifferentUserNameCombination.xlsx";

		FileReader f = new FileReader();
		data=f.fetchdata(datafile);
		return data;
		
		
	}
}
