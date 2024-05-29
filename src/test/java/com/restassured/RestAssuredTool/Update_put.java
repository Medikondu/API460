package com.restassured.RestAssuredTool;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Update_put {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req=RestAssured.given();
		JSONObject obj=new JSONObject();
		obj.put("name","Kesava");
		obj.put("job","Software");
		req.body(obj.toJSONString());
		Response res=req.put("api/users/2");
		System.out.println(res.asPrettyString());
		System.out.println(res.statusLine());


	}

}
