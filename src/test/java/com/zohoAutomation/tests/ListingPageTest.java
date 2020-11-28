package com.zohoAutomation.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.zohoAutomation.pages.ListingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListingPageTest extends BaseTest {
	ListingPage listingPage;
  @Test
  public void sortListingPageTest() {
	  
	  listingPage=new ListingPage(driver);
	  test=extent.createTest("ListingPageTest","This is ListingPage Test");
	  
	  listingPage.clickSortBy()
	  .clickSortByName();
	  
	  
	  String order=listingPage.clickSortByOrder();
	  System.out.println(order);
	  
	  
	  List<WebElement> presentations=listingPage.getPresentations();
	  ArrayList<String> elements= new ArrayList<String>();
	  
	  for(int i=0;i<presentations.size();i++) {
		  String xpath=
		"(//h2[text()='My Presentations']/following::div[@id='owned']/ul[@id='grid']/li)["+(i+1)+"]/div[2]/h3/span[@id='zs_title_span']";
		  elements.add(driver.findElement(By.xpath(xpath)).getText());
	  }
	  ArrayList<String> Orderedelements = (ArrayList<String>) elements.clone();
	  if(order.toLowerCase().contains("asc"))
		  Collections.sort(Orderedelements);
	  else
		  Collections.sort(Orderedelements,Collections.reverseOrder());
	  
	  Assert.assertEquals(Orderedelements, elements);
	  
  }
  
  @Test
	public void printPresentationTest() {

		listingPage.moreBtnClick();
		listingPage.clickPrintOption();

		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		Assert.assertEquals("Print Preview", listingPage.getTitle());
		Assert.assertEquals(true, listingPage.isPrintPresent());

	}
  
}
