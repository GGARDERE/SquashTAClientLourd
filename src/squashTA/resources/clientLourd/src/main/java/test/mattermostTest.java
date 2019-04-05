package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import utils.SessionFactory;

public class mattermostTest {
	private static final String REMOTE_URL ="http://127.0.0.1:4723";
	
	private static final SessionFactory SESSION_HELPER = new SessionFactory(REMOTE_URL);
	
	private RemoteWebDriver desktopSession = null;
	@Test	
	public void run() throws MalformedURLException, InterruptedException {

	DesiredCapabilities appCapabilities = new DesiredCapabilities();
	appCapabilities.setCapability("app", "Root");
	desktopSession = new WindowsDriver<RemoteWebElement>(new URL(REMOTE_URL), appCapabilities);
	desktopSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	Assert.assertNotNull(desktopSession);
	desktopSession.getKeyboard().sendKeys(Keys.META + "s" + Keys.META);
	String tata = desktopSession.getWindowHandle();
	System.out.println(tata);
	WebElement cortanaWindow = desktopSession.findElementByName("Recherche");
	WindowsDriver<RemoteWebElement> cortanaSession = SESSION_HELPER.getSession(cortanaWindow);
	WebElement toto =cortanaSession.findElementByAccessibilityId("SearchTextBox");
	toto.sendKeys("Mattermost");
	cortanaSession.getKeyboard().pressKey(Keys.ENTER );
	Thread.sleep(2000);
	WebElement mattermostWindow = desktopSession.findElementByXPath("//Window[contains(@Name,'Squash Mattermost')]");
			//findElementByName("* bfranchet - Squash Mattermost");
			//findElementByXPath("//Window[contains(@Name,'Squash Mattermost')]");
	WindowsDriver<RemoteWebElement> mattermostSession = SESSION_HELPER.getSession(mattermostWindow);
	
	WebElement fgautierContact = mattermostSession.findElementByXPath("//Button[contains(@Name,'Icon fgautier')]");
			//findElementByXPath("//Button[contains(@Name,'Online Icon fgautier')]");
			//findElementByName("Online Icon fgautier");
	fgautierContact.click();
	
	WebElement champMessage = mattermostSession.findElementByName("Write a message...");
	champMessage.click();
	champMessage.sendKeys("https://youtu.be/dQw4w9WgXcQ");
	//champMessage.sendKeys("https://youtu.be/oavMtUWDBTM");
	mattermostSession.getKeyboard().pressKey(Keys.ENTER);
	
	
	
	}
}
