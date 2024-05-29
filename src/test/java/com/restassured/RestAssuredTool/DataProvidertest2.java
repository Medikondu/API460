package com.restassured.RestAssuredTool;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DataProvidertest2 {
	public class TestNGtest3 {
		RequestSpecification req;
		Response res;
		JSONObject obj=new JSONObject();
		JsonPath data;
	  @BeforeTest
	  public void beforeTest() {
		  RestAssured.baseURI="https://reqres.in/";
		  req=RestAssured.given();
	  }
	@Test(dataProvider="profile",dataProviderClass=DataProviderTest1.class)
	  public void addUser(String name,String job) {
		  obj.put("name", name);
		  obj.put("job", job);
		  req.header("Content-Type","application/json");	  
		  res=req.body(obj.toJSONString()).post("api/users");
		  data=res.jsonPath();
		  System.out.println(res.asPrettyString());
		  Assert.assertEquals(data.getString("name"), name);
		  Assert.assertEquals(data.getString("job"), job);
		  Assert.assertEquals(res.getStatusCode(), 201);
	  }
	@AfterTest
	  public void afterTest() {
		  req=null;
		  res=null;
		  data=null;
	  }

}
}
