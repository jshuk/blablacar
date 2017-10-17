package codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class verifylogin {
	
	public void clickDashboardTab(WebDriver driver){
		driver.findElement(By.xpath(".//*[@id='icon-arrow-down']")).click();
		driver.findElement(By.partialLinkText("Dashboard")).click();
                                                   }
	public boolean isLinkPresent(WebDriver driver,String linkName){
		//tryCatc to check code for element present
	//	String str = driver.findElement(By.linkText(linkName));
		String strng = driver.getTitle();
        System.out.println(strng);
        if(strng.contains("Dashboard"))
        	return true;
        else 
        	return false;
	}
	public boolean isEditYourProfileLinkPresent(WebDriver driver){
		//tryCatc to checck code for element preesent
		//driver.findElement(By.xpath(editProfileLinkxpath)).click();;
		
		driver.findElement(By.partialLinkText("Edit your profile")).click();
        String profilestr = driver.getTitle();
        System.out.println(profilestr);
        if(profilestr.contains("Profile"))
        	return true;
        else
        	return false;
		//return false;
	}
	
	
}