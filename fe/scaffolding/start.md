### 前端脚手架 （资料来源网络）
在软件开发上（当然也包括前端开发）的脚手架指的就是：有人帮你把这个开发过程中要用到的工具、环境都配置好了，你就可以方便地直接开始做开发，专注你的业务，而不用再花时间去配置这个开发环境，这个开发环境就是脚手架。  
### grunt
#### 简介
任务运行器，使用grunt可以减少重复的工作，比如压缩，编译，单元测试，工具程序等等，会使你的工作变得简单。当你配置了Gruntfile，任务运行器会帮你做这些工作。
#### 安装
```
npm install -g grunt-cli
```
查看是否安装成功
```
D:\>npm ls -g grunt-cli
``` 
#### cli工作原理
每次运行grunt时，它会利用node提供的require()系统查找本地安装的 Grunt。正是由于这一机制，你可以在项目的任意子目录中运行grunt。如果找到一份本地安装的 Grunt，CLI就将其加载，并传递Gruntfile中的配置信息，然后执行你所指定的任务。
#### 拿一份现有的 Grunt 项目练手 
假定Grunt CLI已经正确安装，并且已经有一份配置好package.json 和 Gruntfile 文件的项目了，接下来就很容易拿Grunt练手了：

1. 将命令行的当前目录转到项目的根目录下。
2. 执行npm install命令安装项目依赖的库。
3. 执行 grunt 命令。

OK，就是这么简单。还可以通过grunt --help 命令列出所有已安装的Grunt任务（task），但是一般更建议去查看项目的文档以获取帮助信息。
#### 准备一份新的 Grunt 项目 
一般需要在你的项目中添加两份文件：package.json 和 Gruntfile。  
package.json: 此文件被npm用于存储项目的元数据，以便将此项目发布为npm模块。你可以在此文件中列出项目依赖的grunt和Grunt插件，放置于devDependencies配置段内。   
Gruntfile: 此文件被命名为 Gruntfile.js 或 Gruntfile.coffee，用来配置或定义任务（task）并加载Grunt插件的。此文档中提到的 Gruntfile 其实说的是一个文件，文件名是 Gruntfile.js 或 Gruntfile.coffee。    
#### package.json
package.json应该放在项目的根目录下，与Gruntfile在同一目录中，并且应该与项目的源代码一起被提交。在上述目录(package.json所在目录)中运行npm install将依据package.json文件中所列出的每个依赖来自动安装适当版本的依赖。   
下面列出了几种为你的项目创建package.json文件的方式：

1. 大部分 grunt-init 模版都会自动创建特定于项目的package.json文件。
2. npm init命令会创建一个基本的package.json文件。
3. 复制下面的案例，并根据需要做扩充，参考此说明.
```
{
  "name": "my-project-name",
  "version": "0.1.0",
  "devDependencies": {
    "grunt": "~0.4.5",
    "grunt-contrib-jshint": "~0.10.0",
    "grunt-contrib-nodeunit": "~0.4.1",
    "grunt-contrib-uglify": "~0.5.0"
  }
}
```
#### 安装Grunt 和 grunt插件   
向已经存在的package.json 文件中添加Grunt和grunt插件的最简单方式是通过npm install <module> --save-dev命令。此命令不光安装了<module>，还会自动将其添加到devDependencies 配置段中，遵循tilde version range格式。    
例如，下面这条命令将安装Grunt最新版本到项目目录中，并将其添加到devDependencies内：  
```
 npm install grunt --save-dev
```
同样，grunt插件和其它node模块都可以按相同的方式安装。下面展示的实例就是安装 JSHint 任务模块：
```
npm install grunt-contrib-jshint --save-dev
```
在 Grunt 插件 页面可以看到当前可用的 Grunt 插件，他们可以直接在项目中安装并使用。  
安装插件之后，请务必确保将更新之后的 package.json 文件提交到项目仓库中。    
#### Gruntfile  





