# Convert Soap Call to Rest

# Run the countries service:

Follow the instrucction in : https://github.com/pmanent/management.git

# Run the actual spring boot application:

mvn spring-boot:run

You can make REST calls to the service:

http://localhost:8083/findByName?name=Poland

The Rest service will call to the SOAP service at the http://localhost:8081/ws/countries.wsdl
