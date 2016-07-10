package Mantis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastrarIssueTest {
			
		private PageObject TelaDeLogin;
		private WebDriver driver;
	    	
		@Before
		public void setUp() {
			WebDriver driver = new FirefoxDriver();
			this.TelaDeLogin = new PageObject(driver);
		}
		
		@Test
		public void Cadastrar(){
			TelaDeLogin.Open();
			//Logar com sucesso
			TelaDeLogin.Loga("heidy.saar","123456");
			
			//Cadastrando nova Issue
			driver.findElement(By.linkText("Report Issue")).click();
		    new Select(driver.findElement(By.name("category_id"))).selectByVisibleText("[All Projects] General");
		    new Select(driver.findElement(By.name("reproducibility"))).selectByVisibleText("always");
		    new Select(driver.findElement(By.name("handler_id"))).selectByVisibleText("heidy.saar");
		    driver.findElement(By.name("summary")).clear();
		    driver.findElement(By.name("summary")).sendKeys("Bug Teste");
		    driver.findElement(By.name("description")).clear();
		    driver.findElement(By.name("description")).sendKeys("Sistema não está cadastrando cliente.");
		    driver.findElement(By.cssSelector("input.button")).click();
		 }
		
		@After
		public void FecharJanela(){
			driver.quit();	
		}
}	

