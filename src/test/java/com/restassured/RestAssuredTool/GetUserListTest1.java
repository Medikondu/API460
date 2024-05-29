package com.restassured.RestAssuredTool;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUserListTest1 {
	RequestSpecification req;
	Response res;
	@BeforeTest
	public void init() {
		RestAssured.baseURI="https://reqres.in/";
	}
  @Test(priority=1)
  public void getData() {
	  req=RestAssured.given();
  	 res=req.get("api/users?page=2");
  	System.out.println(res.asPrettyString());
	System.out.println(res.statusCode());
	System.out.println(res.getStatusLine());
  }
  @Test(priority=0)
  public void addData() {
	  req=RestAssured.given();
	  JSONObject obj=new JSONObject();
		obj.put("name","Manikanta");
		obj.put("job","former");
		req.body(obj.toJSONString());
		res=req.post("api/users");
		System.out.println(res.asPrettyString());
		System.out.println(res.statusLine());
  }
  @AfterTest
  public void dealloctaemem() {
	  req = null;
	  res = null;
  }
}
