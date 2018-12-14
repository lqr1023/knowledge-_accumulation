### 关于java web中的异常处理
结合springboot完成异常调用处理：

https://www.cnblogs.com/Alandre/p/3794513.html#jeffli_h2   
https://blog.csdn.net/u013142781/article/details/50609488

业务抛出的异常一般都是经过主动包装过的异常，
checked异常：
表示无效，不是程序中可以预测的。比如无效的用户输入，文件不存在，网络或者数据库链接错误。这些都是外在的原因，都不是程序内部可以控制的。
必须在代码中显式地处理。比如try-catch块处理，或者给所在的方法加上throws说明，将异常抛到调用栈的上一层。
继承自java.lang.Exception（java.lang.RuntimeException除外）。
unchecked异常：
表示错误，程序的逻辑错误。是RuntimeException的子类，比如IllegalArgumentException, NullPointerException和IllegalStateException。
不需要在代码中显式地捕获unchecked异常做处理。
继承自java.lang.RuntimeException（而java.lang.RuntimeException继承自java.lang.Exception）。
