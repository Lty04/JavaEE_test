package com.ai.learning.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体类
 */
@Data
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 50)
    private String realName;

    @Column(length = 20)
    private String phone;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Role role = Role.STUDENT;

    @Column(nullable = false)
    private Boolean enabled = true;

    @Column(nullable = false)
    private Integer points = 0;

    @Column(length = 500)
    private String avatar;

    @Column(length = 1000)
    private String bio;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updateTime;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();

    @OneToMany(mappedBy = "uploader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Resource> uploadedResources = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<HelpRequest> helpRequests = new HashSet<>();
}
