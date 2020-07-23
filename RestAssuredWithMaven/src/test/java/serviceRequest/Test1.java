package serviceRequest;

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

public class Test1 {
  @Test
  public void f() throws Exception {
	  
	  FileInputStream f = new FileInputStream ("C:\\Users\\admin\\Desktop\\thushara\\TestData.xlsx");
	  XSSFWorkbook wb = new XSSFWorkbook(f);
	  XSSFSheet s = wb.getSheetAt(0);
	  int rowcount = s.getLastRowNum()-s.getFirstRowNum();
	  for(int i=1;i<=rowcount;i++) {
		  
		  String id = String.valueOf(s.getRow(i).getCell(0).getNumericCellValue());
		  String type = s.getRow(i).getCell(1).getStringCellValue();
		  String appid=s.getRow(i).getCell(2).getStringCellValue();
		  
		  System.out.println(" id is " +id);
		  System.out.println("type is " +type);
		  System.out.println("appid is " +appid);
		  RestAssured.baseURI="http://samples.openweathermap.org/data/2.5/history/city";
		  
		  RequestSpecification httpRequest = RestAssured.given();
		  
		  Response response = httpRequest.request(Method.GET, "?id="+id+"&type="+type+"&appid="+appid+"");
		  String responsebody = response.getBody().asString();
		  
		  System.out.println(responsebody);
		  
	  }
	  
	  RestAssured.baseURI="http://samples.openweathermap.org/data/2.5/history/city";
	  
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  Response response = httpRequest.request(Method.GET, "?id=2885679&type=hour&appid=b1b15e88fa797225412429c1c50c122a1");
	  
	  String responsebody = response.getBody().asString();
	  
	  System.out.println(responsebody);
	  
	  String contenttype = response.getContentType();
	  
	  System.out.println(contenttype);
	  
	  String sessionid = response.getSessionId();
	  
	  System.out.println(sessionid);
	  
      String statusline = response.getStatusLine();
	  
	  System.out.println(statusline);
	  
	  int code = response.getStatusCode();
	  
	  System.out.println(code);
	  
	  Headers headers = response.getHeaders();
	  
	  for(Header h: headers) {
		  
		  System.out.println(h.getName() + " " + h.getValue());
	  }
	  
	  String server = response.header("Server");
	  System.out.println(server);
	  String Date = response.header("Date");
	  System.out.println(Date);
	  String ContentType = response.header("Content-Type");
	  System.out.println(ContentType);
	  String TransferEncoding = response.header("Transfer-Encoding");
	  System.out.println(TransferEncoding);
	  String ContentEncoding = response.header("Content-Encoding");
	  System.out.println(ContentEncoding);
	  JsonPath jp= response.jsonPath();
	  int city_id = jp.get("city_id");
	  System.out.println(city_id);
	  Assert.assertEquals(city_id, 2885679, "success");
	  Assert.assertEquals(responsebody.contains("266.052"),true);
	  
	 
	  
  }
}
