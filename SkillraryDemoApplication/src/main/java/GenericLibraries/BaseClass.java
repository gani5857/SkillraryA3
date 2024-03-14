package GenericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import objectRepo.AddNewCategoryPage;
import objectRepo.AddNewCoursePage;
import objectRepo.AddNewUserPage;
import objectRepo.CategoryPage;
import objectRepo.CourseListPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.UsersPage;

public class BaseClass {
	//@BeforeSuite
		//@BeforeTest
		
		protected PropertiesUtility property;
		protected ExcelUtillity excel;
		protected JavaUtility jutil;
		protected WebDriverUtility web;
		protected WebDriver driver;
		
		public static WebDriver sdriver;
		public static JavaUtility sjutil;
		
		protected LoginPage login;
		protected HomePage home;
		protected UsersPage users;
		protected CourseListPage course;
		protected CategoryPage category;
		protected AddNewUserPage addUser;
		protected AddNewCoursePage addCourse;
		protected AddNewCategoryPage addCategory;
		
		
		@BeforeClass
		public void classConfig() {
			property = new PropertiesUtility();
			excel = new ExcelUtillity();
			jutil = new JavaUtility();
			web = new WebDriverUtility();
			
			property.propertiesInit(IconstantPath.PROPERTIES_PATH);
			driver = web.launchAndMAximizeBrowser(property.readFromProperties("browser"));
			web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
			
			sdriver = driver;
			sjutil = jutil;
			
		}
		@BeforeMethod
		public void methodConfig() {
			login = new LoginPage(driver);
			home = new HomePage(driver);
			users = new UsersPage(driver);
			course = new CourseListPage(driver);
			category = new CategoryPage(driver);
			addUser = new AddNewUserPage(driver);
			addCategory = new AddNewCategoryPage(driver);
			addCourse = new AddNewCoursePage(driver);
			
			excel.excelInit(IconstantPath.EXCEL_PATH);
			web.navigateToApp(property.readFromProperties("url"));
			Assert.assertEquals(login.getPageHeader(), "Login");
			
			login.loginToApp(property.readFromProperties("username"), property.readFromProperties("password"));
			
			Assert.assertEquals(home.getPageHeader(),"Home");
				
		}
		@AfterMethod
		public void methodTearDown() {
			home.signOutOfApp();;
			excel.closeExcel();
		}
		
		@AfterClass
		public void classTearDown() {
			web.quitAllWIndows();

}
}
