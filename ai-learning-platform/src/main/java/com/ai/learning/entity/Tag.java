package com.ai.learning.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 标签实体类
 */
@Data
@Entity
@Table(name = "tag")
@EntityListeners(AuditingEntityListener.class)
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(length = 200)
    private String description;

    @Column(nullable = false)
    private Integer usageCount = 0;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;
}
