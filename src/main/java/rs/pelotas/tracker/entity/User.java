package rs.pelotas.tracker.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.jboss.resteasy.annotations.providers.NoJackson;
import org.jboss.resteasy.annotations.providers.jaxb.json.Mapped;
import org.jboss.resteasy.annotations.providers.jaxb.json.XmlNsMap;
import rs.pelotas.arch.entity.BaseEntity;

/**
 *
 * @author Rafael Guterres
 */
@Mapped(namespaceMap = @XmlNsMap(jsonName = "atom", namespace = "http://www.w3.org/2005/Atom"))
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NoJackson
@Entity
@Table(name="users")
public class User extends BaseEntity<Long> {
    
    private static final long serialVersionUID = 2094535745860666195L;

    @Id
    private Long id;

    private String login;

    private String password;
    
    @XmlTransient
    @ManyToMany(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    @JoinTable(name = "users_devices",
               joinColumns = {@JoinColumn(name = "users_id")},
               inverseJoinColumns = {@JoinColumn(name = "devices_id")})
    private List<Device> devices;
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}