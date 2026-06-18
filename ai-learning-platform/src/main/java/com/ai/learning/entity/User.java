package com.ai.learning.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体类
 */
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;
    
    @Column(nullable = false)
    private LocalDateTime updateTime;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();
    
    @OneToMany(mappedBy = "uploader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Resource> uploadedResources = new HashSet<>();
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<HelpRequest> helpRequests = new HashSet<>();
    
    @PrePersist
    protected void onCreate() {
        createTime = LocalDateTime.now();
        updateTime = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updateTime = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getRealName() { return realName; }
    public void setRealName(String realName) { this.realName = realName; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
    
    public Integer getPoints() { return points; }
    public void setPoints(Integer points) { this.points = points; }
    
    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
    
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    
    public LocalDateTime getCreateTime() { return createTime; }
    public LocalDateTime getUpdateTime() { return updateTime; }
    
    public Set<UserRole> getUserRoles() { return userRoles; }
    public void setUserRoles(Set<UserRole> userRoles) { this.userRoles = userRoles; }
    
    public Set<Resource> getUploadedResources() { return uploadedResources; }
    public void setUploadedResources(Set<Resource> uploadedResources) { this.uploadedResources = uploadedResources; }
    
    public Set<HelpRequest> getHelpRequests() { return helpRequests; }
    public void setHelpRequests(Set<HelpRequest> helpRequests) { this.helpRequests = helpRequests; }
}
