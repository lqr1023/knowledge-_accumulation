### 关于nodejs 
让javascript运行在服务端的开发平台；它让javascript成为与PHP、Python、Perl、Ruby等服务端语言平起平坐的脚本语言；
### 安装与配置 这里暂时省略,有时间补充 
这里会同时涉及到npm的安装，npm类似于mavan 用来管理用到的js模块；package.json文件管理所有用到的模块信息，npm -install进行依赖包的下载；  
关于npm用到的版本号：三位数字分别代表主版本号x，次版本号y，补丁版本号z。代码变更时,版本号按以下原则更新。   
如果只是修复bug，需要更新z位；  
如果是新增了功能，但是向下兼容，需要更新Y位；  
如果有大变动，向下不兼容，需要更新z位；  
REPL交互式解释器；  
### Node.js 基本语法:    
- 回调函数：  
I/O API都是不会霸占CPU的，所以是非阻塞的【异步非阻塞I/O】,直接体现就是回调。 例如，我们可以一边读取文件，一边执行其他命令，在文件读取完成后，我们将文件内容作为回调函数的参数返回。这样在执行代码时就没有阻塞或等待文件 I/O 操作。这就大大提高了 Node.js 的性能，可以处理大量的并发请求。   
   
回调函数一般作为函数的最后一个参数出现：   
```
阻塞代码实例：   
var fs = require("fs");  
var data = fs.readFileSync('input.txt');  
console.log(data.toString());   
console.log("程序执行结束!");  
顺序执行
```

```
非阻塞代码实例：     
var fs = require("fs");
fs.readFile('input.txt',function(err,data){
	if(err) return console.error(err);
	console.log(data.toString());
});
console.log("程序执行结束");
先输出程序执行结束
```
- node.js 事件循环：
Node.js 是单进程单线程应用程序，但是因为 V8 引擎提供的异步执行回调接口，通过这些接口可以处理大量的并发，所以性能非常高。    
Node.js 几乎每一个 API 都是支持回调函数的。  
Node.js 基本上所有的事件机制都是用设计模式中观察者模式实现。    
Node.js 单线程类似进入一个while(true)的事件循环，直到没有事件观察者退出，每个异步事件都生成一个事件观察者，如果有事件发生就调用该回调函数    
- 事件驱动程序  
node.js使用事件驱动模型，当web server接收到请求，就把它关闭进行处理，然后去服务下一个web请求。当这个请求完成，它被放回处理队列，当到达队列开头，这个结果被返回给用户。  
- EventEmitter  
events模块提供了一个对象，events.EventEmitter。EventEmitter的核心就是事件触发与事件监听器功能的封装。
通过require('events')来访问该模块。
```
//引入events模块
var events = require('events');
//创建eventEmitter对象 
var eventEmitter = new events.EventEmitter();

//创建事件处理程序
var connectHandler = function connected(){
	console.log('连接成功。');
	eventEmitter.emit('data_received');
}

eventEmitter.on('connection',connectHandler);

eventEmitter.on('data_received',function(){
	console.log('数据接收成功');
});

eventEmitter.emit('connection');

console.log("程序执行完毕。");
```
EventEmitter可以对一个事件注册多个监听器，然后顺序调用；
```
//event.js 文件
var events = require('events'); 
var emitter = new events.EventEmitter(); 
emitter.on('someEvent', function(arg1, arg2) { 
    console.log('listener1', arg1, arg2); 
}); 
emitter.on('someEvent', function(arg1, arg2) { 
    console.log('listener2', arg1, arg2); 
}); 
emitter.emit('someEvent', 'arg1 参数', 'arg2 参数'); 
```
- I/O 
所有的 Stream 对象都是 EventEmitter 的实例。常用的事件有：
data - 当有数据可读时触发。  
end - 没有更多的数据可读时触发。  
error - 在接收和写入过程中发生错误时触发。   
finish - 所有数据已被写入到底层系统时触发。  
从流中读取数据：  
```
var fs = require("fs");
var data = '';

// 创建可读流
var readerStream = fs.createReadStream('input.txt');

// 设置编码为 utf8。
readerStream.setEncoding('UTF8');

// 处理流事件 --> data, end, and error
readerStream.on('data', function(chunk) {
   data += chunk;
});

readerStream.on('end',function(){
   console.log(data);
});

readerStream.on('error', function(err){
   console.log(err.stack);
});

console.log("程序执行完毕");var fs = require("fs");
var data = '';

// 创建可读流
var readerStream = fs.createReadStream('input.txt');

// 设置编码为 utf8。
readerStream.setEncoding('UTF8');

// 处理流事件 --> data, end, and error
readerStream.on('data', function(chunk) {
   data += chunk;
});

readerStream.on('end',function(){
   console.log(data);
});

readerStream.on('error', function(err){
   console.log(err.stack);
});

console.log("程序执行完毕");
```    
写入流：   
```
var fs = require("fs");
var data = '菜鸟教程官网地址：www.runoob.com';

// 创建一个可以写入的流，写入到文件 output.txt 中
var writerStream = fs.createWriteStream('output.txt');

// 使用 utf8 编码写入数据
writerStream.write(data,'UTF8');

// 标记文件末尾
writerStream.end();

// 处理流事件 --> data, end, and error
writerStream.on('finish', function() {
    console.log("写入完成。");
});

writerStream.on('error', function(err){
   console.log(err.stack);
});

console.log("程序执行完毕");
```
管道流：实现文件的复制  
```
var fs = require("fs");

// 创建一个可读流
var readerStream = fs.createReadStream('input.txt');

// 创建一个可写流
var writerStream = fs.createWriteStream('output.txt');

// 管道读写操作
// 读取 input.txt 文件内容，并将内容写入到 output.txt 文件中
readerStream.pipe(writerStream);

console.log("程序执行完毕");
```
链式流：
链式是通过连接输出流到另外一个流并创建多个流操作链的机制。链式流一般用于管道操作。 
压缩文件：
```
var fs = require("fs");
var zlib = require('zlib');

// 压缩 input.txt 文件为 input.txt.gz
fs.createReadStream('input.txt')
  .pipe(zlib.createGzip())
  .pipe(fs.createWriteStream('input.txt.gz'));
  
console.log("文件压缩完成。");
```
解压文件：
```
var fs = require("fs");
var zlib = require('zlib');

// 解压 input.txt.gz 文件为 input.txt
fs.createReadStream('input.txt.gz')
  .pipe(zlib.createGunzip())
  .pipe(fs.createWriteStream('input.txt'));
  
console.log("文件解压完成。");
```




### post/get 

### 上传文件
### 数据库
