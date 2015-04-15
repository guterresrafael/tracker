package tracker.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Rafael Guterres
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,
         ElementType.FIELD})
public @interface Assembler {
    
    Class type() default Object.class;

    String field() default "";
}
