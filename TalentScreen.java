package REST_HTTPCLIENT.HttpClient_automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.api_automation.base.BaseAPITest;
import com.wbl.api_automation.base.BaseApi;
import com.wbl.api_automation.helper.RestResponse;

public class TalentScreen extends BaseAPITest


{
	
	
	BaseApi api;
	
	
	@BeforeClass
	private void beforeClass() {
		// TODO Auto-generated method stub
		api=new BaseApi(endpoint);

	}
	
	@Test
	public void getSubjectsTest()
	{
		RestResponse response=api.get("/subjects?authentication=false");
		System.out.println("============");
		System.out.println(response.getStatuscode());
		System.out.println("============");
		
		
		assertEquals(response.getStatuscode(),200);
		
		
		System.out.println("===============");
		System.out.println(response.getStatusMessage());
		System.out.println("================");
		
		assertTrue(response.getStatusMessage().contains("HTTP/1.1 200 OK"));
		
		JSONArray json=new JSONArray(response.getPayload());
		System.out.println(json.toString());
	}
	
	
	
	 @Test
	 public void postSubjectsTest(){
	  RestResponse response = api.post("/subjects?authentication=false");
	  //getting important header info from response
	  //assert for status code
	  assertEquals(response.getStatuscode(),201);
	  //assert for status message
	  assertTrue(response.getStatusMessage().contains("Created"));
	  //getting actual body(resposne payload)  
	  //parsing json object
	  JSONObject json = new JSONObject(response.getPayload());
	  System.out.println(json.toString());
	  
	  System.out.println("id:"+json.get("id"));
	  
	 }
	
	
	
	

}
