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
 * <p>Clase Java para GetAccommodationListRQ complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetAccommodationListRQ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Credentials" type="{ws.avantio.com/crsConnectionServices}Credentials"/&gt;
 *         &lt;element name="Criteria" type="{ws.avantio.com/crsConnectionServices}CriteriaAccommodationList"/&gt;
 *         &lt;element name="OrderCriteria" type="{ws.avantio.com/crsConnectionServices}OrderCriteria" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAccommodationListRQ", propOrder = {
    "credentials",
    "criteria",
    "orderCriteria"
})
public class GetAccommodationListRQ {

    @XmlElement(name = "Credentials", required = true)
    protected Credentials credentials;
    @XmlElement(name = "Criteria", required = true)
    protected CriteriaAccommodationList criteria;
    @XmlElement(name = "OrderCriteria")
    protected OrderCriteria orderCriteria;

    /**
     * Obtiene el valor de la propiedad credentials.
     * 
     * @return
     *     possible object is
     *     {@link Credentials }
     *     
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * Define el valor de la propiedad credentials.
     * 
     * @param value
     *     allowed object is
     *     {@link Credentials }
     *     
     */
    public void setCredentials(Credentials value) {
        this.credentials = value;
    }

    /**
     * Obtiene el valor de la propiedad criteria.
     * 
     * @return
     *     possible object is
     *     {@link CriteriaAccommodationList }
     *     
     */
    public CriteriaAccommodationList getCriteria() {
        return criteria;
    }

    /**
     * Define el valor de la propiedad criteria.
     * 
     * @param value
     *     allowed object is
     *     {@link CriteriaAccommodationList }
     *     
     */
    public void setCriteria(CriteriaAccommodationList value) {
        this.criteria = value;
    }

    /**
     * Obtiene el valor de la propiedad orderCriteria.
     * 
     * @return
     *     possible object is
     *     {@link OrderCriteria }
     *     
     */
    public OrderCriteria getOrderCriteria() {
        return orderCriteria;
    }

    /**
     * Define el valor de la propiedad orderCriteria.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderCriteria }
     *     
     */
    public void setOrderCriteria(OrderCriteria value) {
        this.orderCriteria = value;
    }

}
