package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import pojo.addPlacePayload;
import pojo.addPlaceResponsePayload;
import pojo.locationPayload;
import reSources.EnumDemo;
import reSources.dataBuild;
import reSources.utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//@RunWith(Cucumber.class)
public class placeValidate  extends utils {
	//RequestSpecification resSpec;
	RequestSpecification res;
	Response resp;
	dataBuild d=new dataBuild();
	JsonPath js;
	String response;

		
	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		
		
		
		res=given().spec(reusableMethods()).body(d.addressSet(name, language, address));
		


	}
	@When("User hit {string} with Post HTTP Request")
	public void user_hit_with_post_http_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
		EnumDemo postAPI=EnumDemo.valueOf(string);
		String ApiPost=postAPI.getResource();
		resp=res.when().post(ApiPost).then()
                .extract().response();

	}
	@Then("Place should be added successfully with Status code {string}")
	public void place_should_be_added_successfully_with_status_code(String string) {
	    // Write code here that turns the phrase above into concrete actions
        System.out.println(resp.getStatusCode());
        
		assertEquals(resp.getStatusCode(),200);
	   
	}
	@Then("{string} is {string} in response body")
	public void is_in_response_body(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		
		
		
		
		assertEquals(getJson(resp,string),getJson(resp,string2));
	}
	
	/*@Then("verify place id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String string, String method) throws IOException {
		
	    //getplace
		String place_id=getJson(resp, "place_id");
		res=given().spec(reusableMethods()).queryParam("place_id", place_id);
		EnumDemo getAPI=EnumDemo.valueOf(method);
		String Apiget=getAPI.getResource();
		resp=res.when().post(Apiget).then()
                .extract().response();
		System.out.println(resp);
		
	}*/





	

}
