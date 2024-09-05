package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.Buffer.BufferUtilMethodLevel;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.SFLandingPage;
import pageobjects.SFLoginPage;
import utilities.GlobalUtil;
import utilities.KeywordUtil;
import utilities.LogUtil;

public class SFStepDefinitions {

	String base;

	@When("Enter the SF login credentials")
	public void enter_the_sf_login_credentials() {
		KeywordUtil.inputText(SFLoginPage.usernameField, AmazonRegistartion.dataMap.get("Username"), "Entering Username: ");
		KeywordUtil.inputText(SFLoginPage.passwordField, AmazonRegistartion.dataMap.get("Password"), "Entering Password: ");
	}

	@When("Click on SF login button")
	public void click_on_sf_login_button() {
		KeywordUtil.click(SFLoginPage.loginButton, "Clicked login button.");
	}

	@When("Click on app launcher button")
	public void click_on_app_launcher_button() {
		KeywordUtil.click(SFLandingPage.appLauncherButton, "Clicked on app launcher button.");
	}

	@When("Enter {string} to search as app")
	public void enter_to_search_as_app(String string) {
		KeywordUtil.inputText(SFLandingPage.appSearchField, string, "Entering search text: ");
	}

	@When("Click on searched app")
	public void click_on_searched_app() {
		KeywordUtil.click(SFLandingPage.clickSearchedApp, "Clicking selected app name");
	}

	@When("Click on new button")
	public void click_on_new_button() {
		KeywordUtil.click(SFLandingPage.newButton, "Clicked on new button");
	}

	@When("Click on next button")
	public void click_on_next_button() {
		KeywordUtil.click(SFLandingPage.nextButton, "Clicked on next button");
	}

	@When("Click on account name field")
	public void click_on_account_name_field() {
		KeywordUtil.click(SFLandingPage.accountNameField, "Clicked account name field.");
	}

	@When("Click on first recent account name")
	public void click_on_first_recent_account_name() {
		KeywordUtil.click(SFLandingPage.firstAccountName, "Clicked first account name field.");
	}

	@When("Click on save button")
	public void click_on_save_button() {
		KeywordUtil.click(SFLandingPage.saveButton, "Clicked on save button");
	}

	@When("Save newly created case number")
	public void save_newly_created_case_number() {
		BufferUtilMethodLevel.caseNumber = KeywordUtil.getElementText(SFLandingPage.caseNumber);
		LogUtil.infoLog(getClass(), "Case number is: " + BufferUtilMethodLevel.caseNumber);
	}

	@When("Click on setup button")
	public void click_on_setup_button() {
		KeywordUtil.click(SFLandingPage.setUpButton, "Clicked setup button.");
	}

	@When("Click on Developer console option in setup menu")
	public void click_on_developer_console_option_in_setup_menu() {
		KeywordUtil.click(SFLandingPage.developerConsoleOption, "Selected Developer console option.");
	}

	@When("Switch to developer console")
	public void switch_to_developer_console() {
		base = GlobalUtil.getDriver().getWindowHandle();
		KeywordUtil.switchToWindow();
	}

	@When("Clear the query field")
	public void clear_the_query_field() {
		KeywordUtil.clearInput(SFLandingPage.queryEditorField);
	}

	@When("Input the query to using case number")
	public void input_the_query_to_using_case_number() {
		KeywordUtil.inputText(SFLandingPage.queryEditorField, "SELECT CaseNumber,Id FROM Case where CaseNumber ='" + BufferUtilMethodLevel.caseNumber + "'",
				"Entered the desired query");
	}

	@When("Click on execute query button")
	public void click_on_execute_query_button() {
		KeywordUtil.click(SFLandingPage.executeQueryButton, "Clicked execute query button.");
	}

	@When("Check if case number and ID fields are displaying")
	public void check_if_case_number_and_id_fields_are_displaying() {
		if (KeywordUtil.waitForVisible(SFLandingPage.resutCaseNumber) == null) {
			Assert.fail("Case number is not visible.");
		}
		if (KeywordUtil.waitForVisible(SFLandingPage.resutIDNumber) == null) {
			Assert.fail("Case number is not visible.");
		} else {
			BufferUtilMethodLevel.caseIDNumber = KeywordUtil.getElementText(SFLandingPage.resutIDNumber);
			LogUtil.infoLog(getClass(), "Case ID number is: " + BufferUtilMethodLevel.caseIDNumber);
		}
	}

	@When("Switch back to SF Application")
	public void switch_back_to_sf_application() {
		GlobalUtil.getDriver().switchTo().window(base);
	}

	@When("Click on report menu list to display options")
	public void click_on_report_menu_list_to_display_options() {
		try {
			KeywordUtil.click(SFLandingPage.reportMenuList, "Clicked open the report menu list.");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.errorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("Click Open cases of all time link")
	public void click_open_cases_of_all_time_link() {
		try {
			KeywordUtil.clickJS(SFLandingPage.openAllReportsOfAllTime, "Clicked on open cases of all times.");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.errorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("Click on search report table field")
	public void click_on_search_report_table_field() {
		try {
			GlobalUtil.getDriver().navigate().refresh();
			GlobalUtil.getDriver().switchTo().frame(KeywordUtil.waitForPresent(SFLandingPage.iFrameSearchAllReportdata));
			KeywordUtil.click(SFLandingPage.searchReportTableButton, "Clicked search report table button.");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.errorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@When("Enter case number in the search report table field")
	public void enter_case_number_in_the_search_report_table_field() {
		KeywordUtil.inputText(SFLandingPage.searchReportTableField, BufferUtilMethodLevel.caseNumber, "Inserted case number to serach the report table.");
	}

	@When("Click on case number displaying in the table")
	public void click_on_case_number_displaying_in_the_table() {
		KeywordUtil.click(By.xpath(String.format(SFLandingPage.caseNumberLinkInReportTable, BufferUtilMethodLevel.caseIDNumber)), "Clicked on case number to open details.");
	}

	@Then("Validate the created case details")
	public void validate_the_created_case_details() {
		GlobalUtil.getDriver().switchTo().defaultContent();
		if (KeywordUtil.waitForVisible(By.xpath(String.format(SFLandingPage.caseNumberOnCaseDetails, BufferUtilMethodLevel.caseNumber))) == null) {
			Assert.fail("Case number is not visible.");
		}
	}
}
