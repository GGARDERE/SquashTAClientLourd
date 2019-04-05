package test;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThunderBird {
	private static RemoteWebDriver Session;
	private static WebElement tab;
	
	@Before
	public void setup() {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "C:\\Program Files (x86)\\Mozilla Thunderbird\\thunderbird.exe");
			Session = new RemoteWebDriver(new URL("http://127.0.0.1:4723"), capabilities);
			Session.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Assert.assertNotNull(Session);

		}catch(Exception e){
			e.printStackTrace();
		} finally {
		}
	}
	private static WebElement findByAttribute(RemoteWebDriver session, String attribute, String value) {
		return session.findElementByXPath("//*[@"+attribute+"=\"" + value +"\"]");
	}
    private static WebElement findByAutomationId(RemoteWebDriver session, String automationId) {
    	return session.findElementByXPath("//*[@AutomationId=\"" + automationId +"\"]");
    }
	@Test
	
	public void run () throws InterruptedException{
	Set<String> test = Session.getWindowHandles();
	WebDriverWait wait = new WebDriverWait(Session, 10);
	Thread.sleep(5000);
	WebElement boutonAnnuler = Session.findElementByXPath("//Window[@Name='Configurer une adresse électronique existante']/Button[@Name='Annuler']");
	wait.until(ExpectedConditions.elementToBeClickable(boutonAnnuler));
	boutonAnnuler.click();
	
	
	WebElement boutonAllerCallendrier = wait.until(ExpectedConditions.elementToBeClickable(By.name("Aller à l’onglet d’agenda")));
	boutonAllerCallendrier.click();
	
	}
	
}
