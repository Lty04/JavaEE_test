package com.ai.learning.entity;

/**
 * 审核状态枚举
 */
public enum AuditStatus {
    PENDING("待审核"),
    APPROVED("已通过"),
    REJECTED("已拒绝");
    
    private final String description;
    
    AuditStatus(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
