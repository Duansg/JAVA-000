package org.example.routing.base.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.routing.base.DataSourceContextHolder;
import org.example.routing.enums.RouteSourceEnum;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;

/**
 * @author Duansg
 */
@Aspect
@Component
@Slf4j
@Order(value = 1)
public class RouteDataSourceAspect {

    /**
     * @desc
     */
    @Pointcut(value = "@annotation(org.example.routing.base.annotation.RouteDataSource)")
    private void pointcut() {

    }

    /**
     * @desc
     * @param point
     * @return
     * @throws Throwable
     */
    @Around(value = "pointcut() && @annotation(routeDataSource)")
    public Object around(ProceedingJoinPoint point, RouteDataSource routeDataSource) throws Throwable {
        try {
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            RouteDataSource annotation = method.getAnnotation(RouteDataSource.class);
            if (ObjectUtils.isEmpty(annotation)){
                DataSourceContextHolder.set(RouteSourceEnum.MASTER.getDataSourceName());
            }else {
                DataSourceContextHolder.set(routeDataSource.target().getDataSourceName());
            }
            return point.proceed();
        }finally {
            DataSourceContextHolder.clear();
        }

    }

}
