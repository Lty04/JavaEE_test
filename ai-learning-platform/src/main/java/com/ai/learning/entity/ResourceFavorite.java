package com.ai.learning.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 资源收藏实体类
 */
@Entity
@Table(name = "resource_favorites", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "resource_id"})
})
public class ResourceFavorite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;
    
    @PrePersist
    protected void onCreate() {
        createTime = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    public Resource getResource() { return resource; }
    public void setResource(Resource resource) { this.resource = resource; }
    
    public LocalDateTime getCreateTime() { return createTime; }
}
