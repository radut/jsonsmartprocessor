package org.jsonsmart;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Radu Toader [radu.m.toader@gmail.com]
 * 
 */
@Target( { ElementType.FIELD,
// field
        ElementType.METHOD } )
// method headers
@Retention( RetentionPolicy.RUNTIME )
public @interface JsonSmart {
    boolean enabled() default true;
    
    JsonSmartSerializationType type() default JsonSmartSerializationType.BOTH;
    
    String name() default "";
    
    Class classType() default Object.class;
    
}
