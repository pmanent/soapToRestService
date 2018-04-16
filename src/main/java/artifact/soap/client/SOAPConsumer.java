package artifact.soap.client;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.springframework.stereotype.Service;

@Service
public class SOAPConsumer {
	
	private String soapEndpointUrl = "http://ws.avantio.com/soap/vrmsConnectionServices.php?wsdl";
    private String soapAction = "http://ws.avantio.com/soap/vrmsConnectionServices.php?wsdl";
	
    public SOAPConsumer() {
		// TODO Auto-generated constructor stub
	}
	
	private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "crs";
        String myNamespaceURI = "ws.avantio.com/crsConnectionServices";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("xsd", "ws.avantio.com/crsConnectionServices/xsd");
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
    

            /*
            Constructed SOAP Request Message:
            <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="ws.avantio.com/crsConnectionServices/xsd" xmlns:crs="ws.avantio.com/crsConnectionServices">
			   <soapenv:Header/>
			   <soapenv:Body>
			      <xsd:GetBookingRQ>
			         <crs:Credentials>
			            <crs:UserName>?</crs:UserName>
			            <crs:Password>?</crs:Password>
			         </crs:Credentials>
			         <crs:Localizer>
			            <!--Optional:-->
			            <crs:BookingCode>?</crs:BookingCode>
			            <!--Optional:-->
			            <crs:Localizator>?</crs:Localizator>
			            <!--Optional:-->
			            <crs:AgentLocalizator>?</crs:AgentLocalizator>
			         </crs:Localizer>
			      </xsd:GetBookingRQ>
			   </soapenv:Body>
			</soapenv:Envelope>
            */

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement getBookingRQ = soapBody.addChildElement("GetBookingRQ", "xsd");
        SOAPElement credentials = getBookingRQ.addChildElement("Credentials", myNamespace);
        SOAPElement userName = credentials.addChildElement("UserName", "crs");
        userName.addTextNode("user");
        SOAPElement password = credentials.addChildElement("Password", "crs");
        password.addTextNode("password");
        
        SOAPElement localizer = getBookingRQ.addChildElement("Localizer", "crs");

        SOAPElement bookingCode = localizer.addChildElement("BookingCode", "crs");
        bookingCode.addTextNode("bookingCode");
        SOAPElement localizator = localizer.addChildElement("Localizator", "crs");
        localizator.addTextNode("bookingCode");
        SOAPElement agentLocalizator = localizer.addChildElement("AgentLocalizator", "crs");
        agentLocalizator.addTextNode("bookingCode");
    } 
	
	private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }
	
	public void callSoapWebService(String soapEndpointUrl, String soapAction) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(this.createSOAPRequest(soapAction), soapEndpointUrl);

            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);
            System.out.println();

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    }

}
