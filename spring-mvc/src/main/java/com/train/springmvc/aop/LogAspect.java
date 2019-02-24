package com.train.springmvc.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Slf4j
@Component
public class LogAspect {

    @Pointcut("execution(public * com.train.springmvc.api.*.*(..)) || execution(public * com.train.springmvc.controller.*.*(..))")
    public void weblog() {

    }

    @Before(value = "weblog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = servletRequestAttributes.getRequest();

        log.info("-------------------WebLogAspect begin");

        log.info(" URL = " + request.getRequestURI().toString());

        log.info(" HTTP METHOD = " + request.getMethod());

        log.info(" IP = " + request.getRemoteAddr());

        Enumeration<String> enumeration = request.getParameterNames();

        while (enumeration.hasMoreElements()) {

            String name = enumeration.nextElement();

            log.info("name:{},value{}", name, request.getParameter(name));

        }

    }


    @AfterReturning(returning = "ret", pointcut = "weblog()")
    public void doAfter(Object ret) throws Throwable {

        log.info("-------------------WebLogAspect end:" + ret);

    }

}
