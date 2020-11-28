package com.zohoAutomation.elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PresentationPageElements {
	WebDriver driver;
	
	//Elements for CommentsTest
	@FindBy(xpath = "//a[text()='Review']") public WebElement review;
	@FindBy(xpath = "//div[@id='comments_text']") public WebElement commentBox;  
	@FindBy(xpath = "//textarea[@id='comments_text_dummy']") public WebElement commentTextArea;
	@FindBy(xpath = "//div[@id='postCommentList']") public WebElement addComments;
	@FindBy(xpath = "//div[@id='addComment_controls']/div/div/following-sibling::div[3]/div[2]/div/div/*/ul/li[1]/div") public WebElement commentHover;  
	@FindBy(xpath = "/div[@id='addComment_controls']/div/div/following-sibling::div[3]/div[2]/div/div/*/ul/li[1]/div/div/div/div[4]/*[name()='svg']/*[name()='use']") 
		public WebElement moreOptions;
	@FindBy(xpath = "(//p[text()='Delete thread'])[3]") public WebElement deleteComment;  
	@FindBy(xpath = "//span[@id='undo_del']") public WebElement undoDelete;
	
	//Elements for FileOptionsTest
	@FindBy(xpath = "//div[@id='ui-zft-name']") public WebElement presentationName;
	@FindBy(id = "fileMenu") public WebElement fileMenu;  
	@FindBy(xpath = "//span[text()='Broadcast']") public WebElement broadcastOption;
	@FindBy(id = "start-remote") public WebElement broadcastPageLocator;
	@FindBy(xpath = "//span[contains(text(),'Open...')]") public WebElement openOption;  
	@FindBy(xpath = "//span[@id='ui-id-2']") public WebElement openFileText;
	
	//Elements for SlideRightClickTest
	@FindBy(id = "create_new_presentation") public WebElement createNewPresentation;
	@FindBy(id = "presentation_name") public WebElement newPresentationName;
	@FindBy(id = "apply_in_presentation") public WebElement chooseTemplate;  
	@FindBy(xpath = "//div[@id='slideThumbs']/div[1]/div/div[@class='thumbnail_scrollable']") public WebElement chooseSlide;
	@FindBy(xpath = "//div[@id='slideThumbs']/div") public List<WebElement> allSlides;
	@FindBy(id = "//span[text()='New Slide']") public WebElement newSlide;
	@FindBy(xpath = "//span[text()='Save as Image']") public WebElement saveAsImg; 
	
	//Elements for CustomSlideShowTest
	@FindBy(xpath = "//button[@popup='slideshowsetupmenu']") public WebElement setUpMenu;
	@FindBy(xpath = "//li[@id='customshow']") public WebElement customSlide;
	@FindBy(xpath = "//div[@id='slideThumbs']/div[1]/div/div[@class='thumbnail_scrollable']") public WebElement fromElement;
	@FindBy(xpath = "//div[@id='pickedSlideCon']") public WebElement toElement;
	@FindBy(xpath = "//div[@id='quickCustomslideshow']") public WebElement playSlideshow;
	
	
	public PresentationPageElements(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

}
