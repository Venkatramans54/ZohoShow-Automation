package com.zohoAutomation.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zohoAutomation.pages.PresentationPage;

public class FileOptionsTest extends BaseTest {
	PresentationPage presentationPage;
  @Test
public void fileOptions() {
	  
	  openFirstPresentation();
	  presentationPage=new PresentationPage(driver);
	  test=extent.createTest("FileOptionsTest","This is FilesOptions Test");
	  
	  String presentationName=presentationPage.getPresentationName();
	  
	  presentationPage.clickFileMenu()
	  	.clickBroadcastOption()
	  	.switchTab();
	  
	  Assert.assertEquals(true, presentationPage.verifyBroadcastPageLocator().isDisplayed());
	  
	  presentationPage.switchBack();
	  presentationPage.clickOpenOption();
	  
	  Assert.assertEquals("Open File", driver.findElement(By.xpath("//span[@id='ui-id-2']")).getText());
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[@title='"+presentationName+"']")).isDisplayed());
  }
}
