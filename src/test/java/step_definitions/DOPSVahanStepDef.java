package step_definitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExtentUtil;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

public class DOPSVahanStepDef {

	@When("^Enter valid credentials$")
	public void enter_valid_credentials() throws Throwable {
		if (KeywordUtil.waitForPresent(By.xpath("//*[text()='We’re building your app']")).isDisplayed()) {
			if (KeywordUtil.waitForVisible(By.xpath("//*[contains(@class,'login-heading')]")) != null) {
				ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor("Login screen is visible now."));
			} else {
				GlobalUtil.getDriver().navigate().refresh();
			}
		}
		if (KeywordUtil.waitForVisible(By.xpath("//*[contains(@class,'login-heading')]")) != null) {
			KeywordUtil.inputText(By.id("username"), AmazonRegistartion.dataMap.get("Username").replace("_", ""), "Entering username");
			KeywordUtil.inputText(By.id("password"), AmazonRegistartion.dataMap.get("Password"), "Entering password");
		} else {
			GlobalUtil.errorMsg = "Page navigation failed.";
			Assert.fail(GlobalUtil.errorMsg);
		}

	}

	@When("^Click on login button to initiate login$")
	public void click_on_login_button_to_initiate_login() throws Throwable {
		KeywordUtil.click(By.xpath("//button[contains(@class,'btn-primary')]"), "Clicked on login button.");
		KeywordUtil.waitForVisible(By.xpath("//button[contains(@class,'profile-btn')]"));
	}

	@Then("^Verify Login status$")
	public void verify_Login_status() throws Throwable {
		KeywordUtil.waitForVisible(By.xpath("//button[contains(@class,'profile-btn')]"));
		Assert.assertEquals(KeywordUtil.getCurrentUrl(), "https://cconboarduat.aubankuat.in/AU_DOPS/#/main/1605248757783473/dashboard");
	}
}
