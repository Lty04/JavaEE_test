# AI赋能校园学习互助平台

## 项目简介

本项目是一个基于JavaEE技术栈开发的校园学习互助平台，融合了AI智能辅助功能，旨在为在校师生提供一个高效、便捷的学习交流与资源共享环境。平台支持用户发布学习求助、分享课程资源、获取AI智能解答等功能，并通过积分激励机制促进用户积极参与。

## 技术栈

### 后端技术
- **Java**: 17
- **Spring Framework**: 5.3.30
- **Spring Security**: 5.7.11 (安全认证与授权)
- **Hibernate**: 5.6.15.Final (ORM框架)
- **JPA**: 2.2
- **MySQL**: 8.0.33
- **HikariCP**: 4.0.3 (数据库连接池)
- **Jackson**: 2.15.3 (JSON处理)
- **Logback**: 1.4.11 (日志框架)
- **Maven**: 项目管理与构建

### 前端技术
- **JSP**: 页面模板
- **JSTL**: 标签库
- **HTML5/CSS3/JavaScript**

### 开发工具
- **IDE**: IntelliJ IDEA / Eclipse
- **应用服务器**: Apache Tomcat 9.x
- **构建工具**: Maven 3.x

## 项目结构

```
ai-learning-platform/
├── src/
│   ├── main/
│   │   ├── java/com/ai/learning/
│   │   │   ├── entity/          # 实体类
│   │   │   │   ├── User.java           # 用户实体
│   │   │   │   ├── Role.java           # 角色实体
│   │   │   │   ├── UserRole.java       # 用户角色关联
│   │   │   │   ├── Course.java         # 课程实体
│   │   │   │   ├── Resource.java       # 学习资源实体
│   │   │   │   ├── ResourceFavorite.java   # 资源收藏
│   │   │   │   ├── ResourceRating.java     # 资源评分
│   │   │   │   ├── HelpRequest.java        # 求助请求
│   │   │   │   ├── HelpComment.java        # 求助评论
│   │   │   │   ├── AiLog.java              # AI交互日志
│   │   │   │   ├── PointRecord.java        # 积分记录
│   │   │   │   ├── OperationLog.java       # 操作日志
│   │   │   │   ├── AuditStatus.java        # 审核状态枚举
│   │   │   │   └── HelpStatus.java         # 求助状态枚举
│   │   │   ├── repository/        # 数据访问层
│   │   │   │   ├── UserRepository.java
│   │   │   │   ├── CourseRepository.java
│   │   │   │   ├── ResourceRepository.java
│   │   │   │   ├── HelpRequestRepository.java
│   │   │   │   ├── AiLogRepository.java
│   │   │   │   └── ...
│   │   │   ├── service/           # 服务层
│   │   │   │   ├── AiService.java
│   │   │   │   └── impl/
│   │   │   │       └── AiServiceImpl.java
│   │   │   ├── dto/               # 数据传输对象
│   │   │   │   ├── AiRequest.java
│   │   │   │   └── AiResponse.java
│   │   │   └── config/            # 配置类
│   │   ├── webapp/
│   │   │   ├── WEB-INF/
│   │   │   │   ├── web.xml              # Web应用配置
│   │   │   │   ├── spring-config.xml    # Spring配置
│   │   │   │   └── views/               # JSP视图
│   │   │   ├── static/                  # 静态资源
│   │   │   │   ├── css/
│   │   │   │   ├── js/
│   │   │   │   └── images/
│   │   │   └── index.jsp                # 首页
│   │   └── resources/
│   │       ├── logback.xml              # 日志配置
│   │       └── database/
│   │           └── schema.sql           # 数据库初始化脚本
│   └── test/                            # 测试代码
├── pom.xml                              # Maven配置文件
└── README.md                            # 项目说明文档
```

## 核心功能模块

### 1. 用户管理模块
- 用户注册与登录（支持学号/工号认证）
- 角色管理（学生、教师、管理员）
- 个人信息管理
- 积分系统管理

### 2. 课程资源模块
- 课程信息管理
- 学习资源上传与下载
- 资源分类与标签
- 资源收藏与评分
- 资源审核机制

### 3. 学习求助模块
- 发布学习问题
- 问题回答与评论
- 问题状态跟踪（待解决、已解决、已关闭）
- 最佳答案评选

### 4. AI智能辅助模块
- AI智能问答
- 学习建议推荐
- 问题自动分类
- AI交互记录查询

### 5. 积分激励模块
- 积分获取规则
  - 发布优质资源
  - 解答他人问题
  - 获得好评
- 积分消费规则
  - 下载 premium 资源
  - 优先获取AI解答
- 积分排行榜

### 6. 系统管理模块
- 内容审核管理
- 用户行为监控
- 操作日志审计
- 系统数据统计

## 数据库设计

### 主要数据表

| 表名 | 说明 |
|------|------|
| users | 用户信息表 |
| roles | 角色信息表 |
| user_roles | 用户角色关联表 |
| courses | 课程信息表 |
| resources | 学习资源表 |
| resource_favorites | 资源收藏表 |
| resource_ratings | 资源评分表 |
| help_requests | 求助请求表 |
| help_comments | 求助评论表 |
| ai_logs | AI交互日志表 |
| point_records | 积分记录表 |
| operation_logs | 操作日志表 |

