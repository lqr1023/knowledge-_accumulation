### 前端实现无刷新下载文件
前端是无法直接对硬盘进行操作的，如果需要通过ajax进行文件存储，要创建一个隐藏的from提交到后台，由后台进行文件操作
```
$.ajax({
     type: "POST",
     url: ...
     data:{   
        	...    
		  },    
      success: function (data) {
          var form = $("<form>");
          form.attr("style", "display:none");
          form.attr("target", "");
          form.attr("method", "get");
          form.attr("action", contextPath + "/download");
          var input1 = $("<input>");
          input1.attr("type", "hidden");
          input1.attr("name", "taskId");
          input1.attr("value",global.taskId);
          $("body").append(form);
          form.append(input1);
          form.submit();
          form.remove();
        }
    });
```
后台使用springboot的方法进行文件下载
```
@GetMapping("/download")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(String taskId) {
        Path path = Paths.get("..."));
        Resource resource = new UrlResource(path.toUri());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
```
### 处理中文名称异常
https://blog.csdn.net/baidu_30809315/article/details/79883143    
```
@GetMapping("/files/{filename:.+}")       
@ResponseBody    
public ResponseEntity<Resource> serveFile(@PathVariable String filename) {    
       Resource file = storageService.loadAsResource(filename);   
       String[] strArr = filename.split("\\.");    
       String fileNamePrefix = strArr[0];        
       String fileNameSuffix = strArr[1];       
       String finalFileName = null;        
       try {         
           finalFileName = URLEncoder.encode(fileNamePrefix,"UTF-8")+"."+fileNameSuffix;       
       }catch (UnsupportedEncodingException e){     
           log.info("文件名字转换异常");     
           e.printStackTrace();        
       }       
      return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,   
           "attachment; filename=\"" + finalFileName + "\"").body(file);    
}      
```

### 对多个文件进行压缩和打包 
