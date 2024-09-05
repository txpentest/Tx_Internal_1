package step_definitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utilities.KeywordUtil;

public class SkyNewsStepDef {

	@And("^Navigate to \"([^\"]*)\" page$")
	public void navigate_to_page(String arg1) throws Throwable {
		KeywordUtil.click(By.xpath("//*[@class='menu_links_main']//*[@title='أخبار']"), "Clicked on main menu header: " + arg1);
		KeywordUtil.clickDesiredOptionInLIst(By.xpath("//*[@class='menu_links_secondary sub_nav_item_expanded']//span"), "آخر الأخبار");
	}

	@Then("^Validate the latest news page navigation$")
	public void validate_the_latest_news_page_navigation() throws Throwable {
		Assert.assertEquals(KeywordUtil.getCurrentUrl(), "https://www.skynewsarabia.com/latest-news-%D8%A3%D8%AD%D8%AF%D8%AB-%D8%A7%D9%84%D8%A3%D8%AE%D8%A8%D8%A7%D8%B1");
	}
}
