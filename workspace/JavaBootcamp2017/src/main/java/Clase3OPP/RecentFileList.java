package Clase3OPP;

import java.util.LinkedList;
import java.io.File;

public class RecentFileList {
	
		private LinkedList<File> fileList = new LinkedList<File>();
		private int maxSizeArray;
		
		public RecentFileList(int maxSizeArrayTest){
			maxSizeArray= maxSizeArrayTest;
			fileList = new LinkedList<File>();
		}

		public LinkedList<File> getList(){
			return fileList;
		}
		
		public void fileOpen(File file){
			if(fileList.size()>=maxSizeArray)
				fileList.removeLast();
			addFile(file);
		}
		
		public File getFirstElement(){
			return fileList.getFirst();
		}

	public void addFile(File file) {
		if (fileList.contains(file))
			fileList.remove(file);
		fileList.addFirst(file);
	}
}
