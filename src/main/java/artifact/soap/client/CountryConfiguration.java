package artifact.soap.client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryConfiguration {

	public CountryConfiguration() {
		// TODO Auto-generated constructor stub
	}
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("vrmsConnectionServices.wsdl");
		return marshaller;
	}

	@Bean
	public SOAPClient countryClient(Jaxb2Marshaller marshaller) {
		
		SOAPClient client = new SOAPClient();
		client.setDefaultUri("http://ws.avantio.com/soap/vrmsConnectionServices.php?wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
