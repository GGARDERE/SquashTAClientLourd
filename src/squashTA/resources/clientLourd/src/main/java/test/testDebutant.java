package test;

import java.net.MalformedURLException;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.RegEx;

import org.apache.tools.ant.filters.TokenFilter.ContainsString;
import org.apache.tools.ant.types.RegularExpression;
import org.apache.tools.ant.util.regexp.Regexp;
import org.apache.tools.ant.util.regexp.RegexpFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class testDebutant {
private WindowsDriver<RemoteWebElement> desktopSession =null;
private WindowsElement toto = null;
	
@Test	
	public void run() throws MalformedURLException, InterruptedException {
	DesiredCapabilities appCapabilities = new DesiredCapabilities();
	appCapabilities.setCapability("app", "Root");
	desktopSession = new WindowsDriver<RemoteWebElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
	desktopSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	Assert.assertNotNull(desktopSession);
	//desktopSession.getKeyboard().pressKey(Keys.COMMAND + "a" + Keys.COMMAND );
	desktopSession.getKeyboard().sendKeys(Keys.META + "s" + Keys.META);
	String tata = desktopSession.getWindowHandle();
	System.out.println(tata);
	
	
	WebElement cortanaWindow = desktopSession.findElementByName("Recherche");
	String cortanaTopLevelWindowHandle = cortanaWindow.getAttribute("NativeWindowHandle");
	System.out.println(Integer.toHexString(Integer.parseInt(cortanaTopLevelWindowHandle)));
	cortanaTopLevelWindowHandle = Integer.toHexString(Integer.parseInt(cortanaTopLevelWindowHandle));
	 
	DesiredCapabilities apCapabilities2 = new DesiredCapabilities();
	apCapabilities2.setCapability("appTopLevelWindow", cortanaTopLevelWindowHandle);
	WindowsDriver<RemoteWebElement> cortanaSession = new WindowsDriver<RemoteWebElement>(new URL ("http://127.0.0.1:4723"), apCapabilities2);
	
	WebElement toto =cortanaSession.findElementByAccessibilityId("SearchTextBox");
	toto.sendKeys("Thunderbird");
	cortanaSession.getKeyboard().pressKey(Keys.ENTER );
	
	//recup de la session de la fêntre conf mail
	WebElement fenetreConfMail = desktopSession.findElementByName("Configurer une adresse électronique existante");
	String fenetreConfMailTopLevelWindowHandle = fenetreConfMail.getAttribute("NativeWindowHandle");
	System.out.println(Integer.toHexString(Integer.parseInt(fenetreConfMailTopLevelWindowHandle)));
	fenetreConfMailTopLevelWindowHandle = Integer.toHexString(Integer.parseInt(fenetreConfMailTopLevelWindowHandle));
	 
	DesiredCapabilities apCapabilities3 = new DesiredCapabilities();
	apCapabilities3.setCapability("appTopLevelWindow", fenetreConfMailTopLevelWindowHandle);
	WindowsDriver<RemoteWebElement> fenetreConfMailSession = new WindowsDriver<RemoteWebElement>(new URL ("http://127.0.0.1:4723"), apCapabilities3);
	
	WebElement bontonAnnuler = fenetreConfMailSession.findElement(By.name("Annuler"));
	bontonAnnuler.click();
	
	//recup de la fêntre thunderBird
	WebElement fenetreThunderBird = desktopSession.findElementByXPath("//Window[contains(@Name,'Mozilla Thunderbird')]");
			//findElementByName(".{0,}Mozilla Thunderbird$");
	String fenetreThunderBirdTopLevelWindowHandle = fenetreThunderBird.getAttribute("NativeWindowHandle");
	System.out.println(Integer.toHexString(Integer.parseInt(fenetreThunderBirdTopLevelWindowHandle)));
	fenetreThunderBirdTopLevelWindowHandle = Integer.toHexString(Integer.parseInt(fenetreThunderBirdTopLevelWindowHandle));
	 
	DesiredCapabilities apCapabilities4 = new DesiredCapabilities();
	apCapabilities4.setCapability("appTopLevelWindow", fenetreThunderBirdTopLevelWindowHandle);
	WindowsDriver<RemoteWebElement> fenetreThunderBirdSession = new WindowsDriver<RemoteWebElement>(new URL ("http://127.0.0.1:4723"), apCapabilities4);
	
	WebElement bontonAgenda = fenetreThunderBirdSession.findElement(By.name("Aller à l’onglet d’agenda"));
	bontonAgenda.click();
	}
}
