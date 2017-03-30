package Clase3OPP;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.TestSubject;
import org.easymock.Mock;
import org.junit.runner.RunWith;

import java.util.LinkedList;
import java.util.List;

@RunWith(EasyMockRunner.class)
public class BlogTest {

	@TestSubject
	private Blog blog = new Blog(); 

	@Mock
	private Entry mocky; 

	@Before
    public void setUp() {
        mocky = mock(Entry.class);
    }
	
	@Test
	public void whenPostNewEntryIsAddedToBlog() {
		blog.postNewEntry(mocky);
		assertTrue(blog.containEntry(mocky));
	}
	
	@Test
	public void whenDeleteExistingEntryTheEntryIsRemovedFromTheBlog(){
		blog.postNewEntry(mocky);
		Entry mocky2 = mock(Entry.class);
		Entry mocky3 = mock(Entry.class);
		blog.postNewEntry(mocky2);
		blog.deleteEntry(mocky);
		assertFalse(blog.containEntry(mocky));
	}
	
	@Test
	public void whenDeleteNoExistingEntryTheEntryIsRemovedFromTheBlog(){
		blog.postNewEntry(mocky);
		Entry mocky2 = mock(Entry.class);
		Entry mocky3 = mock(Entry.class);
		blog.postNewEntry(mocky2);
		blog.deleteEntry(mocky3);
		assertFalse(blog.containEntry(mocky3));
	}
	
	@Test
	public void whenShowTenMostRecentEntriesTheLastTenEntriesReturned(){
		
		LinkedList<Entry> testList = new LinkedList<Entry>();
		Entry mocky2 = mock(Entry.class);
		Entry mocky3 = mock(Entry.class);
		Entry mocky4 = mock(Entry.class);
		Entry mocky5 = mock(Entry.class);
		Entry mocky6 = mock(Entry.class);
		Entry mocky7 = mock(Entry.class);
		Entry mocky8 = mock(Entry.class);
		Entry mocky9 = mock(Entry.class);
		Entry mocky10 = mock(Entry.class);
		Entry mocky11 = mock(Entry.class);
		Entry mocky12 = mock(Entry.class);
		
		expect(mocky.getContent()).andReturn("contentEntry1");
		expect(mocky2.getContent()).andReturn("contentEntry2");
		expect(mocky3.getContent()).andReturn("contentEntry3");
		expect(mocky4.getContent()).andReturn("contentEntry4");
		expect(mocky5.getContent()).andReturn("contentEntry5");
		expect(mocky6.getContent()).andReturn("contentEntry6");
		expect(mocky7.getContent()).andReturn("contentEntry7");
		expect(mocky8.getContent()).andReturn("contentEntry8");
		expect(mocky9.getContent()).andReturn("contentEntry9");
		expect(mocky10.getContent()).andReturn("contentEntry10");
		expect(mocky11.getContent()).andReturn("contentEntry11");
		expect(mocky12.getContent()).andReturn("contentEntry12");
		
		expect(mocky.getViews()).andReturn(120);
		expect(mocky2.getViews()).andReturn(200);
		expect(mocky3.getViews()).andReturn(1);
		expect(mocky4.getViews()).andReturn(3);
		expect(mocky5.getViews()).andReturn(81512);
		expect(mocky6.getViews()).andReturn(32);
		expect(mocky7.getViews()).andReturn(49);
		expect(mocky8.getViews()).andReturn(56);
		expect(mocky9.getViews()).andReturn(35);
		expect(mocky10.getViews()).andReturn(128);
		expect(mocky11.getViews()).andReturn(512);
		expect(mocky12.getViews()).andReturn(1024);
		replay();
		
		blog.postNewEntry(mocky);
		blog.postNewEntry(mocky2);
		blog.postNewEntry(mocky3);
		blog.postNewEntry(mocky4);
		blog.postNewEntry(mocky5);
		blog.postNewEntry(mocky6);
		blog.postNewEntry(mocky7);
		blog.postNewEntry(mocky8);
		blog.postNewEntry(mocky9);
		blog.postNewEntry(mocky10);
		blog.postNewEntry(mocky11);
		blog.postNewEntry(mocky12);
		
		testList.addFirst(mocky3);
		testList.addFirst(mocky4);
		testList.addFirst(mocky5);
		testList.addFirst(mocky6);
		testList.addFirst(mocky7);
		testList.addFirst(mocky8);
		testList.addFirst(mocky9);
		testList.addFirst(mocky10);
		testList.addFirst(mocky11);
		testList.addFirst(mocky12);
		List<Entry> posts = blog.showLastEntries(10);
		System.out.println(posts);
		assertEquals(posts,testList);
		verify();
	}
}
