### 尝试用bootstrap来实现以下布局的上方导航栏
![图片](https://github.com/lqr1023/knowledge-accumulation/blob/master/fe/bootstrap-example/navbar/imgs/TIM%E5%9B%BE%E7%89%8720190423100347.jpg?raw=true)   
使用的bootstrap版本是4.3版本
### navbar1
```
<header>
	<nav class="navbar-expand-md navbar-light fixed-top bg-light">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<a class="navbar-brand" href="#"><span><img class="mt-2" src="https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/crop%3D0%2C26%2C607%2C400%3Bc0%3Dbaike80%2C5%2C5%2C80%2C26/sign=1da93d49b83eb1355088edfb9b2e84e1/f9dcd100baa1cd11ef286381bd12c8fcc2ce2df0.jpg" style="width:50px;height:50px;"></span></a>
			</div>
			<div class="col-md-8">
				<div class="row">
					<div class="col-md-6">
						<div class="mt-3" style="float:right;">
						<a href="#" class="mr-2">登录</a>
						<a href="#">注册</a>
						</div>
					</div>
					<div class="col-md-6">
						<form class="form-inline mt-2" style="float:left;">
							<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
							<button class="btn btn-outline-success" type="submit">Search</button>
						</form>
					</div>	
				</div>
			</div>
		</div>
		<div class="row">		
			<ul class="nav">
				<li class="nav-item">
				<a class="nav-link active" href="#">Active</a>
				</li>
				<li class="nav-item">
				<a class="nav-link" href="#">Link</a>
				</li>
				<li class="nav-item">
				<a class="nav-link" href="#">Link</a>
				</li>
				<li class="nav-item">
				<a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
				</li>
			</ul>
		</div>	
	</div>
	</nav> 
</header>
```
![代码截图](https://github.com/lqr1023/knowledge-accumulation/blob/master/fe/bootstrap-example/navbar/imgs/TIM%E5%9B%BE%E7%89%8720190423142913.png?raw=true)
