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
