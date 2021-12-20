package com.example.demo.entitiy;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    @Column(name = "create_at")
    @Builder.Default
    private Long createAt = new Date().getTime();

    @Column(name = "update_at")
    @Builder.Default
    private Long updateAt;

    @Column(name = "is_deleted")
    @Builder.Default
    private Boolean isDeleted = false;


}
