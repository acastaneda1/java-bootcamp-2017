package Clase3OPP;

import java.util.ArrayList;
import java.io.File;

public class RecentFileList {
	
		private ArrayList<File> FileList = new ArrayList<File>();
		private int maxSizeArray;
		
		public RecentFileList(int maxSizeArrayTest){
			maxSizeArray= maxSizeArrayTest;
		}

		public ArrayList<File> getList(){
			return FileList;
		}
		
		public void fileOpen(File file){
			if(FileList.size()<maxSizeArray)
			{
				if(!FileList.contains(file)){				
					FileList.add(FileList.size(),file);
				}else{
					FileList.remove(file);
					FileList.add(0,file);
				}
			}else{
				if(!FileList.contains(file)){
					FileList.remove(9);
					FileList.add(0,file);
				}else{
					FileList.remove(file);
					FileList.add(0,file);
				}
			}
		}

}
