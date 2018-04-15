package artifact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import artifact.soap.client.SOAPClient;
import vrmsConnectionServices.wsdl.IsAvailableRS;

@RestController
public class Controller {
	@Autowired
	private SOAPClient client;
	public Controller() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/")
    public String index() {
		
        return "Greetings from Spring Boot!";
    }
	
	
	@RequestMapping(value = "/isAvailable", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String searchByName(){
		
		IsAvailableRS response = client.isAvailable();
		
		
		
		Gson gson = new Gson();
		
		return gson.toJson(response);
	}
}
