package com.restassured.RestAssuredTool;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTest1 {
  

  @DataProvider(name="profile")
  public Object[][] userdata() {
	  Object[][] data=new Object[3][2];
	  data[0][0]="Manikanta";
	  data[0][1]="Farmer";
	  data[1][0]="Jyothi";
	  data[1][1]="IAS";
	  data[2][0]="Ramaiah";
	  data[2][1]="Farmer";
	  return data; 
  }
}
