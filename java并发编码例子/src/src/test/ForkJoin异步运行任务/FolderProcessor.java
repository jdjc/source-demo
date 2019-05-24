package test.ForkJoin异步运行任务;

import java.io.File;
import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;


public class FolderProcessor extends RecursiveTask<List<String>>{
	private static final long serialVersionUID = 1L;
	//用来存储任务将要处理的文件夹的完整路径
	private String path;
	//文件的扩展名
	private String extension;
	public FolderProcessor(String path,String extension) {
		this.extension = extension;
		this.path = path;
	}
	@Override
	protected List<String> compute() {
		//存储满足条件的路径
		List<String> list = new ArrayList<>();
		//存储任务集合
		List<FolderProcessor> tasks = new ArrayList<>();
		File file = new File(path);
		File content[] = file.listFiles();
		if(content != null){
			for(int i =0;i<content.length; i++){
				if(content[i].isDirectory()){
					FolderProcessor folderProcessor = new FolderProcessor(content[i].getAbsolutePath(), extension);
					folderProcessor.fork();
					tasks.add(folderProcessor);
				}else{
					//如果不是文件夹 而是文件的话 进行后缀名的对比，如果满足条件，将文件的路径保存到集合当中
					if(checkFile(content[i].getName())){
						list.add(content[i].getAbsolutePath());
					}
				}
			}
		}
		if(tasks.size()>50){
			System.out.println("运行的任务。大于50 ： "+file.getAbsolutePath() 
			+"：　大小："+ tasks.size());
		}
		addResultsFormTasks(list,tasks);
		return list;
	}
	private void addResultsFormTasks(List<String> list, List<FolderProcessor> tasks) {
		for(FolderProcessor item:tasks){
			//这个是同步方法
			list.addAll(item.join());
		}
	}
	private boolean checkFile(String name) {
		return name.endsWith(extension);
	}

}
