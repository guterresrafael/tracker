package tracker.core.entity;

import java.io.Serializable;

/**
 *
 * @author Rafael Guterres
 * @param <IdType>
 */
public interface BaseEntity<IdType extends Serializable> 
         extends Serializable {
    
    IdType getId();
    
    void setId(IdType id);
}
