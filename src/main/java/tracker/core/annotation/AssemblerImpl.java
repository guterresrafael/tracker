package tracker.core.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tracker.core.utils.Reflection;

/**
 *
 * @author Rafael Guterres
 */
public class AssemblerImpl {
    
    public static void assembler(Object objectFrom, Object objectTo) {
        try {
            List<Field> fieldsFrom = new ArrayList<>();
            List<Field> fieldsTo = new ArrayList<>();
            Reflection.getAllFields(fieldsFrom, objectFrom.getClass());
            Reflection.getAllFields(fieldsTo, objectTo.getClass());
            for (Field fieldTo : fieldsTo) {
                for (Field fieldFrom : fieldsFrom) {
                    if (fieldTo.getName().equals(fieldFrom.getName())) {
                        fieldTo.setAccessible(true);
                        fieldFrom.setAccessible(true);
                        if (fieldTo.getType() == fieldFrom.getType()) {
                            fieldTo.set(objectTo, fieldFrom.get(objectFrom));
                        } else {
                            //TODO: Implementar annotation para quando forem types diferentes
                        }
                    } else {
                        //TODO: Implementar annotation para quando forem nomes diferentes
                    }
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            //TODO: Implementar tratamento de exceção
        }
    }
    
    public static void assembler(Map<String, String> mapFrom, Object objectTo) {
        try {
            List<Field> fieldsTo = new ArrayList<>();
            Reflection.getAllFields(fieldsTo, objectTo.getClass());
            for (Field fieldTo : fieldsTo) {
                for (Map.Entry<String, String> fieldFrom : mapFrom.entrySet()) {
                    if (fieldTo.getName().equals(fieldFrom.getKey())) {
                        fieldTo.setAccessible(true);
                        if (fieldTo.getType() == String.class) {
                            fieldTo.set(objectTo, fieldFrom.getValue());
                        } else if (fieldTo.getType() == Integer.class) {
                            fieldTo.set(objectTo, Integer.parseInt(fieldFrom.getValue()));
                        } else {
                            //TODO: Implementar annotation para quando forem types diferentes
                        }
                    } else {
                        //TODO: Implementar annotation para quando forem nomes diferentes
                    }
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            //TODO: Implementar tratamento de exceção
        }
    }
}
