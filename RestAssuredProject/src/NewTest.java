import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewTest {
  @Test
  public void f() throws Exception {
	  
      RestAssured.baseURI="https://reqres.in/api";
	  
	  RequestSpecification request1 = RestAssured.given();
	  
	  
	  Response response1 = request1.get("/users");
	  
	  System.out.println(response1.getBody().asString());
	  
	  System.out.println(response1.getContentType());
	  
      System.out.println(response1.getStatusCode());
      
      System.out.println(response1.getStatusLine());
      
      Assert.assertEquals(response1.getStatusCode(), 200);
      Headers headers = response1.getHeaders();
	  for(Header header:headers) {
		  
		  System.out.println("key:" + " " + header.getName() + " " + "value:" + " " + header.getValue());
	  }
	  String contenttype = response1.header("Content-Type");
	  System.out.println(contenttype);
	  String server = response1.header("Server");
	  System.out.println(server);
	  String date = response1.header("Date");
	  System.out.println(date);
	  String ContentEncodingvalue = response1.header("Content-Encoding");
	  System.out.println(ContentEncodingvalue);
	  String TransferEncoding = response1.header("Transfer-Encoding");
	  System.out.println(TransferEncoding);
	  JsonPath jp = response1.jsonPath();
	  int total = jp.get("total");
	  System.out.println(total);
	  
	  
	  
	 
  }
}
