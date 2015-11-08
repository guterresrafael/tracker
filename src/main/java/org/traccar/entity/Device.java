package org.traccar.entity;

import arch.entity.BaseEntity;
import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rafael Guterres
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "devices")
@Table(name = "devices", uniqueConstraints = @UniqueConstraint(columnNames = "uniqueId"))
public class Device extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -5900559872664830378L;

    @Id
    private Long id;

    private String name;

    @Column(name = "uniqueId")
    private String imei;

    @XmlTransient
    @ManyToMany(mappedBy = "devices",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private List<User> users;

    @OneToOne
    @JoinColumn(name = "latestPosition_id")
    private Position latestPosition;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
