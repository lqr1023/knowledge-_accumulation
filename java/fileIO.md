### 依赖包   
jdk1.8.0   
### 读取文件
```
public void readTxt() throws Exception{
		String path = "";
		File file = new File(path);
		BufferedReader reader = null; 
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
			String temp;
			while((temp = reader.readLine())!= null && !temp.trim().isEmpty()){
				System.out.println(temp);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally 
			if(reader!=null){
				reader.close();
			}
		}	
	}
	
	
```
### 写入文件
```
@Test	public void write() throws Exception{
		File file = new File(path);
		BufferedWriter writer = null;
		try {
			//new FileOutputStream(file,true）第二个参数代表是否覆盖之前的文件，如果为true不覆盖 false 覆盖
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"utf-8"));
			writer.write("hello world\r\n");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			writer.close();
		}
	}
  ```
### 复制文件
```
public void copy(String old,String new){
  File file = new File(old);
		if(file.exists()){
			File outFile = new File(new);
			BufferedReader reader = null; 
			BufferedWriter writer = null;
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
        //false 覆盖
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile,false),"utf-8"));
				String temp;
				while((temp = reader.readLine())!= null && !temp.trim().isEmpty){
					writer.write(temp + "\n");
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(reader!=null){
					reader.close();
				}
				if(writer!=null){
					writer.close();
				}
			}	
		}else{
			System.out.println("error:can not find the file " + old);
		}
 }
```


