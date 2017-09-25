package pac1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CountLink {
	WebDriver driver;
	@BeforeTest
	public void OpenBrowser(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	@AfterTest
	public void CloseBrowser(){
		driver.quit();
	}
	@Test
	public void Link_Count() throws IOException{
		driver.get("file:///C:/WebSite/SuperTech.html");
	
		List<WebElement>Link=driver.findElements(By.tagName("a"));
		
		System.out.println("Totel link are :"+Link.size());
		
		File file=new File ("E:\\Test\\Totel_link.txt");
		
		for(int i=0; i<Link.size(); i=i+1){
			System.out.println(i+"."+Link.get(i).getText());
			BufferedWriter bw=new BufferedWriter(new FileWriter(file));
			bw.write("Totel links are :"+Link.size());
			bw.newLine();
			bw.write(i+"."+Link.get(i).getText());
			bw.newLine();
			bw.flush();
		}
		
	}
	

}
