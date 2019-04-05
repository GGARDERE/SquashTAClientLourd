package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.windows.WindowsDriver;
import utils.SessionFactory;

public class debutantPageObject {
	
	private static final String REMOTE_URL ="http://127.0.0.1:4723";
	
	private static final SessionFactory SESSION_HELPER = new SessionFactory(REMOTE_URL);
	
	private RemoteWebDriver desktopSession = null;
	
	@Before
	public void setup() throws MalformedURLException {
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
		toto.sendKeys("Thunderbird");
		cortanaSession.getKeyboard().pressKey(Keys.ENTER );
	
		WindowsDriver<RemoteWebElement> cortanaSessionBis = SESSION_HELPER.getSession(cortanaWindow);
		}
	
	@Test
	public void test1() throws MalformedURLException {
			
	}
}
