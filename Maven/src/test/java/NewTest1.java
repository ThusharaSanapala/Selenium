import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewTest1 {
  @Test
  public void f() throws Exception{
	  
	  RestAssured.baseURI="https://reqres.in/api";
	  
	  RequestSpecification request= RestAssured.given();
	  
	  request.header("Content-Type","application/json");
	  
      FileInputStream f = new FileInputStream("C:\\Users\\admin\\Desktop\\thushara\\Data1.xlsx");
	  
	  XSSFWorkbook wb= new XSSFWorkbook(f);
	  
	  XSSFSheet s= wb.getSheetAt(0);
	  
	  int rowcount = s.getLastRowNum()-s.getFirstRowNum();
	  
	  for(int i=1;i<=rowcount;i++)
	  {

	  JSONObject requestParams = new JSONObject();
	  
	  requestParams.put("id",String.valueOf(s.getRow(i).getCell(0).getNumericCellValue()));
	  requestParams.put("email",s.getRow(i).getCell(1).getStringCellValue());
	  requestParams.put("first_name",s.getRow(i).getCell(2).getStringCellValue());
	  requestParams.put("last_name",s.getRow(i).getCell(3).getStringCellValue());
	  requestParams.put("avatar",s.getRow(i).getCell(4).getStringCellValue());
	  request.body(requestParams.toString());
		// Post the request and check the response
      //Response response = request.post("/users");
	  
	  Response response = request.request(Method.POST, "/users");
		//Obtain the response in string form 
      String successCode = response.asString();
      System.out.println(successCode);
      
      int code = response.getStatusCode();
      System.out.println(code);
      
      //Asserting the response
      Assert.assertEquals(code,201);
      
      wb.close();
	}

  }	  
      
  
}
