package restutil;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.CreateUser;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.LogUtil;

public class Payloads {

	public static HashMap<String, String> getDatamap() {
		return datamap;
	}

	public static HashMap<String, String> datamap = null;

	public static String createUser(String testData) {

		datamap = ExcelDataUtil.getTestDataWithTestCaseID("RestAPITestData", testData);

		CreateUser user = new CreateUser();
		user.setName(datamap.get("name"));
		user.setGender(datamap.get("gender"));
		user.setEmail(datamap.get("email"));
		user.setStatus(datamap.get("status"));

		return converJavaObjectToJsonString(user);

	}

	public static String converJavaObjectToJsonString(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			GlobalUtil.errorMsg = e.getMessage();
			LogUtil.htmlFailLog(GlobalUtil.errorMsg);
		}
		return jsonString;
	}

}
