package com.zohoAutomation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.zohoAutomation.elements.PresentationPageElements;

public class PresentationPage {
	static WebDriver driver;
	PresentationPageElements presentationPageElements;
	List<String> tabs;
	
	
	public PresentationPage(WebDriver driver) {
		this.driver=driver;
		presentationPageElements=new PresentationPageElements(driver);
	}
	
	
	public String getPresentationName() {
		return presentationPageElements.presentationName.getText();
	}
	
	public PresentationPage clickFileMenu() {
		presentationPageElements.fileMenu.click();
		return this;
	}
	
	public PresentationPage clickBroadcastOption() {
		presentationPageElements.broadcastOption.click();
		return this;
	}
	
	public PresentationPage clickOpenOption() {
		presentationPageElements.openOption.click();
		return this;
	}
	
	public PresentationPage createPresentaion() {
		presentationPageElements.createNewPresentation.click();
		return this;
	}
	public PresentationPage enterPresentationName() {
		presentationPageElements.presentationName.sendKeys("Test Presentation");
		return this;
	}
	public PresentationPage chooseTemplate() {
		presentationPageElements.chooseTemplate.click();
		return this;
	}
	public PresentationPage rightClickSlide() {
		Actions a=new Actions(driver);
	    a.moveToElement(presentationPageElements.chooseSlide).contextClick().build().perform();
		return this;
	}
	public List<WebElement> getAllSlides() {
		return presentationPageElements.allSlides;
	}
	public PresentationPage saveAsImage() {
		presentationPageElements.saveAsImg.click();
		return this;
	}
	
	
	public PresentationPage clickSetupMenu() {
		presentationPageElements.setUpMenu.click();
		return this;
	}
	public PresentationPage clickCustomSlide() {
		presentationPageElements.customSlide.click();
		return this;
	}
	public PresentationPage playSlideshow() {
		presentationPageElements.playSlideshow.click();
		return this;
	}
	public PresentationPage draganddropSlides() {
		Actions builder=new Actions(driver);
		Action dragAndDrop;
		for(int i=0;i<3;i++) {
		  dragAndDrop=builder.clickAndHold(presentationPageElements.fromElement).
			  moveToElement(presentationPageElements.toElement).release(presentationPageElements.toElement).build();
		}
		presentationPageElements.saveAsImg.click();
		return this;
	}
	
	
	
	
	
	
	
	public PresentationPage createNewSlide() {
		presentationPageElements.newSlide.click();
		return this;
	}
	
	public WebElement verifyBroadcastPageLocator() {
		return presentationPageElements.broadcastPageLocator;
	}
	
	public void switchTab() {
		tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
	
	public void switchBack() {
		driver.close();   
		driver.switchTo().window(tabs.get(0));
	}	
	
	public PresentationPage clickReview() {
		presentationPageElements.review.click();
		return this;
	}
	
	public PresentationPage clickCommentBox() {
		presentationPageElements.commentBox.click();
		return this;
	}
	
	public PresentationPage enterComment() {
		presentationPageElements.commentTextArea.sendKeys("Test Comment");
		return this;
	}
	
	public PresentationPage addComment() {
		presentationPageElements.addComments.click();
		return this;
	}
	
	public PresentationPage undoDelete() {
		presentationPageElements.undoDelete.click();
		return this;
	}
	
	public PresentationPage deleteComment() {
		presentationPageElements.deleteComment.click();
		return this;
	}
	
	public PresentationPage clickMoreOptions() {
		presentationPageElements.moreOptions.click();
		return this;
	}
	
	public PresentationPage commentHover() {
		Actions action=new Actions(driver);
		action.moveToElement(presentationPageElements.commentHover).perform();
		return this;
	}
}
