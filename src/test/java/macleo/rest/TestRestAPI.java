package macleo.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;


@SuppressWarnings("deprecation")
public class TestRestAPI {

	@SuppressWarnings("deprecation")
	@Test
	public void TestRestLogin() throws ClientProtocolException, IOException{
		   DefaultHttpClient httpClient = new DefaultHttpClient();
		    HttpPost postRequest = new HttpPost("http://localhost:8080/activiti-rest/service/login");
		 
		    StringEntity input = new StringEntity("{\"userId\":\"kafeitu\",\"password\":\"000000\"}");
		    //StringEntity input = new StringEntity("{\"userId\":\"kermit\",\"password\":\"kermit\"}");
		    input.setContentType("application/json");
		    postRequest.setEntity(input);
		 
		    HttpResponse response = httpClient.execute(postRequest);
		 
		    BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		 
		    String output;
		    System.out.println("Output from Server .... \n");
		    while ((output = br.readLine()) != null) {
		      System.out.println(output);
		    }
		 
		    httpClient.getConnectionManager().shutdown();
	}
}
