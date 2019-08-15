package com.xiao.annontion;

import com.xiao.AopFilter;
import com.xiao.Car;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Carl-Xiao 2019-08-15
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({AopFilter.class, Car.class})
public @interface HighAopMethod {
}
