package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	PomLogin Log;
	public LoginTest() {
		super();
	}
		
	@BeforeMethod
	public void initsetup() {
		initiate();
		screenshots("Login");
	 Log=new PomLogin();	
	}
		
	@Test(priority=1)
	public void Title() throws InterruptedException {
		String actual=Log.verify();
		Assert.assertEquals(actual,"OrangeHRM");
		System.out.println("title is : " + actual);
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] Details(){
		Object result[][]=ExcelSheet.readdata("Sheet1");
		return result;
	}
	
	@Test(priority=2,dataProvider="Details")
	public void Login(String name,String password) throws InterruptedException  {

		System.out.println("Inside Login");
		Thread.sleep(3000);
		Log.typeusername(name);
		System.out.println("Username entered");
		Thread.sleep(3000);
		Log.typepassword(password);
		System.out.println("Password entered");
		Thread.sleep(3000);
		Log.clickbtn();
	}
		
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
	
	
	
	
}
