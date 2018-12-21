### 利用bootstrap来排版前端展示界面
资料：   
教程：  http://www.runoob.com/bootstrap4/bootstrap4-tutorial.html   
图标库：http://www.bootcss.com/p/font-awesome/   
官方4.0 教程 https://getbootstrap.com/docs/4.0/getting-started/introduction/
### 网格系统搭建框架结构   
http://www.runoob.com/bootstrap/bootstrap-grid-system.html    
bootstrap支持网格系统，对屏幕进行划分，超小设备手机（<768px），小型设备平板电脑（≥768px），中型设备台式电脑（≥992px），大型设备台式电脑（≥1200px）四种网格类型，分别设置不同的栅格属性,总的列数都为12列，也可以设置不一样的class属性来适应屏幕的全部大小；通过这个类可以指定不同设备上的显示方式
```
<div class = "container">
  <div class = "row">
    <div class= "col-md-4">
    </div>
    <div class = "col-md-4">
    </div>
    <div class = "col-md-4">
    </div>
  </div>
</div>
```

关于padding margin bootstrap有很简便的缩写设定

```
The classes are named using the format {property}{sides}-{size} for xs and {property}{sides}-{breakpoint}-{size} for sm, md, lg, and xl.

Where property is one of:

m - for classes that set margin
p - for classes that set padding
Where sides is one of:

t - for classes that set margin-top or padding-top
b - for classes that set margin-bottom or padding-bottom
l - for classes that set margin-left or padding-left
r - for classes that set margin-right or padding-right
x - for classes that set both *-left and *-right
y - for classes that set both *-top and *-bottom
blank - for classes that set a margin or padding on all 4 sides of the element
Where size is one of:

0 - for classes that eliminate the margin or padding by setting it to 0
1 - (by default) for classes that set the margin or padding to $spacer * .25
2 - (by default) for classes that set the margin or padding to $spacer * .5
3 - (by default) for classes that set the margin or padding to $spacer
4 - (by default) for classes that set the margin or padding to $spacer * 1.5
5 - (by default) for classes that set the margin or padding to $spacer * 3
auto - for classes that set the margin to auto
```

具体见官方文档：https://getbootstrap.com/docs/4.0/utilities/spacing/#notation  
### bootstrap4中的卡片  
http://www.runoob.com/bootstrap4/bootstrap4-cards.html   

