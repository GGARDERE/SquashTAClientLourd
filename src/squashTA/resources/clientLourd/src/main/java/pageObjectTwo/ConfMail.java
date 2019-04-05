package pageObjectTwo;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;
import pageObjectOne.AcceuilThunderBird;

public class ConfMail {
	
	
	@FindBy(xpath="//Button[@Name='Annuler']")
	private WebElement toto;
	
	public WindowsDriver<RemoteWebElement> setup(RemoteWebDriver desktopSession, String remoteURL) throws MalformedURLException {
		
		//recup de la session de la fêntre conf mail
		WebElement fenetreConfMail = desktopSession.findElementByName("Configurer une adresse électronique existante");
		String fenetreConfMailTopLevelWindowHandle = fenetreConfMail.getAttribute("NativeWindowHandle");
		System.out.println(Integer.toHexString(Integer.parseInt(fenetreConfMailTopLevelWindowHandle)));
		fenetreConfMailTopLevelWindowHandle = Integer.toHexString(Integer.parseInt(fenetreConfMailTopLevelWindowHandle));
		 
		DesiredCapabilities apCapabilities3 = new DesiredCapabilities();
		apCapabilities3.setCapability("appTopLevelWindow", fenetreConfMailTopLevelWindowHandle);
		WindowsDriver<RemoteWebElement> fenetreConfMailSession = new WindowsDriver<RemoteWebElement>(new URL (remoteURL), apCapabilities3);
		return fenetreConfMailSession;
	}
//Window[@Name='Configurer une adresse électronique existante']/
	public AcceuilThunderBird clickAnnuler(RemoteWebDriver session) {
	WebDriverWait wait = new WebDriverWait(session, 5);
	WebElement boutonAnnuler = session.findElement(By.xpath("//Button[@Name='Annuler']"));
	wait.until(ExpectedConditions.elementToBeClickable(boutonAnnuler));
	boutonAnnuler.click();
	return PageFactory.initElements(session, AcceuilThunderBird.class);
	}
}
