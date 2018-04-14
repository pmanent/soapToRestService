package artifact.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.Country;
import hello.wsdl.GetCountryRequest;
import hello.wsdl.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport{

	public CountryClient() {
		// TODO Auto-generated constructor stub
	}
	
	public GetCountryResponse getCountries(String name){
		
		GetCountryResponse response = null;
		GetCountryRequest request = new GetCountryRequest();
		request.setName(name);
		
		response = (GetCountryResponse)this.getWebServiceTemplate().marshalSendAndReceive("http://localhost:8081/ws/countries.wsdl",
				request,
				new SoapActionCallback("http://localhost:8081/ws/countries.wsdl/country"));
		
		return response;
	}

}
