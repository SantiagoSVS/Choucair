package com.TestSelenium;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.ast.*;
import io.cucumber.java.es.Dado;

public class UtestJoin {

	private WebDriver driver;

	@Before
	@Dado("Ingresando a la web")
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://utest.com/");
	}

	@SuppressWarnings("deprecation")
	@Test
	@Cuando("Registro datos")
	public void UtestPage() throws InterruptedException {

		/* STEP 1 */

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.className("unauthenticated-nav-bar__sign-up")).click();
		driver.findElement(By.id("firstName")).sendKeys("Santiago");
		driver.findElement(By.id("lastName")).sendKeys("Velasquez Sanchez");
		driver.findElement(By.id("email")).sendKeys("pruebatecnica1@hotmail.com");

		WebElement DropdownMES = driver.findElement(By.name("birthMonth"));
		Select selectDropdownMES = new Select(DropdownMES);
		selectDropdownMES.selectByVisibleText("February");

		WebElement DropdownDIA = driver.findElement(By.name("birthDay"));
		Select selectDropdownDIA = new Select(DropdownDIA);
		selectDropdownDIA.selectByValue("number:19");

		WebElement DropdownYear = driver.findElement(By.name("birthYear"));
		Select selectDropdownYear = new Select(DropdownYear);
		selectDropdownYear.selectByValue("number:1995");

		try {
			Thread.sleep(2000); // Espera durante 2 segundos
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//span[normalize-space()='Next: Location']")).click();

		/* STEP 2 */

		try {
			Thread.sleep(2000); // Espera durante 2 segundos
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//a[@aria-label='Next step - select your devices']")).click();

		/* STEP 3 */

		try {
			Thread.sleep(2000); // Espera durante 2 segundos
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//i[normalize-space()='chevron_right']")).click();

		/* STEP 4 */

		driver.findElement(By.id("password")).sendKeys("123456789");
		driver.findElement(By.id("confirmPassword")).sendKeys("123456789");

		try {
			Thread.sleep(2000); // Espera durante 2 segundos
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(
				By.xpath("//span[@class='checkmark signup-consent__checkbox signup-consent__checkbox--highlight']"))
				.click();

		driver.findElement(By.xpath("//span[@ng-class='{error: userForm.termOfUse.$error.required}']")).click();

		driver.findElement(By.xpath("//span[@ng-class='{error: userForm.privacySetting.$error.required}']")).click();
	}

}
