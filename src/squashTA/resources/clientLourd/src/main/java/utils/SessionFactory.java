package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.windows.WindowsDriver;

public class SessionFactory {

	private final Map<WebElement, WindowsDriver<RemoteWebElement>> windowsSession = new HashMap<WebElement, WindowsDriver<RemoteWebElement>>();
	
	private final String remoteURL; 
	
	public SessionFactory(String remoteURL) {
		this.remoteURL=remoteURL;
	}
	
	public WindowsDriver<RemoteWebElement> getSession(WebElement window) throws MalformedURLException {
		if (!windowsSession.containsKey(window)) {
			String windowTopLevelWindowHandle = window.getAttribute("NativeWindowHandle");
			windowTopLevelWindowHandle = Integer.toHexString(Integer.parseInt(windowTopLevelWindowHandle));

			DesiredCapabilities apCapabilities3 = new DesiredCapabilities();
			apCapabilities3.setCapability("appTopLevelWindow", windowTopLevelWindowHandle);
			WindowsDriver<RemoteWebElement> windowSession = new WindowsDriver<RemoteWebElement>(
					new URL(remoteURL), apCapabilities3);
			windowsSession.put(window, windowSession);
		}
		return windowsSession.get(window);
	}
}
