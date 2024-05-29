package StepAddUser;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddTestUser {
	RequestSpecification req;
	Response res;
	JsonPath path;
	JSONObject obj=new JSONObject();
	String expj;
	String expn;
	
	@Given("user on reques url")
	public void user_on_reques_url() {
		RestAssured.baseURI="https://reqres.in/";
		req=RestAssured.given();
		System.out.println("Given step");   
	}

	@When("user enter the (.*) and (.*)$")
	public void user_enter_the_and(String name, String job) {
		JSONObject obj=new JSONObject();
		obj.put("name",name);
		obj.put("job",job);
		expj=job;
		expn=name;	
		req.header("Content-Type","appication/json").body(obj.toJSONString());
		System.out.println(obj);
		System.out.println("When step");
	}

	@And("users hit the users API")
	public void users_hit_the_users_api() {
		res=req.post("api/users");
		System.out.println("and step");
		
	}

	@Then("users are added to list")
	public void users_are_added_to_list() {
		System.out.println(res.asPrettyString());		
		path=res.jsonPath();
		String job1=path.getString("job");
		System.out.println(job1);
		AssertJUnit.assertEquals(job1, expj);
		System.out.println("Then step");
	    
	}

}
