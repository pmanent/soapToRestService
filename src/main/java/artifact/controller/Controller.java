package artifact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import artifact.soap.client.CountryClient;
import hello.wsdl.Country;
import hello.wsdl.GetCountryResponse;

@RestController
public class Controller {
	@Autowired
	private CountryClient countryClient;
	public Controller() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/")
    public String index() {
		
        return "Greetings from Spring Boot!";
    }
	
	
	@RequestMapping(value = "/findByName", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String searchByName(@RequestParam("name") String name){
		
		GetCountryResponse response = countryClient.getCountries(name);
		Country country = response.getCountry();
		
		
		Gson gson = new Gson();
		
		return gson.toJson(country);
	}
}
