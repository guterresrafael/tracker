package rs.pelotas.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import rs.pelotas.arch.entity.BaseMetaEntity;

/**
 *
 * @author Rafael Guterres
 */
@Entity
@Table(name = "user_meta")
public class UserMeta extends BaseMetaEntity {
    
    private static final long serialVersionUID = -8682189201700121363L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", foreignKey=@ForeignKey(name = "fk_user_id__usermeta_userid"))
    private User user;
    
    @Column(name = "meta_key")
    private String key;
    
    @Column(name = "meta_value")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}