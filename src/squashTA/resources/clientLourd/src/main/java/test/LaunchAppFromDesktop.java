package test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.windows.WindowsDriver;
import pageObjectOne.AcceuilThunderBird;
import pageObjectTwo.ConfMail;

public class LaunchAppFromDesktop {
	
	
	private RemoteWebDriver session = null;
	private WebElement tab;
	
	@Test
	public void run() throws MalformedURLException, InterruptedException {
		
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "Root");
			//C:\\Program Files\\Index Education\\Pronote 2018\\Réseau\\Client PRONOTE.exe
			session = new RemoteWebDriver(new URL("http://127.0.0.1:4723"), capabilities);
			session.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Assert.assertNotNull(session);
			//Session.getKeyboard().pressKey(Keys.COMMAND + "a" + Keys.COMMAND );
//			tab = Session.findElementByXPath("//*[.='Taper ici pour recherche']");
//			tab.click();
//			tab.sendKeys("Mozilla Thunderbird");
//			WebElement CortanaWindow = Session.findElementByName("Cortana");
//			String CortanaTopLevelWindowHandle = CortanaWindow.getAttribute("NativeWindowHandle");
			WebElement toto = session.findElementByName("Taper ici pour rechercher");
			toto.click();
			WebElement ZoneDeRecherche = session.findElementByName("Zone de recherche");
			ZoneDeRecherche.sendKeys("Mozilla Thunderbird");
			
		
			
			//Session.getKeyboard().pressKey("A");
//			Session.getKeyboard().sendKeys("Thunderbird");
			session.getKeyboard().pressKey(Keys.ENTER );
			
			
			//Session.findElementByName("Cortana").sendKeys(Keys.META+ "S" + Keys.META);
//			Thread.sleep(5000);

			ConfMail confMail = PageFactory.initElements(session, ConfMail.class);
			AcceuilThunderBird acceuilTB = confMail.clickAnnuler(session);
//			WebDriverWait wait = new WebDriverWait(Session, 5);
//			WebElement boutonAnnuler = Session.findElementByXPath("//Window[@Name='Configurer une adresse électronique existante']/Button[@Name='Annuler']");
//			wait.until(ExpectedConditions.elementToBeClickable(boutonAnnuler));
//			boutonAnnuler.click();
//			Thread.sleep(5000);
			//AcceuilThunderBird acceuilTB = PageFactory.initElements(Session, AcceuilThunderBird.class);
			acceuilTB.ouvirOngletCallendrier(session);
			//WebElement boutonAllerCallendrier = wait.until(ExpectedConditions.elementToBeClickable(By.name("Aller à l’onglet d’agenda")));
			//boutonAllerCallendrier.click();
			
			Thread.sleep(5000);
			acceuilTB.ouvirOngletTaches(session);
			//WebElement boutonAllerTaches = wait.until(ExpectedConditions.elementToBeClickable(By.name("Aller à l’onglet des tâches")));
			//boutonAllerTaches.click();
			
			
			
			
			
			
			//DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability("app", "root");
			//Session = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
			//Session.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			//Assert.assertNotNull(Session);
			//Session.getKeyboard().pressKey("a");
			//Session.getKeyboard().sendKeys(Keys.META + "s" + Keys.META);

//			WebElement CortanaWindow = Session.findElementByName("Cortana");
//			String CortanaTopLevelWindowHandle = CortanaWindow.getAttribute("NativeWindowHandle");
//			CortanaTopLevelWindowHandle = (int.Parse(CortanaTopLevelWindowHandle)).ToString("x"); // Convert to Hex
//
//			// Create session by attaching to Cortana top level window
//			DesiredCapabilities appCapabilities = new DesiredCapabilities();
//			appCapabilities.setCapability("appTopLevelWindow", CortanaTopLevelWindowHandle);
//			AppiumDriver CortanaSession = new AppiumDriver(new URL("http://127.0.0.1:4723"), appCapabilities);
//
//			// Use the session to control Cortana
//			CortanaSession.findElementByAccessibilityId("SearchTextBox").SendKeys("add");
		}
	
	
}

