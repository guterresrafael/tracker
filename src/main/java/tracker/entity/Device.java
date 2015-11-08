package tracker.entity;

import arch.annotation.adapters.MD5Adapter;
import arch.entity.BaseEntity;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Entity
@Table(name = "device", uniqueConstraints = @UniqueConstraint(name = "uk_device_imei", columnNames = "imei"))
public class Device extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -5900559872664830378L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "imei")
    private String imei;

    @XmlJavaTypeAdapter(MD5Adapter.class)
    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @XmlTransient
    @ManyToMany(mappedBy = "devices",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private List<User> users;

    @OneToMany(mappedBy = "device",
               fetch = FetchType.LAZY)
    private List<DeviceMeta> metadata;

    @OneToOne
    @JoinColumn(name = "latest_position_id", foreignKey = @ForeignKey(name = "fk_position_id__device_latestpositionid"))
    private Position latestPosition;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public List<DeviceMeta> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<DeviceMeta> metadata) {
        this.metadata = metadata;
    }
}
