package com.restassured.RestAssuredTool;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorizationbookstore {

	public static void main(String[] args) {
		RestAssured.baseURI="https://bookstore.toolsqa.com/";
		JSONObject obj=new JSONObject();
		obj.put("userName","MMEDIKON");
		obj.put("password","Amma@143");
		RequestSpecification req=RestAssured.given().auth().basic("MMEDIKON","Amma@143").header("Content-Type","application/json").body(obj.toJSONString());
		Response res =req.post("Account/V1/Authorized");
		String data=res.asPrettyString();
		System.out.println(data);
		RequestSpecification req1=RestAssured.given().header("Content-Type","application/json").body(obj.toJSONString());
		Response res1=req1.post("Account/V1/GenerateToken");
		System.out.println(res1.asPrettyString());
	}

}
