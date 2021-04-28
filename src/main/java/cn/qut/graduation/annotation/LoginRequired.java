package cn.qut.graduation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 拦截标识
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)//运行时有效
public @interface LoginRequired {
}
