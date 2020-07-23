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

public class NewTest {
  @Test
  public void f() throws Exception {
	  
	  RestAssured.baseURI="https://reqres.in/api/users";
	  
	  RequestSpecification httpRequest= RestAssured.given();
	  
	  Response response = httpRequest.request(Method.GET, "?page=2");
	  
	  String responsebody = response.getBody().asString();
	  
	  System.out.println(responsebody);
	  
	  String contenttype = response.getContentType();
	  
	  System.out.println(contenttype);
	  
	  String sessionid = response.getSessionId();
	  
	  System.out.println(sessionid);
	  
      String statusline = response.getStatusLine();
	  
	  System.out.println(statusline);
	  
	  int statuscode = response.getStatusCode();
	  
	  System.out.println(statuscode);
	  
	  FileInputStream f = new FileInputStream("C:\\Users\\admin\\Desktop\\thushara\\Data.xlsx");
	  
	  XSSFWorkbook wb= new XSSFWorkbook(f);
	  
	  XSSFSheet s= wb.getSheetAt(0);
	  
	  int rowcount = s.getLastRowNum()-s.getFirstRowNum();
	  
	  for(int i=1;i<=rowcount;i++)
	  {
		  
		  String page = String.valueOf(s.getRow(i).getCell(0).getNumericCellValue());
		  
		  Response response1 = RestAssured.get("https://reqres.in/api/users?page=" + page + "");
		  
		  System.out.println(page);
		  
		  String responseb= response1.getBody().asString();
		  
		  System.out.println(responseb);
		  
		  wb.close();
		  
	  }
	  
	  Headers header = response.getHeaders();
	  for(Header h:header) {
		  
		  System.out.println(h.getName() + " " + h.getValue());
	  }
	  
	  System.out.println(response.header("Date"));
	  System.out.println(response.header("Content-Type"));
	  System.out.println(response.header("Transfer-Encoding"));
	  System.out.println(response.header("Server"));
	  System.out.println(response.header("Content-Encoding"));
	  
	  JsonPath jp = response.jsonPath();
	  
	  int total = jp.get("total");
	  
	  System.out.println(total);
	  
	  Assert.assertEquals(total, 12);
	 

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
}
