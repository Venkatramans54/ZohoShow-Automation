package com.zohoAutomation.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.zohoAutomation.pages.PresentationPage;

public class SlideRightClickTest extends BaseTest {
	
	PresentationPage presentationPage;
	
	  @Test
	  public void slideRightClickTest() {
		  
		  openFirstPresentation();
		  List<WebElement> allSlides= new ArrayList<WebElement>();
		  presentationPage=new PresentationPage(driver);
		  
		  test=extent.createTest("SlideRightClickTest","This is SlideRightClick Test");
		  
		  presentationPage.createPresentaion()
		  	.switchTab();
		  presentationPage.enterPresentationName()
		  	.chooseTemplate()
		  	.rightClickSlide();
		  
		  allSlides= presentationPage.getAllSlides();
		  int noofslides=allSlides.size();
		  
		  presentationPage.createNewSlide();
		  
		  allSlides= presentationPage.getAllSlides();
		  if(allSlides.size()==noofslides+1) {
			  System.out.println("New Slide Created ");
		  }
		  
		  presentationPage.rightClickSlide()
		  	.saveAsImage();
		  
	  }
}
