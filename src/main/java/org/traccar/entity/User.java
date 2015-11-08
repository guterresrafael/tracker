package org.traccar.entity;

import arch.annotation.adapters.PasswordAdapter;
import arch.entity.BaseEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Rafael Guterres
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "users")
@Table(name = "users")
public class User extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = 2094535745860666195L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    @XmlJavaTypeAdapter(PasswordAdapter.class)
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
