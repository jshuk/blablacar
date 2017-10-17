package codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Ridesrch {
	
	public void clickridesrch(WebDriver driver){
		
		driver.findElement(By.partialLinkText("Find a ride")).click();
		driver.findElement(By.id("search_from_name")).sendKeys("hadapsar");
		driver.findElement(By.id("search_to_name")).sendKeys("magarpatta");
		driver.findElement(By.cssSelector("input[value='Find']")).click();
		driver.close();
		
	}

}
