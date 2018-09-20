### java 对文件的操作
需求：文件夹下有许多子文件夹，需要返回所有的txt文件地址  
- 不使用递归进行处理 建立list循环取
```
public void traverse(String path){
  List<String> txtPath = new ArrayList<String>();
  int txtNum = 0;
  int folderNum = 0; 
  File file = new File(path);
  if(file.exists()){
    LinkedList<File> list = new LinkedList<File>();
    File[] files = file.listFiles();
    for(File file1:files) {
      if(file1.isDirectory()){
        system.out.println("文件夹" + file1.getAbsolutePath());
        list.add(file1);
        folderNum++;
      }else if(file1.getName().substring(file1.getName.indexof(".")+1).equals("txt")){
         txtPath.add(file1.getAbsolutePath);
         system.out.println("txt文件" + file1.getAbsolutePath);
         txtNum++;
      }
    }
  }
}
```
- 使用递归的方法调用
```
	public void myself(String path){
		File dir = new File(path);
		if(dir.exists()){
			File[] files = dir.listFiles();
			if(files == null || files.length == 0){
				System.out.println(path + "不存在子文件");
				return;
			}else{
				for(File file:files){
					if(file.isDirectory()){
						myself(file.getAbsolutePath());
					}else if(file.getName().substring(file.getName().indexOf(".")+1).equals("txt")){
						A++;
						System.out.println("txt文件" + file.getAbsolutePath());
					}
				}
			}
		}else{
			System.out.println("目录不存在");
		}
	}
  ```
