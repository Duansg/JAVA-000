package org.example.routing.base.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.example.routing.base.DataSourceMergeContextHolder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.UUID;

/**
 * RouteDataSourceMergeAspect
 * @author duansg
 * @version 1.0
 */
@Aspect
@Component
@Slf4j
@Order(value = 1)
public class RouteDataSourceMergeAspect {
    /**
     * @desc
     */
    @Pointcut(value = "@annotation(org.example.routing.base.annotation.RouteDataSourceMerge)")
    private void pointcut() {

    }

    /**
     * @desc
     * @param point
     * @return
     * @throws Throwable
     */
    @Around(value = "pointcut() && @annotation(routeDataSourceMerge)")
    public Object around(ProceedingJoinPoint point, RouteDataSourceMerge routeDataSourceMerge) throws Throwable {
        //简单实现
        try{
            DataSourceMergeContextHolder.set(UUID.randomUUID().toString());
            return point.proceed();
        }finally {
            DataSourceMergeContextHolder.clear();
        }

    }
}
