package Mantis;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class LoginTest{
	
	private PageObject TelaDeLogin;
	private static WebDriver driver;
    	
	@Before
	public void setUp() {
		WebDriver driver = new FirefoxDriver();
		this.TelaDeLogin = new PageObject(driver);
	}
	
	@Test
	public void Login(){
		TelaDeLogin.Open();
		//Logar com sucesso
		TelaDeLogin.Loga("heidy.saar","123456");
	}
	
	@Test
	public void LoginFail(){
		TelaDeLogin.Open();		
		//Logar com usuário inválido
		TelaDeLogin.Loga("heidy.saar","654321");		
	}
	
	@After
	public void FecharJanela(){
		driver.quit();	
	}
}
