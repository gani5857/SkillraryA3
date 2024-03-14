package TestScript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;

public class AdduserTest extends BaseClass{
	
	@Test
	public void methodConfig() {
		SoftAssert soft = new SoftAssert();
		home.clickUsersTab();
		soft.assertTrue(users.getPageHeader().contains("Users"));
		users.clickNewButton();
		soft.assertEquals(addUser.getPageHeader(), "Add New User");
		
		Map<String, String> map = excel.readFromExcel("Sheet1", "Add User");
		addUser.setEmail(map.get("Email"));
		addUser.setPwd(map.get("Password"));
		addUser.setFirstName(map.get("FirstName"));
		addUser.setLastName(map.get("Address"));
		addUser.setAddress(map.get("Contact Info"));
		addUser.uploadPhoto(map.get("photo"));
		addUser.clickSave();
		
		soft.assertTrue(users.getSuccessAlertMessege().contains("Success"));
		soft.assertAll();
	}

}
