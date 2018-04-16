package artifact.soap.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.soap.client.SoapFaultClientException;

import static org.assertj.core.api.Assertions.assertThat;

import vrmsConnectionServices.wsdl.AvailableCriteria;
import vrmsConnectionServices.wsdl.Credentials;
import vrmsConnectionServices.wsdl.IsAvailableRQ;
import vrmsConnectionServices.wsdl.IsAvailableRS;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClientTest {
	
	@Autowired
	private SOAPClient client;
	
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
	public ClientTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Test
	public void isAvailableTest(){
		try {
			IsAvailableRS response = client.isAvailable();
			assertThat(response).isNotNull();
		} catch (WebServiceClientException e) {
			// TODO Auto-generated catch block
			assertThat(e).isNotNull();
		}
	}
	
	
	private IsAvailableRQ generateRequest(){
		
		IsAvailableRQ request = new IsAvailableRQ();
		
		Credentials credentials = new Credentials();
		credentials.setLanguage("ca_CA");
		credentials.setPassword("pass");
		credentials.setUserName("pmanent");
		request.setCredentials(credentials);
		
		AvailableCriteria criteria = new AvailableCriteria();
		
		request.setCriteria(criteria);
		
		return request;
	}

}
