package com.ai.learning.service;

import com.ai.learning.entity.Resource;
import com.ai.learning.dto.AiRequest;
import com.ai.learning.dto.AiResponse;

/**
 * AI服务接口
 */
public interface AiService {
    
    /**
     * 生成资源摘要
     */
    AiResponse generateSummary(AiRequest request);
    
    /**
     * 智能推荐资源
     */
    AiResponse recommendResources(AiRequest request);
    
    /**
     * 学习问答
     */
    AiResponse answerQuestion(AiRequest request);
    
    /**
     * 内容审核
     */
    AiResponse contentModeration(AiRequest request);
    
    /**
     * 生成学习计划
     */
    AiResponse generateStudyPlan(AiRequest request);
}
