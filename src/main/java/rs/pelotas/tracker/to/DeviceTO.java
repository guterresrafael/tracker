package rs.pelotas.tracker.to;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rafael Guterres
 */
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@XmlRootElement
public class DeviceTO {
    
    private Long id;
    private String name;
    private String imei;
    private List<Long> usersId;
    private Long latestPositionId;

    public Long getId() {
        return id;
    }

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

    public List<Long> getUsersId() {
        return usersId;
    }

    public void setUsersId(List<Long> usersId) {
        this.usersId = usersId;
    }

    public Long getLatestPositionId() {
        return latestPositionId;
    }

    public void setLatestPositionId(Long latestPositionId) {
        this.latestPositionId = latestPositionId;
    }

}
