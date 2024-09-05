package modules;

import java.util.HashMap;

import org.testng.Assert;

import AmazonPages.AccountCreationPage;
import AmazonPages.LoginPage;
import AmazonPages.ProductListPage;
import utilities.KeywordUtil;

public class AmazonRegistration {

	static boolean flag;

	public static void fillInTheMandatoryFields(HashMap<String, String> dataMap) throws Exception {

		KeywordUtil.inputText(AccountCreationPage.username, dataMap.get("Username"), "enter username");
		KeywordUtil.inputText(AccountCreationPage.emailID, dataMap.get("Email"), "Enter email");
		KeywordUtil.inputText(AccountCreationPage.password, dataMap.get("Password"), "Enter password");
		KeywordUtil.inputText(AccountCreationPage.passwordCheck, dataMap.get("Password"), "Repeat password");

	}

	public static void login(HashMap<String, String> dataMap) throws Exception {

		KeywordUtil.inputText(AccountCreationPage.emailID, dataMap.get("Email"), "Enter the username");
		KeywordUtil.click(LoginPage.continueButton, "Click on continue button");
		KeywordUtil.inputText(AccountCreationPage.password, dataMap.get("Password"), "Enter the password");
		KeywordUtil.click(LoginPage.signInButton, "Click on Sign on Button");
	}

	public static void loginWithInvalidEmail(HashMap<String, String> dataMap) throws Exception {

		KeywordUtil.inputText(AccountCreationPage.emailID, dataMap.get("Email"), "Enter the username");
		KeywordUtil.click(LoginPage.continueButton, "Click on continue button");
		Assert.assertFalse(!KeywordUtil.isElementInVisible(KeywordUtil.waitForClickable(LoginPage.passwordFieldErrorMessage), "Password field is not visible As email is invalid"),
				"Password field is not visible As email is invalid");
	}

	public static void searchForAnItem(HashMap<String, String> dataMap) throws Exception {
		KeywordUtil.inputText(ProductListPage.searchText, dataMap.get("SearchText"), "Enter the search text");
		KeywordUtil.executionDelay(1000);
		KeywordUtil.pressEnter(ProductListPage.searchText);
		KeywordUtil.click(ProductListPage.bookName, "Select the Book");
		KeywordUtil.executionDelay(2000);

	}

}
