package tracker.core.annotation;

import tracker.core.annotation.CriteriaFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import tracker.core.filter.BaseFilter;
import tracker.core.repository.TrackerRepositoryImpl;
import tracker.core.utils.Reflection;

/**
 *
 * @author Rafael Guterres
 */
public class CriteriaFilterImpl {
    
    public static void applyCriteriaFilterAnnotations(CriteriaBuilder criteriaBuilder,
                                                      CriteriaQuery<?> criteriaQuery,
                                                      Root<?> root,
                                                      BaseFilter filter) {
        List<Field> fields = new ArrayList<>();
        Reflection.getAllFields(fields, filter.getClass());
        for (Field field : fields) {
            field.setAccessible(true);
            Object fieldValue = null;
            try {
                fieldValue = field.get(filter);
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(TrackerRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (fieldValue != null && field.isAnnotationPresent(CriteriaFilter.class)) {
                CriteriaFilter criteriaFilter = field.getAnnotation(CriteriaFilter.class);
                switch (criteriaFilter.method()) {
                    case EQUAL:
                        criteriaQuery.where(criteriaBuilder.equal(root.get(field.getName()), fieldValue));
                        break;
                    case BETWEEN:
                        //TODO: Implementar consulta
                        break;
                }
            }
        }
    }
}
