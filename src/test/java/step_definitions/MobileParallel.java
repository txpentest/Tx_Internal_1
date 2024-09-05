package step_definitions;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobileutil.AmazonAppFunctions;
import utilities.GlobalUtil;
import utilities.LogUtil;

public class MobileParallel {

	String platformName;
	String platformVersion;
	String deviceName;
	String port;
	String URL;

	public AppiumDriverLocalService getService() {
		return service;
	}

	public void setService(AppiumDriverLocalService service) {
		this.service = service;
	}

	public AppiumServiceBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(AppiumServiceBuilder builder) {
		this.builder = builder;
	}

	public DesiredCapabilities getCap() {
		return cap;
	}

	public void setCap(DesiredCapabilities cap) {
		this.cap = cap;
	}

	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;
	private DesiredCapabilities cap;

	@Parameters({ "platformName", "platformVersion", "deviceName", "port", "URL" })
	@Test(priority = 0)
	@Given("^Open the amazon apk file$")
	public void open_the_amazon_apk_file(String platformName, String platformVersion, String deviceName, String port, String URL) throws Throwable {

		int portz = Integer.valueOf(port);

		System.out.println("platformName =" + platformName);
		System.out.println("platformVersion =" + platformVersion);
		System.out.println("deviceName =" + deviceName);
		System.out.println("URL =" + URL);

		System.out.println("Port Number =" + portz);
		String URLL = URL + ":" + portz;

		System.out.println("The Final URL is =" + URLL);

		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a" + URL + " -p" + portz);
		} catch (IOException e) {
			GlobalUtil.errorMsg = e.getMessage();
			LogUtil.htmlFailLog(GlobalUtil.errorMsg);
		}

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		try {
			GlobalUtil.mdriver = new AndroidDriver<MobileElement>(new URL("http://" + URLL + "/wd/hub"), capabilities);
			GlobalUtil.mdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			GlobalUtil.errorMsg = e.getMessage();
			LogUtil.htmlFailLog(GlobalUtil.errorMsg);
		}
	}

	@Test(priority = 1)
	@Given("^click on SKIP SIGN in button$")
	public void click_on_SKIP_SIGN_in_button() throws Throwable {

		try {
			AmazonAppFunctions.skipSignIn();
		} catch (Exception e) {
			GlobalUtil.errorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2)
	@When("^select item by category in the application$")
	public void select_item_by_category_in_the_application() throws Throwable {
		try {
			AmazonAppFunctions.clickShopByCategory();
		} catch (Exception e) {
			GlobalUtil.errorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3)
	@When("^add selected item to cart on the screen$")
	public void add_selected_item_to_cart_on_the_screen() throws Throwable {
		try {
			AmazonAppFunctions.clickFirstCategoryExpandButton();

		} catch (Exception e) {
			GlobalUtil.errorMsg = e.getMessage();
			LogUtil.htmlFailLog(GlobalUtil.errorMsg);
		}

	}

	@Test(priority = 4)
	@Then("^verify selected item is added to cart on screen$")
	public void verify_selected_item_is_added_to_cart_on_screen() throws Throwable {
		try {
			AmazonAppFunctions.selectProduct();
			AmazonAppFunctions.addProductToCart();
			AmazonAppFunctions.verifyItemAddedToCart();

			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("taskkill /F /IM node.exe");
				runtime.exec("taskkill /F /IM cmd.exe");
			} catch (IOException e) {
				GlobalUtil.errorMsg = e.getMessage();
				LogUtil.htmlFailLog(GlobalUtil.errorMsg);
			}
		} catch (Exception e) {
			GlobalUtil.errorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}

	}

}