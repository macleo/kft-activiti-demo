package macleo.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SuppressWarnings("deprecation")
public class TestRestAPI {

	private static final Logger logger = LoggerFactory.getLogger(TestRestAPI.class);
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
		      //System.out.println(output);
		    	logger.debug(output);
		    }
		 
		    httpClient.getConnectionManager().shutdown();
	}
	
	@Test
	public void TestRestDeploy() throws ClientProtocolException, IOException{
		   DefaultHttpClient httpClient = new DefaultHttpClient();
		    HttpGet getRequest = new HttpGet("http://localhost:8080/activiti-rest/service/deployments");
		 
		    StringEntity input = new StringEntity("{\"userId\":\"kafeitu\",\"password\":\"000000\"}");
		    //StringEntity input = new StringEntity("{\"userId\":\"kermit\",\"password\":\"kermit\"}");
		    input.setContentType("application/json");
		    //postRequest.setEntity(input);
		 
		    getRequest.addHeader("Accept","text/html, application/xhtml+xml, */*");
		    getRequest.addHeader("Accept-Language","zh-CN,en-US;q=0.5");
		    getRequest.addHeader("User-Agent","Mozilla/5.0 (iPhone; U; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Mobile/9A334 Safari/7534.48.3");
		    getRequest.addHeader("Accept-Encoding","gzip, deflate");
		    getRequest.addHeader("Host","localhost:8080");
		    getRequest.addHeader("Connection","Keep-Alive");
		    
		    HttpResponse response = httpClient.execute(getRequest);
		 
		    BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		 
		    String output;
		    //System.out.println("Output from Server .... \n");
		    while ((output = br.readLine()) != null) {
		      //System.out.println(output);
		    	logger.debug(output);
		    }
		 
		    httpClient.getConnectionManager().shutdown();
	}

}
