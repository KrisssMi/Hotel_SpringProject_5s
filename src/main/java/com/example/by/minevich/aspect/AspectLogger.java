package com.example.by.minevich.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;

@Aspect
@Component
public class AspectLogger {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AspectLogger.class);

    @Pointcut("execution(* com.example.by.minevich.controller.MainController.*(..))")
    public void calledAtMainController(){}

    @After("calledAtMainController()")
    public void log(JoinPoint point) {
        log.info(point.getSignature().getName() + " called...");
    }

    @Pointcut("execution(* com.example.by.minevich.controller.RoomController.*(..))")
    public void calledAtRoomController(){}

    @After("calledAtRoomController()")
    public void log2(JoinPoint point) {
        log.info(point.getSignature().getName() + " called...");
    }

    @Pointcut("execution(* com.example.by.minevich.controller.UserController.*(..))")
    public void calledAtUserController(){}

    @After("calledAtUserController()")
    public void log3(JoinPoint point) {
        log.info(point.getSignature().getName() + " called...");
    }
}
