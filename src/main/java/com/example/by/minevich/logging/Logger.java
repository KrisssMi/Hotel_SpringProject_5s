package com.example.by.minevich.logging;

import com.example.by.minevich.controller.SignInController;
import com.example.by.minevich.exception.NonExistedUserException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class Logger {
    //"Pointcut" - точка, в которой будет вызываться аспект, в данном случае - метод, помеченный аннотацией @Loggable

    @Before (value = "Pointcuts.userPostLoginPointcut()")   // перед вызовом метода
    public void userPostLoginLog() {
        Logger logger = (Logger) LoggerFactory.getLogger(SignInController.class);
        ((org.slf4j.Logger) logger).info("userPostLogin method is called");
    }

    @After (value = "Pointcuts.userPostLoginPointcut()")    // после вызова метода
    public void userPostLoginAfterLog() {
        Logger logger = (Logger) LoggerFactory.getLogger(SignInController.class);
        ((org.slf4j.Logger) logger).info("userPostLogin method is finished");
    }

    @Pointcut("@annotation(Loggable)")  // точка среза, которая будет использоваться в аспекте, чтобы определить, какие методы логировать
    public void webServiceMethod() { }  // метод, который будет использоваться в аспекте, чтобы определить, какие методы логировать

    @Around("webServiceMethod()")       // аспект, который будет использоваться в приложении для логирования
    public Object logWebServiceCall(org.aspectj.lang.ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName(); // имя метода
        Object[] methodArgs = thisJoinPoint.getArgs();              // аргументы метода
        log.info("Method: " + methodName + ", args: " + java.util.Arrays.toString(methodArgs));
        Object result = thisJoinPoint.proceed();           // вызов метода
        log.info("Method " + methodName + " returns " + result);

        return result;
    }
}
