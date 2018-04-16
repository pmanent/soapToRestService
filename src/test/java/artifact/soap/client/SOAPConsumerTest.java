package artifact.soap.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SOAPConsumerTest {
	@Autowired
	private SOAPConsumer soapConsumer;
	
	@LocalServerPort
    private int port;
	
	private String soapEndpointUrl = "http://ws.avantio.com/soap/vrmsConnectionServices.php";
    
	private String soapAction = "GetBooking";
	
	public SOAPConsumerTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void consumerTest(){
		soapConsumer.callSoapWebService(soapEndpointUrl, soapAction);
		
	}
}
