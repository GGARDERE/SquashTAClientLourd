package test;

import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProNoteTest{
	
	private static RemoteWebDriver Session;
	private static WebElement tab;
	@Before
	public void setup() {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "C:\\Program Files\\Index Education\\Pronote 2018\\Réseau\\Client PRONOTE.exe");
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
	
	public void run (){
		WebDriverWait wait = new WebDriverWait(Session, 10);
	WebElement toto = Session.findElementByName("Chercher mon établissement ...");
	wait.until(ExpectedConditions.elementToBeClickable(toto));
	toto.click();
	}
	
	
}
