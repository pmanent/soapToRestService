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
 * <p>Clase Java para Supplements complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Supplements"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SingleSupplement" type="{ws.avantio.com/crsConnectionServices}SingleSupplement"/&gt;
 *         &lt;element name="SupplementByAdditionalPerson" type="{ws.avantio.com/crsConnectionServices}SupplementByAdditionalPerson"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Supplements", propOrder = {
    "singleSupplement",
    "supplementByAdditionalPerson"
})
public class Supplements {

    @XmlElement(name = "SingleSupplement", required = true)
    protected SingleSupplement singleSupplement;
    @XmlElement(name = "SupplementByAdditionalPerson", required = true)
    protected SupplementByAdditionalPerson supplementByAdditionalPerson;

    /**
     * Obtiene el valor de la propiedad singleSupplement.
     * 
     * @return
     *     possible object is
     *     {@link SingleSupplement }
     *     
     */
    public SingleSupplement getSingleSupplement() {
        return singleSupplement;
    }

    /**
     * Define el valor de la propiedad singleSupplement.
     * 
     * @param value
     *     allowed object is
     *     {@link SingleSupplement }
     *     
     */
    public void setSingleSupplement(SingleSupplement value) {
        this.singleSupplement = value;
    }

    /**
     * Obtiene el valor de la propiedad supplementByAdditionalPerson.
     * 
     * @return
     *     possible object is
     *     {@link SupplementByAdditionalPerson }
     *     
     */
    public SupplementByAdditionalPerson getSupplementByAdditionalPerson() {
        return supplementByAdditionalPerson;
    }

    /**
     * Define el valor de la propiedad supplementByAdditionalPerson.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplementByAdditionalPerson }
     *     
     */
    public void setSupplementByAdditionalPerson(SupplementByAdditionalPerson value) {
        this.supplementByAdditionalPerson = value;
    }

}
