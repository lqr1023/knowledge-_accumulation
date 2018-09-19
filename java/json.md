## 使用net.sf.json解析json  
### 简单介绍
### 导入依赖包
json-lib-2.4-jdk15.jar  
commons-beanutils-1.8.0.jar  
commons-lang-2.5.jar  
commons-logging-1.1.1.jar  
commons-collections-3.2.1.jar  
ezmorph-1.0.6.jar  

```
    <dependency>
      <groupId>net.sf.json-lib</groupId>
      <artifactId>json-lib</artifactId>
      <version>2.4</version>
      <classifier>jdk15</classifier>
      <scope>compile</scope>
    </dependency>
```
### 读取json文件   
- 文件流读入json文件 
```
public static String readJsonFile(String Path) {
        BufferedReader reader = null;
        String laststr = "";
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(Path), "UTF-8"));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString + "\n";
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }
```  
- json对象类型
```
JSONObject:   
{   
  "json":{   
  }   
}    
JSONArray:   
{    
  "array":[    
  {      
  "age":"22",   
  "name":"wln"   
  },   
  {   
  "age":"33",   
  "name":"nana"  
  }  
  ]  
}  
string  
{  
  "name":  
}  
```     
- 可以按照数据类型进行读取   
```
JSONObject json = JSONObject.fromObject(str); 
//获取key值
Set<String> ids = json.keySet();
//循环遍历ids
 for(String id:ids){
    Object a = json.get(id);
    //如果是数组类型
    if(a instanceof JSONArray){
        JSONArray array = (JSONArray)a;
        for (Object obj : array) {
            //再次判断转换格式
        }
    }else if(a instanceof JSONObject){
        JSONObject b = (JSONObject)a;
        //处理
    }else{
        //string
    }
 }
 ```  
 ## 使用GsonOp解析json  
 ### GsonOp实现实体类和json的转换
 ```
 {
  "pic1": "pic1.jpg",
  "par1": "你好！",
  "tab1": [
    [
      "姓名",
      "小明"
    ],
    [
      "性别",
      "男"
    ]
  ]
}
 ```
 - 同样需要先转成字符串，代码同上read字符串拼接  
 - 编写实体类  
 ```
    private String pic1;
	private String par1;
	private List<List<String>> tab1;
    //以下是get set方法
 ```
 - 调用gson的转换方法
 ```
 	String path = "D:/example.json";
	String json = readJsonFile(path);
    Gson gson = new Gson();
    java.lang.reflect.Type type = new TypeToken<Student>() {}.getType();
    Student jsonBean = gson.fromJson(json, type);
    System.out.println(jsonBean.getPar1());
    System.out.println(jsonBean.getPic1());
    List<List<String>> a = jsonBean.getTab1();
     for (List<String> list : a) {
			for (String string : list) {
				System.out.println(string);
			}
		}
 
 ```
 

 
 









    
    

