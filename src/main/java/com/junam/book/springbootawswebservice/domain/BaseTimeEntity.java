package com.junam.book.springbootawswebservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 들이 해당 클래스를 상속할 경우 필드들도 칼럼으로 인식된다.
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 포함
public abstract class BaseTimeEntity {

    // Entity 가 생성되어 저장될 때 시간이 자동 저장된다.
    @CreatedDate
    private LocalDateTime createDate;

    // Entity 가 변경될 때 시간이 자동 저장된다.
    @LastModifiedDate
    private  LocalDateTime modifiedDate;
}
