package AmazonPages;

import org.openqa.selenium.By;

public class LoginPage {

	public static By createAccount = By.xpath("//a[@id='createAccountSubmit']");
	public static By continueButton = By.xpath("//input[@id='continue']");
	public static By signInButton = By.xpath("//input[@id='signInSubmit']");
	public static By passwordFieldErrorMessage = By.xpath("//*[text()='There was a problem']");
}
