import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewTest {
  @Test
  public void f() throws Exception {
	  
  //"http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");
	  
	  //Response response = RestAssured.get("http://10.82.48.225:8081/EDUBank/AccountAPI/getAccount?accountNumber=443328602688019");
	  
	  RestAssured.baseURI="http://samples.openweathermap.org/data/2.5/weather";
	  
	  Header h1 = new Header("Accept","application/json");
	  
	  RequestSpecification request = RestAssured.given();
	  
	  FileInputStream f= new FileInputStream("C:\\Users\\admin\\Desktop\\thushara\\SampleWeather.xlsx");
	  
	  XSSFWorkbook wb = new XSSFWorkbook(f);
	  
	  XSSFSheet s= wb.getSheetAt(0);
	  
	  int rowcount = s.getLastRowNum()-s.getFirstRowNum();
	  
	  for(int i=1;i<=rowcount;i++) {
		  
		  String city = s.getRow(i).getCell(0).getStringCellValue();
		  
		  String appid = s.getRow(i).getCell(1).getStringCellValue();
		  
		  System.out.println(city);
		  
	      System.out.println(appid);
		  
		  Response response = request.header(h1).get("?q=" + city + "&appid=" + appid + "");
		  
		  System.out.println(response.getBody().asString());
		  
		  JsonPath jp = response.jsonPath();
		  
		  int id = jp.get("id");
		  
		  System.out.println(id);
		  
		  System.out.println(response.getContentType());
		  
	      System.out.println(response.getStatusCode());
	      
	      System.out.println(response.getStatusLine());
		  
	      System.out.println(response.getSessionId());
	      
	      Assert.assertEquals(response.getStatusCode(), 200);
	  }
	  
	  wb.close();
	  
	  RestAssured.baseURI="https://reqres.in/api";
	  
	  RequestSpecification request1 = RestAssured.given();
	  
	  request1.header("Content-Type","application/json");
	  
	  JSONObject requestp = new JSONObject();
	  
	  requestp.put("id", "123456789");
	  
	  requestp.put("name", "paul");
	  
	  request1.body(requestp.toString());
	  
	  Response response1 = request1.header(h1).post("/users");
	  
	  System.out.println(response1.getBody().asString());
	  
	  System.out.println(response1.getContentType());
	  
      System.out.println(response1.getStatusCode());
      
      System.out.println(response1.getStatusLine());
      
      Assert.assertEquals(response1.getStatusCode(), 201);
	  
	  
	  
	 
	  
	  
	  
  }
}
