package com.zohoAutomation.tests;

import org.testng.annotations.Test;

import com.zohoAutomation.pages.PresentationPage;

public class CommentsTest extends BaseTest{
	
	PresentationPage presentationPage;
    
  @Test
  public void commentsTest() {
	  openFirstPresentation();
	  presentationPage=new PresentationPage(driver);
	  test=extent.createTest("CommentsTest","This is Comments Test");
	  
	  presentationPage.clickReview()
	  	.clickCommentBox()
	  	.enterComment()
	  	.addComment()
	  	.commentHover()
	  	.clickMoreOptions()
	  	.deleteComment()
	  	.undoDelete();
	  
  }
}
