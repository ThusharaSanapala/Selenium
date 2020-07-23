import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewTest4 {
  @Test
  public void f() throws Exception {
	  
	  RestAssured.baseURI="https://reqres.in/api/users";
	  
	  RequestSpecification httpRequest= RestAssured.given();
	  
	  Response response = httpRequest.delete("/2");
	  
	  String responsebody = response.getBody().asString();
	  
	  System.out.println(responsebody);
	  
	  System.out.println(response.getStatusCode());
	  
	 

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
}
