spring-boot 项目实例
### 新建web项目 
- 使用idea创建项目，选择Spring Initializr模板，填写相关信息，Dependences选择web；
- 直接访问https://start.spring.io/ 创建项目,填写相关信息，Dependences选择web;
### controller示例编写
src/main/java/com/demo/spring-boot/controller/HelloController.java
```
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String say(){
        return "Hello";
    }
}
```    
运行程序:  
```
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
```
访问localhost:8080/hello 可以看到返回的字符串信息；



