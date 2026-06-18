package com.ai.learning.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 课程资源实体类
 */
@Data
@Entity
@Table(name = "resource")
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = "id")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private ResourceType type;

    @Column(length = 500)
    private String filePath;

    @Column(length = 500)
    private String fileUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @EqualsAndHashCode.Exclude
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploader_id")
    @EqualsAndHashCode.Exclude
    private User uploader;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AuditStatus auditStatus = AuditStatus.PENDING;

    @Column(nullable = false)
    private Integer viewCount = 0;

    @Column(nullable = false)
    private Integer downloadCount = 0;

    @Column(length = 500)
    private String tags;

    @Column(length = 100)
    private String chapter;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;

    @Column(nullable = false)
    private LocalDateTime updateTime;

    /**
     * 资源类型枚举
     */
    public enum ResourceType {
        DOCUMENT,      // 文档
        VIDEO,         // 视频
        CODE,          // 代码
        IMAGE,         // 图片
        LINK,          // 链接
        OTHER          // 其他
    }
}
