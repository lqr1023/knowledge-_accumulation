### 服务器路径问题：
https://www.cnblogs.com/Libinkai/p/9376353.html   
https://www.cnblogs.com/Libinkai/p/9377864.html    
### js 获取contextpath
方法一： 

function getContextPath() {

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}



方法二：

赋值一个一个hidden的控件吧 
<input type=“hidden” name=“contextPath” value=<%= request.getContextPath() %> > 

然后js里面获取hidden 的值


