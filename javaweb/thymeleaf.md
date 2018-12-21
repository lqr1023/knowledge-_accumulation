### springboot 
默认集成thymeleaf,与jsp,freemarker等模板替换工具类似,可以在前端完成部分后端的替换功能,java模板引擎,原型即页面;
- 变量表达式 ${...}  
```
<span th:text="${book.author.name}">
```
- 消息表达式#{...}
```
<table>
...
<th th:text="#{header.address.city}">...</th>
...
</table>
```
- 选择表达式：*{...}
```
<div th:object="${book}">
...
<span th:text="*{title}">...</span>
...
</div>
```
代表取出book对象的title属性；  
- 链接表达式 @{...}  
https://jingyan.baidu.com/article/37bce2be44479e1003f3a251.html
```
<a th:href="@{../xxx/xxx/xxx}">...</a>
<a th:href="@(~/xxx/xxx)">...</a>
<a th:href="@{//static.xxx/xxx/xxx}">...</a>
<a th:hred="@{http://xx/xxx}">...</a>  
```
- 分段表达式th:insert或th:replace
```
<div th:fragement="copy">
xxx
</div>

<div th:insert="~(footer::copy)"></div>
```
- 文字
文本
```
<span th:text="'hello'">
```
数字
```
<span th:text="2013"><span th:text="2013 + 2">
```
布尔
```
<div th:if="${user.isAdmin()}== false">...
```
null
```
<div th:if="${user.isAdmin}== null">
```
- 算数操作 + - * / %
- 比较和等价 > < >= <= (gt,lt,ge,le) == !=(eq,ne)
- 条件运算符 
```
<tr th:class="${row.even}?'even':'odd'">
```
- 无操作 
```
<span th:text="${user.name}?:_">...</span>
```
- 属性值
```
<span th:attr="action=@{/}">
<input type="text" value="xxx" th:attr="value=#{a.submit}" />
```
会用变量值覆盖原型中的值
```
<span th:action="@{/}">
<input type="text" value="xxx" th:value="#{a.submit}" />
```
- 固定值布尔表达式
```
<input type="checkbox" checked />
<input type="checkbox" checked="checked" />
<input type="checkbox" th:checked="${user.active}" />
```
- 迭代器th:each
```
<li th:each="book:${books}" th:text="${book.title}">xxx</li>
```
- 状态变量
index索引0开始、count索引1开始、size总数 current当前变量 even/odd奇数或偶数 first第一个 last最后一个
- 条件语句
th:if th:unless switch
```
<div th:switch="${user.role}">
<p th:case="'admin'">xxx</p>
<p th:case="#{roles.manager}">xxx</p>
<p th:case="*">xxx</p>
</div>
```
