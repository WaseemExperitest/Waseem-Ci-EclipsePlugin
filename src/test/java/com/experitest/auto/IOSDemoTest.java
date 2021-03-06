package com.experitest.auto;

import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileBrowserType;

public class IOSDemoTest extends BaseTest {
	protected IOSDriver<IOSElement> driver = null;

	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception {
		init(deviceQuery);

		// Init application / device capabilities
		dc.setCapability("testName", "IOSDemoTest");
		dc.setBrowserName(MobileBrowserType.SAFARI);
		driver = new IOSDriver<>(new URL(getProperty("url", cloudProperties) + "/wd/hub"), dc);
	}

	@Test
	public void test() {
		// Enter the test code
		driver.get("ktm.com");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
