
package com.Ajiotest;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AjioPages.AjioPages;
import com.Ajiobase.BaseTest;
import com.Excelutilities.ExcelUtility;


	public class TestCase extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void Ajio(String inp) throws InterruptedException
	{
	AjioPages pg= new AjioPages(driver);
	pg.getSearchBox().clear();
	pg.getSearchBox().sendKeys(inp,Keys.ENTER);
	Thread.sleep(5000);
//	boolean noResult;
//	try {
//		pg.getNoResult().isDisplayed();
//		noResult=true;
//	   }  
//	   catch (NoSuchElementException e)
//	    {
//	   noResult=false;
//	   }
//	if(noResult) {
//		Reporter.log("No Item Found",true);
//	}
	
		List <WebElement> results = pg.getSearchResult();
		String Title;
		String Price;
		for(WebElement result:results) {
			Title=result.findElement(By.className("brand")).getText();
			Price=result.findElement(By.className("price")).getText();
			Reporter.log("Price for "+ Title +"is : "+Price, true);
		}
	}
	
	
	@DataProvider
	public String[][] getData() throws IOException {
		String path = "C:\\Users\\venka\\Downloads\\Book1.xlsx";
		String sheet = "Sheet1";
		int rowCount = ExcelUtility.getRowCount(path, sheet);
		int cellCount = ExcelUtility.getCellCount(path, sheet, rowCount);
		System.out.println("rowcount : "+rowCount);
		System.out.println("cellCount : "+cellCount);
		String[][] data = new String[rowCount][cellCount];
		for  (int i = 1; i<= rowCount; i++) {
			for(int j = 0; j< cellCount ; j++) {
				System.out.println("In loop Value of I : "+ i +"Value of J: "+j);
				data[i-1][j] =  ExcelUtility.getCellData(path, sheet, i, j);
			}

			
		}
		
		return data;
	}



	}


	