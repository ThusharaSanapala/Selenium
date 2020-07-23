package serviceRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class NewTest {
  @Test
  public void f() {
	  
	  
	  Response res= RestAssured.get("http://samples.openweathermap.org/data/2.5/history/city?id=2885679&type=hour&appid=b1b15e88fa797225412429c1c50c122a1");
	  String response = res.getBody().asString();
	  System.out.println(response);
	  int code=res.getStatusCode();
	  String status = res.getStatusLine();
	  System.out.println(code);
	  System.out.println(status);
//	  Headers headers = res.getHeaders();
//	  for(Header header:headers) {
//		  
//		  System.out.println("key:" + " " + header.getName() + " " + "value:" + " " + header.getValue());
//	  }
//	  String contenttype = res.header("Content-Type");
//	  System.out.println(contenttype);
//	  String server = res.header("Server");
//	  System.out.println(server);
//	  String date = res.header("Date");
//	  System.out.println(date);
//	  String ContentEncodingvalue = res.header("Content-Encoding");
//	  System.out.println(ContentEncodingvalue);
//	  String TransferEncoding = res.header("Transfer-Encoding");
//	  System.out.println(TransferEncoding);
	  
	  JsonPath jp= res.jsonPath();
	  
	  int cityid = jp.get("city_id");
	  
	  System.out.println(cityid);
	  
	  Assert.assertEquals(cityid, 2885679);
	  
	  Assert.assertEquals(response.contains("90") /*Expected value*/, true /*Actual Value*/, "Response body does not contain martin");
	  

	  
	 	  
	  
	  
  }
}
