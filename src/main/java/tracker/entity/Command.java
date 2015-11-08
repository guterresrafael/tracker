package tracker.entity;

import arch.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rafael Guterres
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "command")
public class Command extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -3696836637131129573L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "device_id", foreignKey = @ForeignKey(name = "fk_device_id__command_deviceid"))
    private Device device;

    @Column(name = "commands")
    private String commands;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "queued")
    private Date queued;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "executed")
    private Date executed;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public Date getQueued() {
        return queued;
    }

    public void setQueued(Date queued) {
        this.queued = queued;
    }

    public Date getExecuted() {
        return executed;
    }

    public void setExecuted(Date executed) {
        this.executed = executed;
    }
}
