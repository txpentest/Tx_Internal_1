package pageobjects;

import org.openqa.selenium.By;

public class SFLandingPage {

	public static By appLauncherButton = By.xpath("//*[@class='slds-button slds-show']");
	public static By appSearchField = By.xpath("//input[@class='slds-input']");
	public static By clickSearchedApp = By.xpath("//p[@class='slds-truncate']/b");
	public static By newButton = By.xpath("//a[@title='New']");
	public static By nextButton = By.xpath("//*[text()='Next']//parent::button");
	public static By saveButton = By.xpath("//button[@name='SaveEdit']");
	public static By accountNameField = By.xpath("//*[text()='Account Name']//following-sibling::div//input");
	public static By firstAccountName = By.xpath("//*[@aria-label='Recent Accounts']//li[2]");
	public static By caseNumber = By.xpath("//span[@class='test-id__field-label' and text()='Case Number']/parent::div/following-sibling::div//lightning-formatted-text");
	public static By setUpButton = By.xpath("//li[6]//*[@class='headerTrigger  tooltip-trigger uiTooltip']");
	public static By developerConsoleOption = By.xpath("//*[@id='developer-console-link']");
	public static By queryEditorField = By.xpath("//*[@id='queryEditorText-inputEl']");
	public static By executeQueryButton = By.xpath("//*[@id='queryExecuteButton-btnInnerEl']");
	public static By resutCaseNumber = By.xpath("(//*[contains(@id,'gridview')])[2]//td[1]/div");
	public static By resutIDNumber = By.xpath("(//*[contains(@id,'gridview')])[2]//td[2]/div");
	public static By reportMenuList = By.xpath("(//*[@Title='Reports']//following-sibling::one-app-nav-bar-item-dropdown//div//a)[1]");
	public static By openAllReportsOfAllTime = By.xpath("//*[@class='slds-dropdown__item']//span[text()='Open Cases for All Time']/parent::*");
	public static By searchReportTableButton = By.xpath("//*[@class='slds-button slds-button_icon-border action-bar-action-searchTable reportAction report-action-searchTable']");
	public static By iFrameSearchAllReportdata = By.xpath("//iframe[@title='Report Viewer']");
	public static By searchReportTableField = By.xpath("//*[@class='search-input']");
	public static String caseNumberLinkInReportTable = "//*[@data-id='%s']";
	public static String caseNumberOnCaseDetails = "//span[text()='%s']";
}
