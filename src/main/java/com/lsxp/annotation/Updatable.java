package com.lsxp.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/*
* 下述代码是注解类updatable的元注解，用来描述这个注解本身的行为和作用范围,用于定义注解的注解
* @Retention用于指定该注解在什么阶段会被保留
* RUNNTIME表示编译后保留,并且运行时可以通过反射访问
* @Target指定注解可以用在程序的哪些地方
* FIELD指代字段(成员变量)
* */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Updatable {
}
