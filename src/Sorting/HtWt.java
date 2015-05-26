package Sorting;

public class HtWt implements Comparable {

	public int Ht;
	public int Wt;
	
	public HtWt(int ht, int wt){
		Ht = ht;
		Wt = wt;
	}
	
	// used for sort method
	public int compareTo(Object s) {
		HtWt second = (HtWt) s;
		
		if (this.Ht != second.Ht){
			return ((Integer)this.Ht).compareTo(second.Ht);
		}
		else {
			return ((Integer)this.Wt).compareTo(second.Wt);
		}
	}
	
	// Returns true if "this" should be lined up before "other".
	// Note that its possible that this.isBefore(other) and other.isBefore(this) are both false. This is
	// different from the compareTo method, where if a < b, then b > a
	public boolean isBefore(HtWt other){
		if (this.Ht < other.Ht && this.Wt < other.Wt) return true;
		else return false;
	}
	
}
