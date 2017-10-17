package codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class loginpage {
	String loginButtonLoc ="//a[contains(text(),'Login')]";
	String loginTextBoxLoc ="//input[@id='email']";
	String passTextBoxLoc ="//input[@id='pass']";
	String submitbtn =".//*[@id='u_0_2']";
	
	public void clickLoginButton(WebDriver driver){
		driver.findElement(By.xpath(loginButtonLoc)).click();
	}
	
	public void enterLoginName(WebDriver driver, String value){
		Reporter.log("enter loggin name");
		driver.findElement(By.xpath(loginTextBoxLoc)).sendKeys(value);
	}
	
	public void enterLoginPassword(WebDriver driver,String value){
		driver.findElement(By.xpath(passTextBoxLoc)).sendKeys(value);
	}
	
	public void clicksubmitbutton(WebDriver driver){
		driver.findElement(By.xpath(submitbtn)).click();
	}

}
