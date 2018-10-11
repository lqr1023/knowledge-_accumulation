### css控制多余的信息    
- 多余的信息滚动条显示：设置overflow属性为hidden
```
overflow: hidden;
overflow-y: auto;
```   
- 控制显示多少行 剩余的信息... （不兼容火狐） 
```
display: -webkit-box;
overflow: hidden;
text-overflow: ellipsis;
word-break: break-all;
-webkit-box-orient: vertical;
-webkit-line-clamp: 3; //显示几行
```
展开可以修改display:block;overflow：visible; 
### CSS :before 选择器   
在p元素之前插入content内容:after与之对应；    
```
p:before
{ 
content:"台词：";
}
```
### 控制ul样式  
list-style: none; //不显示文字样式
### 调用框架(重点)   
> 这里需要注意一下js里方法的定义方式 https://www.cnblogs.com/yanzp/p/6371292.html      
```
$(function(){
//执行语句
})
```
以上写法等同于 $(document).ready(function(){})，执行顺序是在dom加载完成之后即页面所有的html标签(包括图片等)都加载完了即浏览器已经响应完成，加载完成之后全部展现到浏览器界面上。  
(function (a,b){
})(1,2)
(参数)
        
主页上通过在<script></script>定义立即执行函数   
```  
$(function() {
//在这里定义
}）

