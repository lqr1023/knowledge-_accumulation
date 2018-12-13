### dom节点操作
https://www.cnblogs.com/ooo0/p/6278102.html     
html界面的操作可以理解为对dom节点的操作，这里总结常用的jquery dom操作：   
- 获取节点
```
    $("#test1").parent(); // 父节点  
    $("#test1").parents(); // 全部父节点   
    $("#test1").parents(".mui-content");  
    $("#test").children(); // 全部子节点   
    $("#test").children("#test1");
    $("#test").contents(); // 返回#test里面的所有内容，包括节点和文本   
    $("#test").contents("#test1");   
    $("#test1").prev();  // 上一个兄弟节点   
    $("#test1").prevAll(); // 之前所有兄弟节点   
    $("#test1").next(); // 下一个兄弟节点   
    $("#test1").nextAll(); // 之后所有兄弟节点   
    $("#test1").siblings(); // 所有兄弟节点   
    $("#test1").siblings("#test2");   
    $("#test").find("#test1");   
```
- 获取内容和属性
```
text() - 设置或返回所选元素的文本内容         
$("#test1").text("Hello world!"); -设置        
$("#test1").text();  -获取       
html() - 设置或返回所选元素的内容（包括 HTML 标记）   
$("#test1").html(); -获取        
$("#test2").html("<b>Hello world!</b>"); -设置        
val() - 设置或返回表单字段的值         
$("#test3").val(); -获取        
$("#test3").val("Dolly Duck"); -设置        
attr("href") - 获取某个属性       
$("#w3s").attr("href") - 获取        
$("#w3s").attr("href","http://www.w3school.com.cn/jquery"); -设置
```
- css
```
$("p").css("color","red"); -设置css属性
$("p").css("color"); - 获取css属性
$("p").css({ - 设置多个css属性    
  "color":"white",        
  "background-color":"#98bf21",     
  "font-family":"Arial",         
  "font-size":"20px",       
  "padding":"5px"         
  });        
```


