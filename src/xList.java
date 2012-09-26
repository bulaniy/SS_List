
public interface xList {
	String toString();
	int[] toArray();
	void addEnd(int val);
	void delEnd();
	void addStart(int val);
	void delStart();
	int size();
	int get(int pos);
	void set(int pos, int val);
	void addValtoIndex(int pos, int val);
	void delValfromIndex(int pos);
	void resize();
	void sort();
	void sort_choose();
	void sort_insert();

}
