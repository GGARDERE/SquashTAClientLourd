package pageObjectOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageThunderBird {


@FindBy(name="Aller à l’onglet d’agenda")
private WebElement boutonOngletAgenda;

@FindBy(name="Aller à l’onglet des tâches")
private WebElement boutonOngletTaches;




public void ouvirOngletCallendrier (RemoteWebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, 5);
	WebElement boutonAllerCallendrier = wait.until(ExpectedConditions.elementToBeClickable(By.name("Aller à l’onglet d’agenda")));
	boutonAllerCallendrier.click();
	
}
public void ouvirOngletTaches (RemoteWebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, 5);
WebElement boutonAllerTaches = wait.until(ExpectedConditions.elementToBeClickable(By.name("Aller à l’onglet des tâches")));
boutonAllerTaches.click();
}
}
