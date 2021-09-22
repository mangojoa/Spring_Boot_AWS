package com.mango.book.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
// JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우,필드들(createdDate, ModifiedDate)도 컬럼으로 인식하게 만든다.
@EntityListeners(AuditingEntityListener.class)
// BaseTimeEntitty 클래스에 Auditing 기능을 포함시킨다.
public abstract class BaseTimeEntity {

    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entuty의 값을 변경할 때, 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;
}