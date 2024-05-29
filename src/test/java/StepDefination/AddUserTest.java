package StepDefination;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddUserTest {
	RequestSpecification req;
	Response res;
	JsonPath path;
	JSONObject obj;
	String expJ , expN;
	//.................Scenario-1...........
	/*
	 * Created By:Manikanta Medikondu
	 * Reviewed By:Deepali Dhole
	 * Description: This step is adding user
	 */
	
	
	
	@Given("user on reques url")
	public void user_on_reques_url() {
		RestAssured.baseURI="https://reqres.in/";
		req=RestAssured.given();
		System.out.println("Given step");   
	}

	@When("^user enter the (.*) and (.*)$")
	public void user_enter_the_and(String name, String job) {
		 obj=new JSONObject();
		obj.put("name",name);
		obj.put("job",job);
		expJ=job;
		expN=name;	
		req.header("Content-Type","application/json");
		System.out.println(obj);
		System.out.println("When step");
	}

	@And("users hit the users API")
	public void users_hit_the_users_api() {
		res=req.body(obj.toJSONString()).post("api/users");
		System.out.println("And step");
		
	}

	@Then("users are added to list")
	public void users_are_added_to_list() {
		System.out.println(res.asPrettyString());		
		path=res.jsonPath();
		String job1=path.getString("job");
		System.out.println(job1);
		AssertJUnit.assertEquals(job1, expJ);
	}
	
	//.......................Scenario-2...................
	
	
	@When("user enters name & job")
	public void user_enters_name_job(DataTable data) {
		List<List<String>> udata=data.asLists(String.class);
		
		
	   // List<String> cell=data.asList(String.class);
	    String name=udata.get(1).get(0);
	    String job=udata.get(1).get(1);
	    obj= new JSONObject();
	    obj.put("name", name);
	    obj.put("job", job);
	    expJ=job;
		expN=name;	
		req.header("Content-Type","application/json");
		System.out.println(obj);
		System.out.println("When step");
	    
	}
 
	@And("user hits the API")
	public void user_hits_the_api() {
		res=req.body(obj.toJSONString()).post("api/users/2");
		System.out.println("And step");
	}
 
	@Then("User data is updated")
	public void user_data_is_updated() {
		System.out.println(res.asPrettyString());		
		path=res.jsonPath();
		String job1=path.getString("job");
		System.out.println(job1);
		AssertJUnit.assertEquals(job1, expJ);
	}
	

}
