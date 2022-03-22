package com.junam.book.springbootawswebservice.config.auth.dto;

import com.junam.book.springbootawswebservice.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.h2.engine.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    // @LoginUser 어노테이션을 위해서 빈 SessionUser 생성 -> 로그인 하지 않았을 경우
    public SessionUser() {

    }

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
