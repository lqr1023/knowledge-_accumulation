### maven 路径读取问题
 转：Maven项目中获取classpath和资源文件的路径   
假设资源文件放在maven工程的 src/main/resources 资源文件夹下,源码文件放在 src/main/java/下, 那么java文件夹和resources文件夹在运行时就是classpath的真实位置,如果   
有一个文件位于 src/main/resources/test.txt  
有一个类位于 src/main/java/com/qunar/MyClass.java   
FILE_NAME = "test.txt"   
通过如下代码  
MyClass.class.getClassLoder().getResource(FILE_NAME).getPath();  
可以直接获取文件路径  
而classpath可以通过如下代码获取   
MyClass.class.getClassLoder().getResource("").getPath();       
还有一种方法可以通过当前类的加载路径使用相对路径来获取资源地址           
MyClass.class.getResource(FILE_NAME).getPath()         
那么这种就会有问题,因为此时的路径是相对于MyClass这个类在运行时路径而言的,test.txt和MyClass并不在一个层级,因为MyClass之前还有两个包      
可以如下解决        
MyClass.class.getResource(File.separator + "FILE_NAME").getPath(); // 这种方法相当于使用绝对运行时路径       
MyClass.class.getResource(".." + File.separator + ".." + File.separator + FILE_NAME).getPath(); // 这种方法相当于使用相对MyClass的运行时路径   
