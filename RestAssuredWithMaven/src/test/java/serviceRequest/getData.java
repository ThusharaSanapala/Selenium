package serviceRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getData {
	
	@Test
	
	public void response() {
	
	Response resp= RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");
	int code=resp.getStatusCode();
	String s=resp.asString();
	System.out.println(code);
	Assert.assertEquals(code, 200);
	System.out.println(s);
	System.out.println(resp.getTime());
	
	}		

}
