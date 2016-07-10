package Mantis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObject {
	private WebDriver driver;
			
	public PageObject(WebDriver driver) {
		this.driver = driver;
	}
		
	public void Open(){
		driver.navigate().to("http://mantis-prova.base2.com.br");
	}
	
	public void Loga(String username, String password){
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector("input.button")).click();
	}	
}

