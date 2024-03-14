package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage {
	@FindBy(xpath = "//b[text()='Add New User']")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//input[@id='email' and @required]")
	private WebElement emailTF;
	
	@FindBy(xpath = "//input[@id='password' and @required]")
	private WebElement pwdTF;
	
	@FindBy(xpath = "//input[@id='firstname' and @required]")
	private WebElement firstNameTF;
	
	@FindBy(xpath = "//input[@id='lastname' and @required]")
	private WebElement lastNameTF;
	
	@FindBy(id = "address")
	private WebElement addressTextArea;
	
	@FindBy(id= "contact")
	private WebElement contactTF;
	
	@FindBy(xpath= "(//input[@id='photo'])[2]")
	private WebElement uploadPhoto;
	
	@FindBy(name="add")
	private WebElement saveButton;
	
	//INtialization
	public AddUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void setEmail(String email)
	{
		emailTF.sendKeys(email);
	}
	
	public void setPwd(String pwd)
	{
		pwdTF.sendKeys(pwd);
	}
	public void setFirstName(String firstname)
	{
		firstNameTF.sendKeys(firstname);
	}
	public void setLastName(String lastname)
	{
		lastNameTF.sendKeys(lastname);
	}
	public void setAddress(String address)
	{
		addressTextArea.sendKeys(address);
	}
	public void setContact(String contact) {
		contactTF.sendKeys(contact);
	}
	public void uploadPhoto(String photo) {
		uploadPhoto.sendKeys(photo);
	}
	public void clickSave()
	{
		saveButton.click();
	}

}
