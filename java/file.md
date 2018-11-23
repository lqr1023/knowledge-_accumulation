### 相对路径与绝对路径的转化
jdk1.8
```
Path p1 = Paths.get("D:\\a\\b\\imgs");
Path p2 = new File(Application.class.getClassLoader().getResource("").getPath()).toPath();
Path p2ToP1 = p2.relativize(p1);
System.out.println(p2ToP1);
```
输出：
```
..\..\..\..\..\a\b\imgs 
```   
在p2目录下获取p1的相对路径；
