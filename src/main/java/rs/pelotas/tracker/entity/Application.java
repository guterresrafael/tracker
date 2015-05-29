package rs.pelotas.tracker.entity;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import org.jboss.resteasy.links.RESTServiceDiscovery;

/**
 *
 * @author Rafael Guterres
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Application {
    
    @XmlAttribute
    private static final String version = "1.0.0-SNAPSHOT";
    
    @XmlElementWrapper(name = "links")
    @XmlElement(name = "link")
    @Transient
    RESTServiceDiscovery rest;

    public String getVersion() {
        return version;
    }
}
