package Clase3OPP;

import java.util.LinkedList;
import java.util.List;

public class RecentLists<E> {
	
	private LinkedList<E> list; 
	
	public RecentLists(){
		list = new LinkedList<E>();
	}
	
	public LinkedList<E> getList(){
		return list;
	}
	
	public void addElement(E element){
		if(list.contains(element))
			list.remove(element);
		list.addFirst(element);
		//System.out.println(list);
	}
	
	public void deleteElement(E element){
		if(list.contains(element))
			list.remove(element);
	}
	
	public int getSizeElement(){
		return list.size();
	}
	
	public List<E> getLastElements(int minValue,int maxValue){
		return list.subList(minValue,maxValue);
	}
	
	public boolean containElement(E element){
		if(list.contains(element))
			return true;
		else
			return false;
	}
	
	/*public boolean compareList(int maxValue, List<E> testList){
		if(list.subList(0, maxValue)==testList){
			System.out.println(testList);
			System.out.println(list);
			return true;
		}
		else{
			System.out.println(testList);
			System.out.println(list);
			return false;
		}
	}*/
}
