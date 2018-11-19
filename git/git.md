### 初始化仓库
```
git init
git remote add origin git@xxx
git add ./*
git commit -m "init project"
git push -u origin master
git status
```
### git ignore
根目录下添加.gitignore 
```
target/  //所有的target文件 /xxx就在根目录下找某个文件
.classpath
.idea/
*.iml
activiti.cfg.xml
```
提交前清空缓存
```
git rm -r --cached .//清空缓存
git add .//重新提交
git commit -m "update .gitignore"
git push
```
### 修改域名解决访问github速度慢的问题
1. 获取Github相关网站的ip  
访问https://www.ipaddress.com，拉下来，找到页面中下方的“IP Address Tools – Quick Links”
分别输入github.global.ssl.fastly.net和github.com，查询ip地址  
修改本地hosts文件C:\Windows\System32\drivers\etc\hosts  
参考如下，增加github.global.ssl.fastly.net和github.com的映射  
151.101.113.194 github.global.ssl.fastly.net  
192.30.253.112 github.com   
更新DNS缓存(貌似不更新也可以，会自动更新)  
命令行输入：ipconfig /flushdns   

