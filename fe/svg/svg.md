## svg绘制基本图形   
### 绘制直线
```
<!DOCTYPE html>  
<html>  
<body>   

<svg xmlns="http://www.w3.org/2000/svg" version="1.1">    
  <line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(255,0,0);stroke-width:2" />    
</svg>   

</body>  
</html>    
```
### 绘制圆形   
```
<?xml version="1.0" standalone="no"?>
<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" 
"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">

<svg width="100%" height="100%" version="1.1"
xmlns="http://www.w3.org/2000/svg">

<circle cx="100" cy="50" r="40" stroke="black"
stroke-width="2" fill="red"/>

</svg>  
```
### 绘制矩形
### 绘制多边形

### 样式 style
fill-opacity 用来设置填充颜色透明度（范围：0 - 1） 
stroke-opacity 用来设置笔触（边框）颜色的透明度（范围：0 - 1） 
opacity 用来设置元素整体（包括”填充”和”边框”）的透明值（范围: 0 到 1）  
```
<svg xmlns="http://www.w3.org/2000/svg" version="1.1" width="400">
    <circle cx="80" cy="80" r="50" style="fill:pink;stroke:orange;stroke-width:5;"/>
    <circle cx="160" cy="80" r="50" style="fill:pink;stroke:orange;stroke-width:5;fill-opacity:0.1;" />
    <circle cx="240" cy="80" r="50" style="fill:pink;stroke:orange;stroke-width:5;stroke-opacity:0.1;" />
    <circle cx="320" cy="80" r="50" style="fill:pink;stroke:orange;stroke-width:5;opacity:0.1;" />
</svg>  
```
stroke-dasharray: 100; 设置虚线里的每个小线段的长度为100px     
stroke-dasharray = '10'   
stroke-dasharray = '10, 10'   
stroke-dasharray = '10, 10, 5, 5'    
绘制虚线: 一个参数时： 表示一段虚线长度和每段虚线之间的间距  
两个参数或者多个参数时：一个表示长度，一个表示间距   



