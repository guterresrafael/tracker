package rs.pelotas.tracker.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.jboss.resteasy.annotations.providers.NoJackson;
import org.jboss.resteasy.annotations.providers.jaxb.json.Mapped;
import org.jboss.resteasy.annotations.providers.jaxb.json.XmlNsMap;
import org.jboss.resteasy.links.RESTServiceDiscovery;
import rs.pelotas.arch.entity.BaseEntity;

/**
 *
 * @author Rafael Guterres
 */
@Mapped(namespaceMap = @XmlNsMap(jsonName = "atom", namespace = "http://www.w3.org/2005/Atom"))
@XmlRootElement
@NoJackson
@Entity
@Table(name="devices", uniqueConstraints = @UniqueConstraint(columnNames = "uniqueId"))
public class Device extends BaseEntity<Long> {

    private static final long serialVersionUID = -5900559872664830378L;
        
    @Id
    private Long id;
    
    private String name;
    
    @Column(name="uniqueId")
    private String imei;
    
    @ManyToMany(mappedBy = "devices", 
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private List<User> users;
    
    @OneToOne
    @JoinColumn(name="latestPosition_id")
    private Position latestPosition;

    @XmlElementRef
    private RESTServiceDiscovery rest;    
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Position getLatestPosition() {
        return latestPosition;
    }

    public void setLatestPosition(Position latestPosition) {
        this.latestPosition = latestPosition;
    }

    @XmlTransient
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}