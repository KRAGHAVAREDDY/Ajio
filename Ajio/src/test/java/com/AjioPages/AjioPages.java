package com.AjioPages;

	import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class AjioPages {
		
		WebDriver driver;
		
		@FindBy(xpath="//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/div/input")
		WebElement searchBox;
		
		@FindAll(@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div"))
		List<WebElement> searchresults;
		
		@FindBy(xpath="//*[@id=\"content_wrapper\"]/section/div[4]/section/div[2]/div[1]/div/div/a/div[3]/div[3]/div[1]/span[2]")
		WebElement noresult;
		
		public AjioPages(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
		public WebElement getSearchBox()
		{
	    return searchBox;	
		}
	    
		public List <WebElement> getSearchResult()
		{
	    return searchresults;	
		}
		
		
		public WebElement getNoResult()
		{
	    return noresult;	
		}
	}







