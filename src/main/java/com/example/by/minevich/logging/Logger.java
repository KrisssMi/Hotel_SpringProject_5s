package com.example.by.minevich.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component  // аспект - компонент, который будет создан в контексте спринга
@Aspect     // аспект, который будет использоваться в приложении для логирования
@Slf4j      // логгер, чтобы не создавать его вручную
public class Logger {
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
