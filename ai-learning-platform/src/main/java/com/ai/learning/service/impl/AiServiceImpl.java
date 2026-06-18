package com.ai.learning.service.impl;

import com.ai.learning.dto.AiRequest;
import com.ai.learning.dto.AiResponse;
import com.ai.learning.entity.AiLog;
import com.ai.learning.entity.User;
import com.ai.learning.repository.AiLogRepository;
import com.ai.learning.repository.UserRepository;
import com.ai.learning.service.AiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * AI服务实现类（Mock模式）
 * 支持配置真实API或Mock模式
 */
@Service
public class AiServiceImpl implements AiService {
    
    private static final Logger logger = LoggerFactory.getLogger(AiServiceImpl.class);
    
    @Autowired
    private AiLogRepository aiLogRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Value("${ai.enabled:true}")
    private boolean aiEnabled;
    
    @Value("${ai.mode:mock}")
    private String aiMode; // mock 或 real
    
    @Value("${ai.api.url:}")
    private String apiUrl;
    
    @Value("${ai.api.key:}")
    private String apiKey;
    
    @Override
    public AiResponse generateSummary(AiRequest request) {
        logger.info("Generating summary for content: {}", truncate(request.getContent(), 50));
        long startTime = System.currentTimeMillis();
        
        AiResponse response;
        if ("real".equals(aiMode) && aiEnabled && apiUrl != null && !apiUrl.isEmpty()) {
            response = callRealApi(request);
        } else {
            response = mockSummary(request);
        }
        
        logAiCall(request, response, startTime);
        return response;
    }
    
    @Override
    public AiResponse recommendResources(AiRequest request) {
        logger.info("Generating recommendations for user: {}", request.getUserId());
        long startTime = System.currentTimeMillis();
        
        AiResponse response;
        if ("real".equals(aiMode) && aiEnabled && apiUrl != null && !apiUrl.isEmpty()) {
            response = callRealApi(request);
        } else {
            response = mockRecommendation(request);
        }
        
        logAiCall(request, response, startTime);
        return response;
    }
    
    @Override
    public AiResponse answerQuestion(AiRequest request) {
        logger.info("Answering question: {}", truncate(request.getContent(), 50));
        long startTime = System.currentTimeMillis();
        
        AiResponse response;
        if ("real".equals(aiMode) && aiEnabled && apiUrl != null && !apiUrl.isEmpty()) {
            response = callRealApi(request);
        } else {
            response = mockQa(request);
        }
        
        logAiCall(request, response, startTime);
        return response;
    }
    
    @Override
    public AiResponse contentModeration(AiRequest request) {
        logger.info("Moderating content: {}", truncate(request.getContent(), 50));
        long startTime = System.currentTimeMillis();
        
        AiResponse response;
        if ("real".equals(aiMode) && aiEnabled && apiUrl != null && !apiUrl.isEmpty()) {
            response = callRealApi(request);
        } else {
            response = mockModeration(request);
        }
        
        logAiCall(request, response, startTime);
        return response;
    }
    
    @Override
    public AiResponse generateStudyPlan(AiRequest request) {
        logger.info("Generating study plan for user: {}", request.getUserId());
        long startTime = System.currentTimeMillis();
        
        AiResponse response;
        if ("real".equals(aiMode) && aiEnabled && apiUrl != null && !apiUrl.isEmpty()) {
            response = callRealApi(request);
        } else {
            response = mockStudyPlan(request);
        }
        
        logAiCall(request, response, startTime);
        return response;
    }
    
    /**
     * Mock资源摘要
     */
    private AiResponse mockSummary(AiRequest request) {
        String content = request.getContent();
        if (content == null || content.isEmpty()) {
            return AiResponse.error("内容为空，无法生成摘要");
        }
        
        // 模拟摘要：取前200字符作为摘要
        String summary = content.length() > 200 ? content.substring(0, 200) + "..." : content;
        
        // 模拟关键词提取
        List<String> keywords = Arrays.asList("Java", "编程", "学习", "教程");
        
        AiResponse response = AiResponse.success("摘要生成成功", summary);
        response.setKeywords(keywords);
        return response;
    }
    
