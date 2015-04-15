package tracker.domain.to;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import tracker.core.annotation.Assembler;
import tracker.domain.entity.Device;

/**
 *
 * @author Rafael Guterres
 */
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@XmlRootElement
@Assembler
public class UserTO {

    private Long id;
    
    private String login;
    
    private String password;
    
    @Assembler(field = "id", type = Device.class)
    private List<Long> deviceIds;

    public Long getId() {
        return id;
    }

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

    public List<Long> getDeviceIds() {
        return deviceIds;
    }

    public void setDeviceIds(List<Long> deviceIds) {
        this.deviceIds = deviceIds;
    }
}
