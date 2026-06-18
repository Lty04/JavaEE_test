package com.ai.learning.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 操作日志实体类
 */
@Data
@Entity
@Table(name = "operation_log")
@EntityListeners(AuditingEntityListener.class)
public class OperationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String operationType;

    @Column
    private Long userId;

    @Column(length = 50)
    private String username;

    @Column(length = 50)
    private String ip;

    @Column(length = 500)
    private String description;

    @Column
    private Long durationMs;

    @Column(length = 20)
    private String status;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;
}
