package Mantis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UpdateIssueTest {
		
		private PageObject TelaDeLogin;
		private WebDriver driver;
	    	
		@Before
		public void setUp() {
			WebDriver driver = new FirefoxDriver();
			this.TelaDeLogin = new PageObject(driver);
		}
		
		@Test
		public void Editar(){
			TelaDeLogin.Open();
			//Logar com sucesso
			TelaDeLogin.Loga("heidy.saar","123456");
			
			//Editar Issue
		    driver.findElement(By.linkText("View Issues")).click();
		    driver.findElement(By.cssSelector("img[alt=\"Edit\"]")).click();
		    driver.findElement(By.name("description")).clear();
		    driver.findElement(By.name("description")).sendKeys("Sistema não está cadastrando cliente alterado.");
		    driver.findElement(By.name("summary")).clear();
		    driver.findElement(By.name("summary")).sendKeys("Bug Teste alterado");
		    driver.findElement(By.cssSelector("input.button")).click();	
		}
				
		@Test
		public void UpdateStatus(){
			TelaDeLogin.Open();
			//Logar com sucesso
			TelaDeLogin.Loga("heidy.saar","123456");
			
			//Update status Issue
		    driver.findElement(By.linkText("View Issues")).click();
		    driver.findElement(By.cssSelector("img[alt=\"Edit\"]")).click();
		    new Select(driver.findElement(By.name("status"))).selectByVisibleText("resolved");
		    driver.findElement(By.cssSelector("input.button")).click();
		}
		
		@Test
		public void Excluir(){
			TelaDeLogin.Open();
			//Logar com sucesso
			TelaDeLogin.Loga("heidy.saar","123456");
			
			//Excluir Issue		  
		    driver.findElement(By.linkText("View Issues")).click();
		    driver.findElement(By.name("bug_arr[]")).click();
		    new Select(driver.findElement(By.name("action"))).selectByVisibleText("Delete");
		    driver.findElement(By.cssSelector("input.button")).click();
		    driver.findElement(By.cssSelector("input.button")).click();
		}		
		
		@After
		public void FecharJanela(){
			driver.quit();	
		}
}	

