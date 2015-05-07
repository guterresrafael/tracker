package rs.pelotas.tracker.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
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
@Table(name = "commands")
public class Command extends BaseEntity<Long> {

    private static final long serialVersionUID = -3696836637131129573L;
    
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @XmlTransient
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