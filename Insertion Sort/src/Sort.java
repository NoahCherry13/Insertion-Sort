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
	
	public int mean() {
		int sum = 0;
		for (Object o: list) {
			sum+=(int)o;
		}
		return sum/list.size();
	}
	
	public double median() {
		if (list.size()%2 == 1) {
			return (int)list.get(list.size()/2);
		}else {
			return (((double)(int)list.get(list.size()/2)+ (double)(int)(list.get(list.size()/2-1)))/2.0);
		}
	}
	
	public boolean inList(int num,ArrayList<Integer> arr) {
		for (Integer i: arr) {
			if ((int)i == num) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Integer> mode(){
		int count = 2;
		int oc = 1;
		ArrayList<Integer> modeList = new ArrayList<Integer>();
		modeList.clear();
		for(int i = 0; i < list.size();i++) {
			for (int j = 0; j< list.size(); j++) {
				if ((int)list.get(i) == (int)list.get(j) && i!=j&& !inList((int)list.get(i),modeList)) {
					oc++;
				}
			}
			if (oc>count) {
				modeList.clear();
				modeList.add((Integer) list.get(i));
				count = oc;
				oc = 1;
			}else if (oc == count) {
				oc = 1;
				modeList.add((Integer)list.get(i));
			}
			System.out.println('\n');
		}
		return modeList;
	}
}
