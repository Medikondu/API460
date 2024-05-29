package com.restassured.RestAssuredTool;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_sawgger {

public static void main(String[] args) {
		RestAssured.baseURI="https://bookstore.toolsqa.com";
    	RequestSpecification req=RestAssured.given();
    	JSONObject obj=new JSONObject();
		obj.put("userName","Manikanta");
		obj.put("password","India@143");
		req.body(obj.toJSONString());
    	Response res=req.post("/Account/v1/User");
    	System.out.println(res.asPrettyString());
    	System.out.println(res.statusCode());
    	System.out.println(res.getStatusLine());

	}

}
