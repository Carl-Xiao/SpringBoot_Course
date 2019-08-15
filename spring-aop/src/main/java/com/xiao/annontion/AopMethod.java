package com.xiao.annontion;

import java.lang.annotation.*;

/**
 * @author Carl-Xiao 2019-08-14
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface AopMethod {

}
