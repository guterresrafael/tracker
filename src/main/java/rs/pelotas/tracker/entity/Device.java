package rs.pelotas.tracker.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
import rs.pelotas.arch.entity.BaseEntity;

/**
 *
 * @author Rafael Guterres
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "device", uniqueConstraints = @UniqueConstraint(name = "uk_device_imei", columnNames = "imei"))
public class Device extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -5900559872664830378L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "imei")
    private String imei;
    
    @XmlTransient
    @ManyToMany(mappedBy = "devices",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private List<User> users;
    
    @OneToOne
    @JoinColumn(name="latest_position_id", foreignKey = @ForeignKey(name = "fk_position_id__device_latestpositionid"))
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