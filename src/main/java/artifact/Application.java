package artifact;


import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import artifact.soap.client.CountryClient;
import hello.wsdl.Country;
import hello.wsdl.GetCountryResponse;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
	CommandLineRunner lookup(CountryClient countryClient) {
		return args -> {
			String ticker = "MSFT";

			if (args.length > 0) {
				ticker = args[0];
			}
			GetCountryResponse response = countryClient.getCountries("United Kingdom");
			Country country = response.getCountry();
			if(country!=null){
				System.err.println(country.getName());
				System.err.println(country.getCapital());
			}else{
				System.err.println("No country");
			}
			
		};
	}

}