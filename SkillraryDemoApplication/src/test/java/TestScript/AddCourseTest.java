package TestScript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;
import GenericLibraries.IconstantPath;

public class AddCourseTest extends BaseClass{
	
	@Test
	public void addCourseTest()
	{
		SoftAssert soft = new SoftAssert();
		home.clickCoursesTab();
		home.clickCoursesListTab();
		soft.assertTrue(course.getPageHeader().contains("Course List"));
		course.clickButton();
		jutil.pause(2000);
		soft.assertEquals(addCourse.getPageHeader(), "Add New Course");
		
		Map<String, String> map = excel.readFromExcel("Sheet1", "Add Course");
		addCourse.setName(map.get("Name"));
		addCourse.selectCategory(web, map.get("category"));
		addCourse.setPrice(map.get("Price"));
		addCourse.uploadPhoto(map.get("Photo"));
		addCourse.addDescription(web, map.get("Description"));
		addCourse.clickSave();
		
		soft.assertTrue(course.getSuccessAlertMessege().contains("Course added successfullly"));
		course.deleteCourse(web, map.get("Name"));
		soft.assertTrue(course.getSuccessAlertMessege().contains("Product deleted successfully"));
		if(course.getSuccessAlertMessege().contains("Product deleted successfully"))
			excel.updateTestStatus("Sheet1", "Add Course", "Pass", IconstantPath.EXCEL_PATH);
		else
			excel.updateTestStatus("Sheet1", "Add Course", "Fail", IconstantPath.EXCEL_PATH);
		
		soft.assertAll();
	}
}
