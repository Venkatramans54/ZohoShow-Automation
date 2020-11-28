package com.zohoAutomation.tests;

import org.testng.annotations.Test;

import com.zohoAutomation.pages.PresentationPage;

public class CustomSlideshowTest extends BaseTest {
	
	PresentationPage presentationPage;
  
  @Test
  public void customSlideshowTest() {
	  openFirstPresentation();
	  presentationPage=new PresentationPage(driver);
	  test=extent.createTest("CustomSlideShowTest","This is CustomSlideshow Test");
	  
	  presentationPage.clickSetupMenu()
	  	.clickCustomSlide()
	  	.draganddropSlides()
	  	.playSlideshow();
	  
  }
}
