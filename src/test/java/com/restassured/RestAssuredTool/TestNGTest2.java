package com.restassured.RestAssuredTool;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNGTest2 {
  @Test
  public void Test2() {
	  System.out.println("Test method");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("BeforeTest method");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("AfterTest method");
  }

}
