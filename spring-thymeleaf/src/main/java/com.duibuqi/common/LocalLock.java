package com.duibuqi.common;

import java.lang.annotation.*;

/**
 * @author CC 2018-06-15
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {

    String key() default "";

}
