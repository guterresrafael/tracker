package tracker.domain.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import tracker.core.entity.BaseEntity;

/**
 *
 * @author Rafael Guterres
 */
@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "commands")
public class Command implements BaseEntity<Long> {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "device_id")
    private Device device;

    private String command;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date queued;
    
    @Temporal(TemporalType.TIMESTAMP)
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

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
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
