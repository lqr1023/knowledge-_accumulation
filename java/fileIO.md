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
复制文件jdk里有现成的方法：
```
    @Test
    public void copy(){
        System.out.println(FileUtil.class.getClassLoader().getResource("static/a.txt").getPath());
        File source = new File(FileUtil.class.getClassLoader().getResource("static/a.txt").getPath());
        File dest = new File(FileUtil.class.getClassLoader().getResource("").getPath() + "static/b.txt");

        try {
            Files.copy(source.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
```
### 递归遍历文件夹下所有的文件
```
public void traverseFolder2(String path) {      
    File file = new File(path);    
        if (file.exists()) {  
            File[] files = file.listFiles();  
            if (files.length == 0) {  
                System.out.println("文件夹是空的!");  
                return;  
            } else {  
                for (File file2 : files) {  
                    if (file2.isDirectory()) {  
                        //System.out.println("文件夹:" + file2.getAbsolutePath());  
                        traverseFolder2(file2.getAbsolutePath());  
                    } else {
                    	//System.out.println(file2.getName());
                    	if(file2.getName().endsWith("vue")){
                    		 System.out.println("文件:" + file2.getAbsolutePath());  
                    		 BufferedReader reader = null;
                    		 try {
				      reader = new BufferedReader(new InputStreamReader(new FileInputStream(file2), "utf-8"));      
				      //内存流           
				      CharArrayWriter caw=new CharArrayWriter();      
				      //替换                          
				      String line=null; //以行为单位进行遍历        
				      while((line=reader.readLine())!=null){              
				          //替换每一行中符合被替换字符条件的字符串               
					  line=line.replaceAll("xx", "xx"); 
					  //将该行写入内存 
					  caw.write(line); 
					  caw.append(System.getProperty("line.separator")); 
				      }
				      reader.close(); 
				      FileWriter fw=new FileWriter(file2);           
				      caw.writeTo(fw); 
				      fw.close();             
                    		   } catch (UnsupportedEncodingException e) {           
				     // TODO Auto-generated catch block         
					e.printStackTrace();       
				   } catch (FileNotFoundException e) {         
					// TODO Auto-generated catch block          
					e.printStackTrace();
				   } catch (IOException e) {          
					// TODO Auto-generated catch block          
					e.printStackTrace();      
			           }
                    		 
                    	        }
                           }  
                     }  
                }     
        } else {     
            System.out.println("文件不存在!");     
        }      
    }     
 ```   