## 快速开始

### 环境要求
- JDK 17+
- MySQL 8.0+
- Maven 3.6+
- Tomcat 9.x

### 安装步骤

#### 1. 克隆项目
```bash
git clone <repository-url>
cd ai-learning-platform
```

#### 2. 配置数据库
创建MySQL数据库并执行初始化脚本：
```sql
CREATE DATABASE ai_learning_platform CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE ai_learning_platform;
SOURCE src/main/resources/database/schema.sql;
```

#### 3. 修改配置文件
编辑 `src/main/webapp/WEB-INF/spring-config.xml`，配置数据库连接：
```xml
<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource">
    <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/ai_learning_platform?useSSL=false&amp;serverTimezone=UTC"/>
    <property name="username" value="your_username"/>
    <property name="password" value="your_password"/>
</bean>
```

#### 4. 编译项目
```bash
mvn clean compile
```

#### 5. 打包部署
```bash
mvn clean package
```

生成的WAR文件位于 `target/ai-learning-platform.war`

#### 6. 运行项目

**方式一：使用Tomcat Maven插件**
```bash
mvn tomcat7:run
```
访问地址：http://localhost:8080/

**方式二：部署到Tomcat服务器**
1. 将 `target/ai-learning-platform.war` 复制到Tomcat的 `webapps` 目录
2. 启动Tomcat服务器
3. 访问地址：http://localhost:8080/ai-learning-platform/

## API接口说明

### 用户相关接口
| 接口 | 方法 | 描述 |
|------|------|------|
| /api/user/register | POST | 用户注册 |
| /api/user/login | POST | 用户登录 |
| /api/user/profile | GET | 获取个人信息 |
| /api/user/profile | PUT | 更新个人信息 |

### 资源相关接口
| 接口 | 方法 | 描述 |
|------|------|------|
| /api/resources | GET | 获取资源列表 |
| /api/resources/{id} | GET | 获取资源详情 |
| /api/resources | POST | 上传资源 |
| /api/resources/{id}/favorite | POST | 收藏资源 |
| /api/resources/{id}/rating | POST | 评分资源 |

### 求助相关接口
| 接口 | 方法 | 描述 |
|------|------|------|
| /api/help-requests | GET | 获取求助列表 |
| /api/help-requests/{id} | GET | 获取求助详情 |
| /api/help-requests | POST | 发布求助 |
| /api/help-requests/{id}/comment | POST | 发表评论 |

### AI相关接口
| 接口 | 方法 | 描述 |
|------|------|------|
| /api/ai/query | POST | AI智能问答 |
| /api/ai/recommend | GET | 获取学习推荐 |
| /api/ai/logs | GET | 查询AI交互历史 |

## 安全特性

- **认证机制**: 基于Spring Security的用户认证
- **授权管理**: 基于角色的访问控制（RBAC）
- **密码加密**: BCrypt密码哈希算法
- **会话管理**:安全的Session管理策略
- **XSS防护**: 输入验证与输出编码
- **CSRF防护**: CSRF Token机制

## 开发规范

### 代码规范
- 遵循阿里巴巴Java开发手册
- 使用统一的命名规范
- 保持代码注释完整
- 编写单元测试

### Git工作流
```bash
# 创建功能分支
git checkout -b feature/feature-name

# 提交代码
git commit -m "feat: 添加新功能"

# 推送到远程
git push origin feature/feature-name

# 创建Pull Request
```

### 提交信息规范
- `feat`: 新功能
- `fix`: 修复bug
- `docs`: 文档更新
- `style`: 代码格式调整
- `refactor`: 代码重构
- `test`: 测试相关
- `chore`: 构建/工具链相关

## 测试

### 运行单元测试
```bash
mvn test
```

### 生成测试报告
```bash
mvn clean test jacoco:report
```

测试报告位于 `target/site/jacoco/index.html`

## 常见问题

### Q1: 数据库连接失败
检查MySQL服务是否启动，确认配置文件中的数据库连接信息正确。

### Q2: 端口被占用
修改 `pom.xml` 中Tomcat插件的端口配置，或关闭占用端口的进程。

### Q3: 中文乱码
确保数据库、JSP页面、配置文件均使用UTF-8编码。

## 项目成员

| 角色 | 职责 |
|------|------|
| 项目负责人 | 整体架构设计与项目管理 |
| 后端开发 | 业务逻辑实现与API开发 |
| 前端开发 | 页面设计与交互实现 |
| 测试工程师 | 测试用例编写与质量保障 |

## 许可证

本项目采用 MIT 许可证。详见 [LICENSE](LICENSE) 文件。

## 联系方式

如有问题或建议，请通过以下方式联系：
- Email: support@ai-learning-platform.com
- GitHub Issues: [提交Issue](https://github.com/your-repo/issues)

## 更新日志

### v1.0.0 (2024-01-01)
- ✨ 初始版本发布
- ✅ 实现用户管理功能
- ✅ 实现课程资源管理
- ✅ 实现学习求助功能
- ✅ 集成AI智能问答
- ✅ 建立积分激励机制

---

**注意**: 本项目为JavaEE应用程序开发课程的期末大作业，仅供学习交流使用。