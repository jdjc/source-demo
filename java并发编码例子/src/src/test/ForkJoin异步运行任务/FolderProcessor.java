package test.ForkJoin�첽��������;

import java.io.File;
import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;


public class FolderProcessor extends RecursiveTask<List<String>>{
	private static final long serialVersionUID = 1L;
	//�����洢����Ҫ������ļ��е�����·��
	private String path;
	//�ļ�����չ��
	private String extension;
	public FolderProcessor(String path,String extension) {
		this.extension = extension;
		this.path = path;
	}
	@Override
	protected List<String> compute() {
		//�洢����������·��
		List<String> list = new ArrayList<>();
		//�洢���񼯺�
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
					//��������ļ��� �����ļ��Ļ� ���к�׺���ĶԱȣ�����������������ļ���·�����浽���ϵ���
					if(checkFile(content[i].getName())){
						list.add(content[i].getAbsolutePath());
					}
				}
			}
		}
		if(tasks.size()>50){
			System.out.println("���е����񡣴���50 �� "+file.getAbsolutePath() 
			+"������С��"+ tasks.size());
		}
		addResultsFormTasks(list,tasks);
		return list;
	}
	private void addResultsFormTasks(List<String> list, List<FolderProcessor> tasks) {
		for(FolderProcessor item:tasks){
			//�����ͬ������
			list.addAll(item.join());
		}
	}
	private boolean checkFile(String name) {
		return name.endsWith(extension);
	}

}
