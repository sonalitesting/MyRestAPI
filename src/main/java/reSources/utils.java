package reSources;

import java.io.FileOutputStream;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utils {
	static RequestSpecification resSpec;
	public RequestSpecification reusableMethods() throws IOException {
		
		if(resSpec==null) {
			PrintStream p=new PrintStream(new FileOutputStream("Logging.txt"));
			
			resSpec= new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
					.addFilter(RequestLoggingFilter.logRequestTo(p))
					.addFilter(ResponseLoggingFilter.logResponseTo(p))
					
					.setContentType(ContentType.JSON).addQueryParam("key","qaclick123").build();
			return resSpec;
		}
		return resSpec;
	}
	
	public static String getGlobalValue(String key) throws IOException{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Hp\\Mavenlearn\\src\\main\\java\\reSources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
		
	}
	
	public String getJson(Response resp,String key) {
		String res=resp.asString();
		JsonPath js=new JsonPath(res);
		return js.getString(key);
		 
		
	}
	
	
}
