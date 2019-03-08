##目前调研了一些能操作office的类库，总结如下：  
### 参考文章：  
https://www.cnblogs.com/zhouguanglin/p/7395970.html  感谢原作者！  
office文档在2007版本之上是可以转成通用的xml格式的，这个格式遵循着官方定义的格式。    
也就是后缀名称带有x的 如.docx .xlsx 等，所以相对应的操作方式也会有两种，以poi为例介绍如下：  
### 引入jar包
```

```
### 工作簿
> 这是创建或维护Excel工作簿的所有类的超接口。它属于org.apache.poi.ss.usermodel包。是实现此接口的两个类，如下所示：   
> HSSFWorkbook : 这个类有读取和.xls 格式和写入Microsoft Excel文件的方法。它与微软Office97-2007版本兼容。   
> XSSFWorkbook : 这个类有读写Microsoft Excel和OpenOffice的XML文件的格式.xls或.xlsx的方法。它与MS-Office版本2007或更高版本兼容。对应着OOXML  




