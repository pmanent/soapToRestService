//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.04.15 a las 06:28:31 PM CEST 
//


package vrmsConnectionServices.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para GetBookingRQ complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetBookingRQ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Credentials" type="{ws.avantio.com/crsConnectionServices}CredentialsNoLanguage"/&gt;
 *         &lt;element name="Localizer" type="{ws.avantio.com/crsConnectionServices}Localizer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBookingRQ", propOrder = {
    "credentials",
    "localizer"
})
public class GetBookingRQ {

    @XmlElement(name = "Credentials", required = true)
    protected CredentialsNoLanguage credentials;
    @XmlElement(name = "Localizer", required = true)
    protected Localizer localizer;

    /**
     * Obtiene el valor de la propiedad credentials.
     * 
     * @return
     *     possible object is
     *     {@link CredentialsNoLanguage }
     *     
     */
    public CredentialsNoLanguage getCredentials() {
        return credentials;
    }

    /**
     * Define el valor de la propiedad credentials.
     * 
     * @param value
     *     allowed object is
     *     {@link CredentialsNoLanguage }
     *     
     */
    public void setCredentials(CredentialsNoLanguage value) {
        this.credentials = value;
    }

    /**
     * Obtiene el valor de la propiedad localizer.
     * 
     * @return
     *     possible object is
     *     {@link Localizer }
     *     
     */
    public Localizer getLocalizer() {
        return localizer;
    }

    /**
     * Define el valor de la propiedad localizer.
     * 
     * @param value
     *     allowed object is
     *     {@link Localizer }
     *     
     */
    public void setLocalizer(Localizer value) {
        this.localizer = value;
    }

}
