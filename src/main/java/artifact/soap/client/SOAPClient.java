package artifact.soap.client;

import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import vrmsConnectionServices.wsdl.AccommodationCodeList;
import vrmsConnectionServices.wsdl.AvailableCriteria;
import vrmsConnectionServices.wsdl.Credentials;
import vrmsConnectionServices.wsdl.GetAccommodationStatusRQ;
import vrmsConnectionServices.wsdl.GetAccommodationStatusRS;
import vrmsConnectionServices.wsdl.GetRatesListRQ;
import vrmsConnectionServices.wsdl.GetRatesListRS;
import vrmsConnectionServices.wsdl.IsAvailableRQ;
import vrmsConnectionServices.wsdl.IsAvailableRS;
import vrmsConnectionServices.wsdl.Occupants;
import vrmsConnectionServices.wsdl.OnlineStateCriteria;

public class SOAPClient  extends WebServiceGatewaySupport{

	public SOAPClient() {
		// TODO Auto-generated constructor stub
	}
	
	public IsAvailableRS isAvailable(){
		
		
		IsAvailableRQ request = new IsAvailableRQ();
		
		Credentials credentials = new Credentials();
		credentials.setLanguage("es");
		credentials.setPassword("testapixml");
		credentials.setUserName("itsatentoapi_test");
		/*- User: itsatentoapi_test
- Password: testapixml*/
		request.setCredentials(credentials);
		
		AvailableCriteria criteria = new AvailableCriteria();
		
		request.setCriteria(criteria);
		
		IsAvailableRS response = null;
		response = (IsAvailableRS)this.getWebServiceTemplate().marshalSendAndReceive("http://ws.avantio.com/soap/vrmsConnectionServices.php",
				request,
				new SoapActionCallback("IsAvailable"));
		
		return response;
	}
	
	public GetRatesListRS getRatesList(){
		GetRatesListRQ request = new GetRatesListRQ();
		
		
		Credentials credentials = new Credentials();
		credentials.setLanguage("es");
		credentials.setPassword("testapixml");
		credentials.setUserName("itsatentoapi_test");
		request.setCredentials(credentials);
		
		GetRatesListRS response = null;
		response = (GetRatesListRS)this.getWebServiceTemplate().marshalSendAndReceive("http://ws.avantio.com/soap/vrmsConnectionServices.php",
				request,
				new SoapActionCallback("GetRatesList"));
		return response;
		
	}
	
	
	public Object getAccommodationStatus(){
		GetAccommodationStatusRQ request = this.getRequest();
		Object response= null;
		response = (Object)this.getWebServiceTemplate().marshalSendAndReceive("http://ws.avantio.com/soap/vrmsConnectionServices.php",
				request,
				new SoapActionCallback("GetAccommodationStatus"));
		return response;
	}
	
	
	public GetAccommodationStatusRQ getRequest(){
		GetAccommodationStatusRQ request= new GetAccommodationStatusRQ();
		Credentials credentials = new Credentials();
		credentials.setLanguage("es");
		credentials.setPassword("testapixml");
		credentials.setUserName("itsatentoapi_test");
		request.setCredentials(credentials);
		
		OnlineStateCriteria criteria= new OnlineStateCriteria();
		request.setCriteria(criteria);
		
		Occupants ocupants = new Occupants();
		ocupants.setAdultsNumber(new BigInteger("2"));
		
		criteria.setOccupants(ocupants);
		
		XMLGregorianCalendar value;//= new GregorianCalendar();
		try {
			Date actualDate = new Date();
			Date twoMonths = new Date(actualDate.getTime()+(60*24*60*60*1000));

			criteria.setDateFrom(toXMLGregorianCalendar(actualDate));
			criteria.setDateTo(toXMLGregorianCalendar(twoMonths));
			
			AccommodationCodeList accommodationList = new AccommodationCodeList();
			accommodationList.getAccommodationCode().add(new BigInteger("55213"));
			accommodationList.getAccommodationCode().add(new BigInteger("55631"));
			criteria.setAccommodationList(accommodationList);
			
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		return request;
		
	}
	
	private XMLGregorianCalendar toXMLGregorianCalendar(Date date) throws DatatypeConfigurationException{
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(date);
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		return date2;
	}

}
