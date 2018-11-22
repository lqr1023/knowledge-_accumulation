## spring-boot 项目实例
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
### tomcat下运行打包和配置
1.修改pom.xml
```
    <groupId>org.springframework</groupId>
    <artifactId>gs-uploading-files</artifactId>
    <packaging>war</packaging>
    <version>0.1.0</version>
```
修改发布的项目名称,定义为filesDemo  
```
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
        <finalName>filesDemo</finalName>
    </build>
```
直接使用maven进行打成war包；
2.在tomcat下运行根目录是localhost:8080/，默认情况下springboot项目的根目录是localhost:8080/ 在application.properties下添加配置：
```
server.servlet.context-path=/filesDemo
```
3.这里总结一下遇到的路径错误问题：      
> 直接转发和简介转发的问题： https://www.cnblogs.com/selene/p/4518246.html   
> web的路径问题：https://www.cnblogs.com/fnz0/p/5595546.html    
   
总结：web环境下的路径分成两种，一种是由服务器进行处理的路径如请求转发路径,还有一种是由浏览器发起的路径，比如action的路径，重定向，资源路径，超链接；如果是服务器处理的路径可以不同带项目名称，前端处理的路径必须带着项目名称；    
例：按照步骤2配置好项目名称之后       
```
		<form method="POST" th:action="@{/}" enctype="multipart/form-data">
			<table>
				<tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
				<tr><td></td><td><input type="submit" value="Upload" /></td></tr>
			</table>
		</form>
```
前端处理请求action,进行文件上传，action="/"会报404.这里使用了thymeleaf表达式进行模板替换，会自动转成action="/项目名/actionname";   
```
@PostMapping (value = "/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }
```
PostMapping和redirect不用配置项目名称；    
```
@Override
    public void store(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                    StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }
```
以上代码是spring官方示例中上传文件的一段代码，上传的路径获取是this.rootLocation.resolve(filename) 发布到tomcat里会在tomcatxxx/bin下创建文件夹；




