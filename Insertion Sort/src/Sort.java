import java.util.ArrayList;

public class Sort<T extends Comparable<T>> {
	private ArrayList<T> list = new ArrayList<>();

	public Sort(ArrayList<T> a) {
		list = a;
	}
	
	public Sort() {
		
	}
	
	public void addObj(T a) {
		list.add(a);
		insertionSort();
	}

	public void insertionSort() {
		for(int i = 1; i < list.size(); i++) {
			T t = list.get(i);
			int pos = i;
			
			while (pos > 0 && list.get(pos-1).compareTo(t)>0) {
				list.set(pos, list.get(pos-1));
				pos--;
			}
			list.set(pos, t);
		}
//		for (T f: list) {
//			System.out.println(f);
//		}
	}
	
	public ArrayList<T> getSorted(){
		return list;
	}
}
