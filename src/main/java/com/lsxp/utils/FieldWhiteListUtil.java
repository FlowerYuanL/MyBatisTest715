package com.lsxp.utils;

import com.lsxp.annotation.Updatable;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;


/*
* 工具类,提取带  @Updatable  的字段名
*
* 通过反射机制,自动的从某个Java类中获取字段名,作为白名单使用,这样就可以避免手动维护Set<String>
* */
public class FieldWhiteListUtil {

    /*
    *   Class<?>  :是Java的反射机制中的类类型对象
    * */
    /*接受一个类对象,如User.class*/
    public static Set<String> getUpdateFields(Class<?> clazz){
        /*用于保存所有用于更新的字段名*/
        Set<String> fields = new HashSet<>();
        /*获取这个类中定义的所有字段,包括私有字段,并遍历这些字段*/
        for(Field field : clazz.getDeclaredFields()){
            /*检查字段上是否有指定的注解(@updatable)*/
            if(field.isAnnotationPresent(Updatable.class)){
                /*将含有注解的字段名添加到结果集合*/
                fields.add(field.getName());
            }
        }
        return fields;
    }
}
