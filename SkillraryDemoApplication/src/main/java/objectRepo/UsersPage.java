package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	
	@FindBy(xpath = "//h1[normalize-space(text())='Users]")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;
	
	//Initialization
	public UsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	
	public void clickNewButton()
	{
		newButton.click();
	}
	public String getSuccessAlertMessege(WebElement successAlert)

	{
		return successAlert.getText();
	}

	public String getSuccessAlertMessege() {
		// TODO Auto-generated method stub
		return null;
	}
}
