import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewTest3 {
  @Test
  public void f() throws Exception {
	  
	  RestAssured.baseURI="https://reqres.in/api";
	  RequestSpecification Request = RestAssured.given();
	  Request.header("Content-Type", "application/json");
	  FileInputStream f = new FileInputStream("C:\\Users\\admin\\Desktop\\thushara\\TestData1.xlsx");
	  XSSFWorkbook wb = new XSSFWorkbook(f);
	  XSSFSheet s= wb.getSheetAt(0);
	  int rowcount = s.getLastRowNum()-s.getFirstRowNum();
	  for(int i=1;i<=rowcount;i++) {
		  
		  JSONObject requestparams = new JSONObject();
		  requestparams.put("company", s.getRow(i).getCell(0).getStringCellValue());
		  requestparams.put("url", s.getRow(i).getCell(1).getStringCellValue());
		  requestparams.put("text", s.getRow(i).getCell(2).getStringCellValue());
		  Request.body(requestparams.toString());
		 // Response response = Request.request(Method.POST, "/users");
		  Response response = Request.post("/users");
		  System.out.println(response.getBody().asString());
		  System.out.println(response.getStatusCode());
		  
		  Assert.assertEquals(response.getStatusCode(), 201);
		  
		  wb.close();
		  
	  }
	  
	  
	  

  }
}