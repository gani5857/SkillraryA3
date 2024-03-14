package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[text()=' Home']")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement usersTab;
	
	@FindBy(xpath = "//a[text()=' Courses']")
	private WebElement coursesTab;
	
	@FindBy(xpath = "//span[text()=' Course List']")
	private WebElement courseListLink;
	
	@FindBy(xpath = "//a[text()=' Category']")
	private WebElement categoryLink;
	
	@FindBy(xpath = "//span[text()='SkillRary Admin']")
	private WebElement adminIcon;
	
	@FindBy(xpath = "//a[text()='Sign out']")
	private WebElement signoutLink;
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//Utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	
	public void clickUsersTab()
	{
		usersTab.click();
	}
	
	public void clickCoursesTab()
	{
		coursesTab.click();
	}
	
	public void clickCoursesListTab() {
		courseListLink.click();
		
	}
	
	public void clickCategoryLink() {
		categoryLink.click();
		
	}
	
	public void signOutOfApp() {
		adminIcon.click();
		signoutLink.click();
	}

}
