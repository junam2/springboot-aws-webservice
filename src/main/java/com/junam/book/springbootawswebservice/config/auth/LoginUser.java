package com.junam.book.springbootawswebservice.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어노테이션이 생길 수 있는 위치 지정 (파라미터로 선언된 객체에서만 사용 가능)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
    // @interface : 어노테이션 클래스 지정
}
