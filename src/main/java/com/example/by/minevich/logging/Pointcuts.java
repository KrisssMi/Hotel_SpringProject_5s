package com.example.by.minevich.logging;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* com.example.by.minevich.controller.SignInController.userPostLogin(..))")
    public void userPostLoginPointcut() {
    }
}
