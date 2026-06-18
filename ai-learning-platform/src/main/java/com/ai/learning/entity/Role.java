package com.ai.learning.entity;

/**
 * 用户角色枚举
 */
public enum Role {
    ADMIN("管理员"),
    TEACHER("教师/助教"),
    STUDENT("学生");
    
    private final String description;
    
    Role(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
