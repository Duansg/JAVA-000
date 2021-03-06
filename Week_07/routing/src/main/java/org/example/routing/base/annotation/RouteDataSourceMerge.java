package org.example.routing.base.annotation;

import org.example.routing.enums.RouteSourceEnum;

import java.lang.annotation.*;

/**
 * @author Duansg
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RouteDataSourceMerge {

}
