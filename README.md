# 🎓 AI赋能校园学习互助平台 - 小白入门版

> 👋 **你好！如果你是编程新手，不用担心！** 这份文档专门为你准备，用最简单的大白话教你怎么运行这个项目。

---

## 🧐 这个项目是做什么的？

想象一个**校园版的"知乎" + "AI家教"**：
- 🙋‍♂️ **提问**：遇到不会的题目？发个帖子求助！
- 🤖 **AI帮忙**：AI 助手会立刻给你解题思路（就像有个24小时在线的家教）。
- 📚 **找资料**：上传或下载学习笔记、课件。
- 💰 **赚积分**：帮助别人解答问题可以赚积分，积分能换小礼品。
- 🛡️ **安全**：只有本校同学才能注册登录。

**简单来说**：就是一个让大学生互相讲题、分享资料，还有AI帮忙的智能学习社区。

---

## 🛠️ 你需要准备什么？（环境搭建）

在开始之前，请确保你的电脑上安装了以下三个软件（如果没安装，照着下面的链接去下载安装）：

### 1. ☕ Java (JDK 17)
这是运行Java程序的"地基"。
- **怎么检查**：打开命令行（黑窗口），输入 `java -version`。如果显示版本号是 `17` 左右，就成功了。
- **下载地址**：[Oracle JDK](https://www.oracle.com/java/technologies/downloads/) 或 [OpenJDK](https://openjdk.org/)

### 2. 🏗️ Maven
这是项目的"管家"，负责自动下载项目需要的各种工具包（比如刚才报错缺少的 Spring Data）。
- **怎么检查**：命令行输入 `mvn -version`。
- **下载地址**：[Maven官网](https://maven.apache.org/download.cgi)
- **小白提示**：如果你用的是 IntelliJ IDEA 编辑器，它通常自带 Maven，可能不需要单独安装。

### 3. 🐬 数据库 (MySQL 8.0)
这是项目的"仓库"，用来存用户信息、帖子内容等数据。
- **怎么检查**：看看电脑里有没有装 MySQL。
- **下载地址**：[MySQL官网](https://dev.mysql.com/downloads/)
- **重要**：安装时记住你的**账号**（通常是 root）和**密码**，后面要用！

### 4. 💻 代码编辑器 (推荐 IntelliJ IDEA)
- **下载地址**：[JetBrains IDEA](https://www.jetbrains.com/idea/download/) (选 Community 免费版即可)

---

## 🚀 三步启动项目（保姆级教程）

### 第一步：把代码"拿"下来
如果你已经下载了代码包，解压到一个文件夹里（路径不要有中文！）。
如果你会用 Git，可以在命令行输入：
```bash
git clone <你的项目地址>
```

### 第二步：配置"仓库"连接 (最重要的一步！)
项目需要连上你的 MySQL 数据库才能运行。

1. 在你的电脑 MySQL 里创建一个空数据库，名字叫 `campus_ai_help`。
   ```sql
   CREATE DATABASE campus_ai_help CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```
2. 找到项目里的配置文件：`src/main/resources/application.properties`。
3. 用记事本或编辑器打开它，找到下面这几行，**改成你自己的数据库账号和密码**：

```properties
# 🛑 请修改这里！
spring.datasource.url=jdbc:mysql://localhost:3306/campus_ai_help?useSSL=false&serverTimezone=UTC
spring.datasource.username=root       <-- 改成你的数据库账号
spring.datasource.password=你的密码    <-- 改成你的数据库密码
spring.jpa.hibernate.ddl-auto=update <-- 这个不用改，它会自动帮你建表
```

> 💡 **刚才报错怎么办？**
> 如果你看到 `无法解析 org.springframework.data...` 这种错误：
> 1. 打开 IDEA 右侧的 **Maven** 面板。
> 2. 点击那个 **刷新图标** (两个箭头转圈圈)。
> 3. 等待底部进度条走完，它会自动下载缺少的包。

### 第三步：运行项目
1. 用 IDEA 打开这个项目文件夹（打开包含 `pom.xml` 的那个根目录）。
2. 找到启动文件：
   - 路径：`ai-learning-platform/src/main/java/com/ai/learning/CampusAiHelpApplication.java`
   - **特征**：这个文件里有一个 `public static void main` 方法，而且文件名旁边应该有个**绿色小三角形**图标 ▶️。
3. 点击那个 **绿色三角形** (Run) 或者右键选择 "Run 'CampusAiHelpApplication'"。
4. 等控制台不再滚动，出现以下字样就说明成功啦：
   ```
   ========================================
      ✓ 系统启动成功！
      🌐 访问地址：http://localhost:8080
   ========================================
   ```

> 💡 **找不到启动文件？**
> - 确保你打开的是 `ai-learning-platform` 这个文件夹作为项目根目录。
> - 在 IDEA 左侧项目树里展开：`src` → `main` → `java` → `com.ai.learning`，就能看到 `CampusAiHelpApplication.java`。

---

## 🌐 怎么使用？

启动成功后，打开浏览器访问：
👉 **http://localhost:8080**

你就能看到登录页面了！
- **默认管理员账号**：`admin` / `123456` (具体看项目初始化数据)
- **普通用户**：你可以自己注册一个新账号试试。

---

## ❓ 常见问题 (小白必看)

### Q1: 报错 "Port 8080 was already in use" 是什么意思？
**意思**：8080 端口被占用了（可能是你之前启动的项目没关掉，或者别的软件用了）。
**解决**：
- 关掉其他正在运行的 Java 程序。
- 或者在 `application.properties` 里把端口改成别的，比如 `server.port=8081`。

### Q2: 报错 "Access denied for user 'root'@'localhost'"？
**意思**：数据库账号或密码填错了。
**解决**：回去检查 `application.properties` 里的 `username` 和 `password` 是否和你安装 MySQL 时设置的一致。

### Q3: 界面是空的，或者报 404 错误？
**意思**：可能是数据库表还没生成，或者前端页面路径不对。
**解决**：
- 确保 `spring.jpa.hibernate.ddl-auto=update` 这行配置存在。
- 重启一次项目，让它自动创建表格。

### Q4: Maven 下载东西特别慢？
**解决**：可以配置阿里云镜像。打开 `pom.xml` 或者 Maven 的 `settings.xml`，添加阿里云镜像源（如果不确定怎么配，可以先试着忍一忍，有时候只是第一遍慢）。

---

## 📚 项目里都有啥？(简单看看结构)

```text
项目根目录
├── src
│   ├── main
│   │   ├── java          <-- 这里是写 Java 代码的地方 (后端逻辑)
│   │   │   ├── controller  <-- 控制层 (处理浏览器请求)
│   │   │   ├── service     <-- 服务层 (核心业务逻辑，比如AI怎么回答)
│   │   │   ├── repository  <-- 数据层 (跟数据库打交道)
│   │   │   └── entity      <-- 实体类 (对应数据库里的表，比如用户表、帖子表)
│   │   └── resources     <-- 资源文件
│   │       ├── static      <-- 放图片、CSS、JS (前端页面)
│   │       └── application.properties <-- 配置文件 (改数据库密码在这里)
└── pom.xml               <-- 项目依赖清单 (Maven 管家看的单子)
```

---

## 🤝 接下来该做什么？

恭喜你，项目已经跑起来了！作为初学者，你可以尝试：
1. **改改文字**：找到 `static` 文件夹里的 HTML 文件，把标题改成你的名字。
2. **调调颜色**：修改 CSS 文件，换个你喜欢的主题色。
3. **加点功能**：试着在 `Controller` 里加一个简单的接口，比如访问 `/hello` 就返回 "Hello World"。

---

## 📞 遇到问题怎么办？

- 仔细看报错信息的**第一行**和**最后一行**，通常写着原因。
- 把报错信息复制到百度或 Google 搜索，99% 的问题别人都遇到过。
- 如果是期末作业，记得多截图保存你的运行成果！

**祝你学习愉快，期末高分通过！ 🎉**
