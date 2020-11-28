package com.zohoAutomation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zohoAutomation.elements.ListingPageElements;
import com.zohoAutomation.wrapper.CommonWrapper;

public class ListingPage {
	
	WebDriver driver;
	ListingPageElements listingPageElements;
	CommonWrapper commonWrapper;
	
	public ListingPage(WebDriver driver) {
		this.driver=driver;
		listingPageElements=new ListingPageElements(driver);
		commonWrapper=new CommonWrapper();
	}
	
	public ListingPage clickSortBy(){
		listingPageElements.sortBy.click();
		return this;
	}
	
	public void clickSortByName(){
		listingPageElements.sortByName.click();
	}
	
	public String clickSortByOrder(){
		listingPageElements.sortOrder.click();
		return listingPageElements.getOrder();	
	}
	
	public List<WebElement> getPresentations(){
		return listingPageElements.presentations;
	}
	
	public void moreBtnClick() {
		listingPageElements.moreBtn.click();
	}
	
	public void clickPrintOption() {
		listingPageElements.printOption.click();
	}
	
	public String getTitle() {
		return driver.getTitle().trim();
	}
	
	public boolean isPrintPresent() {
		return listingPageElements.printButton.isDisplayed();
	}
	
	

}
