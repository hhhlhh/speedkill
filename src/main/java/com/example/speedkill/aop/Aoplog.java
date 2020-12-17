package com.example.speedkill.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * import com.sun.org.slf4j.internal.Logger;
 * import com.sun.org.slf4j.internal.LoggerFactory;
 * import org.aspectj.lang.JoinPoint;
 * import org.aspectj.lang.annotation.*;
 * import org.springframework.stereotype.Component;
 * import org.springframework.web.context.request.RequestContextHolder;
 * import org.springframework.web.context.request.ServletRequestAttributes;
 * <p>
 * import javax.servlet.http.HttpServletRequest;
 */
//@Aspect
//@Component
public class Aoplog {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.example..*.*(..))")
    public void aopWebLog() {

    }

    @Before("aopWebLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("Url: " + request.getRequestURI());
        logger.info("http: " + request.getMethod());
    }

    @AfterReturning(pointcut = "aopWebLog()", returning = "retObject")
    public void doAfterReturning(Object retObject) throws Throwable {
        logger.info("answer:" + retObject);
        logger.info("time:" + (System.currentTimeMillis() - startTime.get()));
    }

    @AfterThrowing(pointcut = "aopWebLog()", throwing = "ex")
    public void addAfterThrowinglog(JoinPoint joinPoint, Exception ex) {
        logger.error("something wrong", ex);
    }
}
