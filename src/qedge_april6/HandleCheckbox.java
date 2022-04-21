package qedge_april6;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckbox {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://itera-qa.azurewebsites.net/home/automation");
	    //select specific checkbox
	    driver.findElement(By.xpath("//input[@id='monday']"));
	    //select all the checkboxes
	    List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type ='checkbox' and contains(@id,day)]"));
	    System.out.println("no of checkboxes are"+ checkboxes.size());
	    //check all checkboxes
	    for(WebElement eachbox:checkboxes)
	    {
	    	eachbox.click();
	    }
	    //select multiple checkboxes by chice( monday and sunday)
	    for(WebElement eachbox:checkboxes)
	    {
	    	String checkboxname=eachbox.getAttribute("id");
	    	if(checkboxname.equalsIgnoreCase("monday") || checkboxname.equalsIgnoreCase("sunday"))
	    	{
	    		eachbox.click();
	    	}
	    }
	    //select last 2 checkboxes,total no cgeckboxes-2=starting index to be counted
	    int totalcheckboxes=checkboxes.size();
	    for(int i=totalcheckboxes-2;i<totalcheckboxes;i++)
	    {
	    	checkboxes.get(i).click();
	    }
	    //select first 3 checkboxes
	    for(int i=0;i<totalcheckboxes;i++)
	    {
	    	if(i<3)
	    	{
	    		checkboxes.get(i).click();
	    	}
	    }
	    
	    

	}

}
