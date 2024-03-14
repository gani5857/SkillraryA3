package TestScript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;
import GenericLibraries.IconstantPath;

public class AddCategoryTest extends BaseClass{
	
	@Test
	public void addCateogoryTest() {
		
		SoftAssert soft = new SoftAssert();
		home.clickCoursesTab();
		home.clickCategoryLink();
		soft.assertTrue(category.getPageHeader().contains("Category"));
		category.clickNewButton();
		jutil.pause(2000);
		soft.assertEquals(addCategory.getPageHeader(), "Add New Category");
		
		Map<String, String> map = excel.readFromExcel("Sheet1", "Add Category");
		addCategory.setName(map.get("Name"));
		addCategory.clickSave();
		
		soft.assertTrue(course.getSuccessAlertMessege().contains("Category added successfully"));
		course.deleteCourse(web, map.get("Name"));
		soft.assertTrue(course.getSuccessAlertMessege().contains("Category deleted successfully"));
		if(course.getSuccessAlertMessege().contains("Category deleted successfully"))
			excel.updateTestStatus("Sheet1", "Add Category", "Pass", IconstantPath.EXCEL_PATH);
		else
			excel.updateTestStatus("Sheet1", "Add Category", "Fail", IconstantPath.EXCEL_PATH);
			
		soft.assertAll();
	}

}
