package Clase3OPP;

import java.util.ArrayList;
import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class RecentFileListTest {
	
	private RecentFileList recentFileList;
	
	@Before
	public void setUp(){
		recentFileList = new RecentFileList(15);
	}
	
	@Test
	public void WhenProgramIsRunForTheFirstTime(){
		ArrayList<File> list = recentFileList.getList();
		assertTrue(list.isEmpty());
	}
	
	public void WhenAfileIsOpenedItIsAddedToTheRecentFileList(){
		File file1 = new File("file1");
		recentFileList.fileOpen(file1);
		ArrayList<File> list =recentFileList.getList();
		assertTrue(list.contains(file1));
	}
	
	public void IfOpenedFileExistsInRecentFileListItIsBumpedToTheTopNoDuplicated(){
		File file1 = new File("file1");
		recentFileList.fileOpen(file1);
		File file2 = new File("file2");
		recentFileList.fileOpen(file2);
		File file3 = new File("file2");
		recentFileList.fileOpen(file3);
		recentFileList.fileOpen(file1);
		ArrayList<File> list =recentFileList.getList();
		assertTrue(list.indexOf(file1) == 0);
	}
	
	public void IfTheRecentFileListGetsFullTheOldestItemIsRemovedWhenANewItemIsAdded(){
		File file1 = new File("file1");
		recentFileList.fileOpen(file1);
		File file2 = new File("file2");
		recentFileList.fileOpen(file2);
		File file3 = new File("file2");
		recentFileList.fileOpen(file3);
		File file4 = new File("file4");
		recentFileList.fileOpen(file4);
		File file5 = new File("file5");
		recentFileList.fileOpen(file5);
		File file6 = new File("file6");
		recentFileList.fileOpen(file6);
		File file7 = new File("file7");
		recentFileList.fileOpen(file7);
		File file8 = new File("file8");
		recentFileList.fileOpen(file8);
		File file9 = new File("file9");
		recentFileList.fileOpen(file9);
		File file10 = new File("file10");
		recentFileList.fileOpen(file10);
		File file11 = new File("file11");
		recentFileList.fileOpen(file11);
		File file12 = new File("file12");
		recentFileList.fileOpen(file12);
		File file13 = new File("file13");
		recentFileList.fileOpen(file13);
		File file14 = new File("file14");
		recentFileList.fileOpen(file14);
		File file15 = new File("file15");
		recentFileList.fileOpen(file15);
		File file16 = new File("file16");
		recentFileList.fileOpen(file16);
	}
	
}
