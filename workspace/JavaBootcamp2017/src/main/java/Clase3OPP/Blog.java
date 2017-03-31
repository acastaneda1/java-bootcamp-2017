package Clase3OPP;

import java.util.List;

public class Blog {

	private RecentLists<Entry> entriesList;

	public Blog() {
		entriesList = new RecentLists<Entry>();
	}

	public void postNewEntry(Entry entry) {
		entriesList.addElement(entry);
	}

	public void deleteEntry(Entry entry) {
		entriesList.deleteElement(entry);
	}

	public List<Entry> getEntriesList() {
		return entriesList.getList();
	}

	public boolean containEntry(Entry entry) {
		return entriesList.containElement(entry);
	}

	public List<Entry> showLastEntries(int maxNumEntries) {
		if (entriesList.getSizeElement() >= maxNumEntries)
			return entriesList.getLastElements(0, maxNumEntries);
		else
			return entriesList.getList();

	}

}
