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

public class SASelfStepDef {

	@When("^Enter valid contact number$")
	public void enter_valid_contact_number() throws Throwable {
		KeywordUtil.inputText(By.xpath("//section[@class='first-section']//div[contains(@class,'align-items-center')]//input[@placeholder='Enter Aadhaar linked mobile number']"),
				AmazonRegistartion.dataMap.get("SearchText").replace("_", ""), "Entering mobile number");
	}

	@When("^Click on verify button$")
	public void click_on_verify_button() throws Throwable {
		KeywordUtil.click(By.xpath("//section[@class='first-section']//div[contains(@class,'align-items-center')]//button[@class='verifyEnabled']"), "Clicked on verify button.");
	}

	@Then("^Verify if the OTP screen displays$")
	public void verify_if_the_OTP_screen_displays() throws Throwable {
		if (KeywordUtil.waitForVisible(By.xpath("//*[text()=' Mobile number verification']")) != null) {
			ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor("OTP screen is displaying."));
		} else {
			GlobalUtil.errorMsg = "OTP screen is not displaying.";
			Assert.fail(GlobalUtil.errorMsg);
			ExtentUtil.logger.get().log(Status.FAIL, HTMLReportUtil.failStringRedColor("OTP screen is not displaying.") + GlobalUtil.errorMsg);
		}
	}
}
