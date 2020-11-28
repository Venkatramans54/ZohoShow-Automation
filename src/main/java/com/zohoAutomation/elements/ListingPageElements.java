package com.zohoAutomation.elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListingPageElements {
	WebDriver driver;
	
	@FindBy(id = "sortBy") public WebElement sortBy;
	@FindBy(id = "name") public WebElement sortByName;  
	@FindBy(id = "sortOrder") public WebElement sortOrder;
	@FindBy(xpath = "//h2[text()='My Presentations']/following::div[@id='owned']/ul[@id='grid']/li" ) public List<WebElement> presentations;
	@FindBy(xpath = "(//h2[text()='My Presentations']/following::div[@id='owned']/ul[@id='grid']/li)[1]/div[2]/div[2]/button[@id='delBtnMenu']")
		public WebElement moreBtn;
	
	@FindBy(xpath = "//z-menuitem[@id='zs_print']") public WebElement printOption;
	@FindBy(id = "print_button") public WebElement printButton;
	
	public ListingPageElements(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getOrder() {
		return sortOrder.getAttribute("sortorder");
	}

}