    /**
     * Mock智能推荐
     */
    private AiResponse mockRecommendation(AiRequest request) {
        List<Map<String, Object>> recommendations = new ArrayList<>();
        
        // 模拟推荐数据
        Map<String, Object> rec1 = new HashMap<>();
        rec1.put("id", 1L);
        rec1.put("title", "Java基础教程");
        rec1.put("type", "课件");
        rec1.put("reason", "基于您的浏览历史");
        
        Map<String, Object> rec2 = new HashMap<>();
        rec2.put("id", 2L);
        rec2.put("title", "Spring框架入门");
        rec2.put("type", "代码示例");
        rec2.put("reason", "与您收藏的资源相关");
        
        Map<String, Object> rec3 = new HashMap<>();
        rec3.put("id", 3L);
        rec3.put("title", "数据库设计原则");
        rec3.put("type", "常见问题");
        rec3.put("reason", "热门资源推荐");
        
        recommendations.add(rec1);
        recommendations.add(rec2);
        recommendations.add(rec3);
        
        AiResponse response = AiResponse.success("推荐生成成功", null);
        response.setRecommendations(recommendations);
        return response;
    }
    
    /**
     * Mock学习问答
     */
    private AiResponse mockQa(AiRequest request) {
        String question = request.getContent();
        if (question == null || question.isEmpty()) {
            return AiResponse.error("问题内容为空");
        }
        
        String answer = "根据平台资源，关于\"" + truncate(question, 30) + "\"的问题，建议您参考以下资源：\n" +
                "1. 《Java基础教程》- 第3章\n" +
                "2. 《Spring框架入门》- 第2节\n" +
                "3. 常见问题：如何配置开发环境\n\n" +
                "如需更详细的解答，请向老师或同学提问。";
        
        return AiResponse.success("回答完成", answer);
    }
    
    /**
     * Mock内容审核
     */
    private AiResponse mockModeration(AiRequest request) {
        String content = request.getContent();
        if (content == null || content.isEmpty()) {
            return AiResponse.error("内容为空");
        }
        
        // 简单的敏感词检测（模拟）
        String[] sensitiveWords = {"广告", "推销", "垃圾信息"};
        boolean hasSensitive = false;
        for (String word : sensitiveWords) {
            if (content.contains(word)) {
                hasSensitive = true;
                break;
            }
        }
        
        if (hasSensitive) {
            AiResponse response = AiResponse.success("内容审核完成", "检测到可能违规的内容，建议人工复核");
            response.setData(Collections.singletonMap("suggestedAction", "REVIEW"));
            return response;
        }
        
        AiResponse response = AiResponse.success("内容审核通过", "内容符合规范");
        response.setData(Collections.singletonMap("suggestedAction", "APPROVE"));
        return response;
    }
    
    /**
     * Mock学习计划生成
     */
    private AiResponse mockStudyPlan(AiRequest request) {
        String plan = "阶段性复习计划：\n\n" +
                "第1周：复习Java基础语法，完成相关练习\n" +
                "第2周：学习面向对象编程，理解继承、封装、多态\n" +
                "第3周：掌握集合框架和异常处理\n" +
                "第4周：学习IO流和文件操作\n" +
                "第5周：综合实践，完成一个小项目\n\n" +
                "建议每天学习2小时，周末进行复习总结。";
        
        return AiResponse.success("学习计划生成成功", plan);
    }
    
    /**
     * 调用真实API（预留接口）
     */
    private AiResponse callRealApi(AiRequest request) {
        // TODO: 实现真实的大模型API调用
        // 这里可以接入OpenAI、文心一言、通义千问等API
        logger.warn("真实API调用尚未实现，使用Mock响应");
        return mockSummary(request);
    }
    
    /**
     * 记录AI调用日志
     */
    private void logAiCall(AiRequest request, AiResponse response, long startTime) {
        try {
            AiLog aiLog = new AiLog();
            
            if (request.getUserId() != null) {
                Optional<User> userOpt = userRepository.findById(request.getUserId());
                userOpt.ifPresent(aiLog::setUser);
            }
            
            aiLog.setFunctionType(request.getFunctionType());
            aiLog.setRequestSummary(truncate(request.getContent(), 200));
            aiLog.setResponseSummary(truncate(response.getResult(), 200));
            aiLog.setDuration(System.currentTimeMillis() - startTime);
            aiLog.setSuccess(response.getSuccess());
            
            aiLogRepository.save(aiLog);
        } catch (Exception e) {
            logger.error("记录AI日志失败", e);
        }
    }
    
    /**
     * 截断字符串
     */
    private String truncate(String str, int maxLen) {
        if (str == null) return "";
        return str.length() > maxLen ? str.substring(0, maxLen) : str;
    }
}
