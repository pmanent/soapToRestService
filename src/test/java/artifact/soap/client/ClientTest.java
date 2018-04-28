package artifact.soap.client;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.client.WebServiceClientException;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

import javax.xml.bind.JAXBElement;

import vrmsConnectionServices.wsdl.AccommodationState;
import vrmsConnectionServices.wsdl.AccommodationStateList;
import vrmsConnectionServices.wsdl.AvailableCriteria;
import vrmsConnectionServices.wsdl.Credentials;
import vrmsConnectionServices.wsdl.GetAccommodationStatusRQ;
import vrmsConnectionServices.wsdl.GetAccommodationStatusRS;
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
	@Ignore
	public void isAvailableTest(){
		IsAvailableRS response = client.isAvailable();
		assertThat(response).isNotNull();
	}
	
	
	@Test
	@Ignore
	public void GetRatesListRS(){
		vrmsConnectionServices.wsdl.GetRatesListRS response = client.getRatesList();
		assertThat(response).isNotNull();
	}
	@Test
	public void getAccommodationStatusTest(){
		JAXBElement<GetAccommodationStatusRS> response = (JAXBElement<GetAccommodationStatusRS>)client.getAccommodationStatus();
		GetAccommodationStatusRS rs = response.getValue();
		Iterator<AccommodationState> it = rs.getAccommodationList().getAccommodationRS().iterator();
		while(it.hasNext()){
			AccommodationState acom=it.next();
			System.out.println("*******************************    ");
			System.out.println("Imprimim un acomodation");
			System.out.println("getAccommodationCode "+acom.getAccommodationCode());
			System.out.println(acom.getAvailableCode());
			System.out.println(acom.getCurrency());
			System.out.println(acom.getRoomOnlyPrice());
			System.out.println(acom.getRoomOnlyWithoutOfferPrice());
			System.out.println("*******************************    ");
			System.out.println("*******************************    ");
		}	

		assertThat(rs).isNotNull();

	}
}
