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
### web项目下 MultipartFile 和 File的转化
```
String fileName = multfile.getOriginalFilename();
// 获取文件后缀
String suffix=fileName.substring(fileName.lastIndexOf("."));
// 用uuid作为文件名，防止生成的临时文件重复
UUID uuid  =  UUID.randomUUID();
String s = UUID.randomUUID().toString();
final File excelFile;
try {
  excelFile = File.createTempFile(s, suffix);
  // MultipartFile to File
  multfile.transferTo(excelFile);
  convertToXml.convert(excelFile,outputPath);
   if(excelFile.exists()){
       excelFile.delete();
   }
 } catch (IOException e) {
      e.printStackTrace();
 } catch (Exception e) {
      e.printStackTrace();
 }
}
```
