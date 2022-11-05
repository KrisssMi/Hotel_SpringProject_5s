package com.example.by.minevich.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)         // аннотация применяется к методу, чтобы можно было ее использовать в аспекте
@Retention(RetentionPolicy.RUNTIME) // аннотация доступна во время выполнения программы
public @interface Loggable {        // аннотация Loggable
}
