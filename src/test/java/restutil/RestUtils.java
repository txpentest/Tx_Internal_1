package restutil;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ExtentUtil;
import utilities.HTMLReportUtil;

public class RestUtils {

	// Global Setup Variables
	public static String path;
	public static String jsonPathTerm;
	static RequestSpecification rs;
	// public static

	// Sets Base URI
	public static void setBaseURI(String baseURI, String logStep) {
		RestAssured.baseURI = baseURI;
		ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor(logStep));
	}

	// Sets base path
	public static void setBasePath(String basePathTerm, String logStep) {
		RestAssured.basePath = basePathTerm;
		ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor(logStep));
	}

	// Reset Base URI (after test)
	public static void resetBaseURI(String logStep) {
		RestAssured.baseURI = null;
		ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor(logStep));
	}

	// Reset base path
	public static void resetBasePath(String logStep) {
		RestAssured.basePath = null;
		ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor(logStep));
	}

	// Sets ContentType
	public static void setContentBodyType(ContentType Type, String body, String logStep) {
		rs = RestAssured.given().contentType(Type).body(body);
		ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor(logStep));
	}

	public static void setContentBodyType(ContentType Type, String accessToken, String body, String logStep) {
		rs = RestAssured.given().contentType(Type).header("Authorization", accessToken).body(body).log().all();
		ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor(logStep));
	}

	// Returns response
	public static Response getResponse(String logStep) {
		ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor(logStep));
		return rs.when().get();
	}

	// Returns response
	public static Response PostResponse(String type, String logStep) {
		ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor(logStep));
		return rs.when().post("");
	}

	// Returns JsonPath object
	public static JsonPath getJsonPath(Response res, String logStep) {
		String json = res.asString();
		ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor(logStep));
		return new JsonPath(json);
	}

	// Verify the http response status returned. Check Status Code is 200?
	public static void checkStatusIs200(Response res) {
		Assert.assertEquals(res.getStatusCode(), 200, "Status Check Failed!");
	}

	public static Object getValueFromJson(Response res, String path, String logStep) {
		String json = res.asString();
		ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor(logStep));
		return new JsonPath(json).getString(path);

	}
}