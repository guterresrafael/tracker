package rs.pelotas.tracker.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import org.jboss.resteasy.links.RESTServiceDiscovery;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Book {
    @XmlAttribute
    private String author;
    @XmlID @XmlAttribute
    private String title; 
    @XmlElementRef
    private RESTServiceDiscovery rest;

    public Book() {}

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}