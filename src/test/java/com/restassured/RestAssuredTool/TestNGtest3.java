package com.restassured.RestAssuredTool;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

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
@Test
  public void addUser() {
	  obj.put("name", "Manikanta");
	  obj.put("job", "Farmer");
	  req.header("Content-Type","application/json");	  
	  res=req.body(obj.toJSONString()).post("api/users");
	  data=res.jsonPath();
	  System.out.println(res.asPrettyString());
	  Assert.assertEquals(data.getString("name"), "Manikanta");
	  Assert.assertEquals(data.getString("job"), "Farmer");
	  Assert.assertEquals(res.getStatusCode(), 201);
  }
	@Test
	public void getListUser() {
		res=req.get("api/users?page=2");
		data=res.jsonPath();
		Assert.assertEquals(data.getString("data[1].email"), "lindsay.ferguson@reqres.in");
	}
  @AfterTest
  public void afterTest() {
	  req=null;
	  res=null;
	  data=null;
  }
}
