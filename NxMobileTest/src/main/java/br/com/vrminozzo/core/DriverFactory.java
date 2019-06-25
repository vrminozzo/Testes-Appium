package br.com.vrminozzo.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	

		public static AndroidDriver<MobileElement> driver;

		
		public static AndroidDriver<MobileElement> getDriver(){
			if (driver == null) {
				createDriver();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return driver;
			
		}
		
		private static void createDriver()  {
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("deviceName", "emulator-5554");
			desiredCapabilities.setCapability("automationName", "uiautomator2");
			desiredCapabilities.setCapability(MobileCapabilityType.APP,
					"C:\\Users\\vr_mi\\eclipse-workspace\\NxMobileTest\\src\\main\\resources\\app-debug.apk");
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			

		}
		
		public static void killDriver() {
			if(driver != null) {
				driver.quit();
				driver = null;
			}
		}
	}
