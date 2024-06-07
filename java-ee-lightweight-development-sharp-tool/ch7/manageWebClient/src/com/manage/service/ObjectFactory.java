
package com.manage.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.manage.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindGameResponse_QNAME = new QName("http://service.manage.com/", "findGameResponse");
    private final static QName _FindGame_QNAME = new QName("http://service.manage.com/", "findGame");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.manage.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindGame }
     * 
     */
    public FindGame createFindGame() {
        return new FindGame();
    }

    /**
     * Create an instance of {@link FindGameResponse }
     * 
     */
    public FindGameResponse createFindGameResponse() {
        return new FindGameResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindGameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.manage.com/", name = "findGameResponse")
    public JAXBElement<FindGameResponse> createFindGameResponse(FindGameResponse value) {
        return new JAXBElement<FindGameResponse>(_FindGameResponse_QNAME, FindGameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindGame }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.manage.com/", name = "findGame")
    public JAXBElement<FindGame> createFindGame(FindGame value) {
        return new JAXBElement<FindGame>(_FindGame_QNAME, FindGame.class, null, value);
    }

}
