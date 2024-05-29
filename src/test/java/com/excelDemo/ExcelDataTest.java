package com.excelDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;

public class ExcelDataTest {
	RequestSpecification req;
	Response res;
	JSONObject obj=new JSONObject();
	JsonPath data;
	File file;
	FileInputStream fis;
	XSSFWorkbook w;
	XSSFSheet s;
	
  
  @BeforeTest
  public void beforeTest() {
	  RestAssured.baseURI="https://reqres.in/";
	  req=RestAssured.given();
  }
  
  @Test
  public void exceldata() throws Exception{
	  file=new File("C:\\Users\\MMEDIKON\\eclipse-workspace\\RestAssuredTool\\src\\test\\java\\com\\excelDemo\\userData.xlsx");
	  fis=new FileInputStream(file);
	  w=new XSSFWorkbook(fis);
	  s=w.getSheet("Sheet1");
	  //s=w.getSheetAt(0);
	  String name=s.getRow(2).getCell(0).toString();
	  String job=s.getRow(2).getCell(1).toString();
	  obj.put("name", name);
	  obj.put("job", job);
	  req.headers("Content-Type","application/json");
	  res=req.body(obj.toJSONString()).post("api/users");
	  data=res.jsonPath();
	  System.out.println(res.asPrettyString());
	  System.out.println(res.statusLine());
	  AssertJUnit.assertEquals(data.getString("name"),name);
	  
			  
  }
  
  @AfterTest
  public void afterTest() {
	  req=null;
	  res=null;
	  obj=null;
	  file=null;
	  fis=null;
	  w=null;
	  s=null;
  }

}
