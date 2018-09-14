## 简单介绍
springMVC是基于Servlet API，是Spring框架中最早的框架，spring5.0发布之后介绍了一个跟spring MVC平行的框架叫spring-webflux，以后慢慢学习，这篇文章主要介绍spring mvc的用法,可能会涉及到与Mybatis的整合。
//ToDo 之后补充截图
## 新建项目  
- 新建一个maven web项目,在初始化框架里选择maven-archetype-webapp,GroupId一般填写的是公司名（com.demo），ArtifactId填写项目名(ssm)；
- 新建项目路径 src/main/java 右键选择 mark Directory as sources root;src/main/resources 右键选择 mark as resources root;
- 配置tomcat 在idea界面右上角有一个配置图形，点击add Configuration面板左边有一个加号选择添加Tomcat Server->local->配置本地安装地址->部署项目 这里涉及到热部署的问题之后补充
- 运行检查一下是否无误    
                
代码整理自https://blog.csdn.net/qq598535550/article/details/51703190
## 相关配置
- pom.xml 引入相关依赖     
```
    <!-- 1.日志 -->
    <!-- 实现slf4j接口并整合 -->
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.1.1</version>
    </dependency>

    <!-- 2.数据库 -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.37</version>
      <scope>runtime</scope>
    </dependency>
    <dependency>
      <groupId>c3p0</groupId>
      <artifactId>c3p0</artifactId>
      <version>0.9.1.2</version>
    </dependency>

    <!-- DAO: MyBatis -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.3.0</version>
    </dependency>
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>1.2.3</version>
    </dependency>

    <!-- 3.Servlet web -->
    <dependency>
      <groupId>taglibs</groupId>
      <artifactId>standard</artifactId>
      <version>1.1.2</version>
    </dependency>
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.5.4</version>
    </dependency>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
    </dependency>

    <!-- 4.Spring -->
    <!-- 1)Spring核心 -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <!-- 2)Spring DAO层 -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <!-- 3)Spring web -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <!-- 4)Spring test -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>

    <!-- redis客户端:Jedis -->
    <dependency>
      <groupId>redis.clients</groupId>
      <artifactId>jedis</artifactId>
      <version>2.7.3</version>
    </dependency>
    <dependency>
      <groupId>com.dyuproject.protostuff</groupId>
      <artifactId>protostuff-core</artifactId>
      <version>1.0.8</version>
    </dependency>
    <dependency>
      <groupId>com.dyuproject.protostuff</groupId>
      <artifactId>protostuff-runtime</artifactId>
      <version>1.0.8</version>
    </dependency>

    <!-- Map工具类 -->
    <dependency>
      <groupId>commons-collections</groupId>
      <artifactId>commons-collections</artifactId>
      <version>3.2</version>
    </dependency>
```
## spring的配置文件
### springmvc  
- 在src/main/resources下建立spring文件夹存放spring的配置文件，首先配置springMVC所需要的配置文件,spring-web.xml,需要的配置主要有注解驱动，静态资源加载，视图映射,和包扫描。
- src\main\webapp\WEB-INF\web.xml 配置servlet,加载配置文件  
### 数据库相关配置   
- src\main\resources\jdbc.properties 需要配置driver,url,username和password  
### mybatis配置文件  
- 使用自增主键
- 使用列别名
- 开启驼峰命名转换 create_time -> createTime
### spring 整合 mybatis的配置文件 spring-dao.xml
- 读入数据库连接相关参数（可选）  
- 配置数据连接池  
配置连接属性，可以不读配置项文件直接在这里写死  
配置c3p0，只配了几个常用的  
- 配置SqlSessionFactory对象（mybatis）  
- 扫描dao层接口，动态实现dao接口，也就是说不需要daoImpl，sql和参数都写在xml文件上  
### spring配置service  spring-service  
- 扫描service包所有注解 @Service
- 配置事务管理器，把事务管理交由spring来完成
- 配置基于注解的声明式事务，可以直接在方法上@Transaction
### 配置日志输出 这个省略了.. logback/log4j  
## 具体实例   


## 安全框架 shiro 


