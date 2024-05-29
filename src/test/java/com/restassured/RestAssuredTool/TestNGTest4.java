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

public class TestNGTest4 {
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
  @Parameters({"name","job"})
  public void adduser(String name,String job) {
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
  @Test
  @Parameters({"Brother","Bloodline"})
  public void create_patch(String Brother,String Bloodline) {
	  obj.put("Brother",Brother);
		obj.put("Bloodline",Bloodline);
		req.body(obj.toJSONString());
		 res=req.patch("api/users/2");
		System.out.println(res.asPrettyString());
		System.out.println(res.statusLine());
  }
  @Test
  public void delete_data() {
	   res=req.delete("api/users/2");
		System.out.println(res.statusLine());

  }
  @AfterTest
  public void aftertest() {
	  res = null;
	  req = null;
	  data = null;
  }
  
}
