package Term;

import java.util.ArrayList;

public class CombinedTerm extends Term {
	
	private ArrayList<MinTerm> minTermList = new ArrayList<MinTerm>();
	
	public CombinedTerm(MinTerm m1, MinTerm m2) {
		this.minTermList.add(m1);
		this.minTermList.add(m2);
		computeBitValues(m1, m2);
	}
	
	public CombinedTerm(CombinedTerm c1, CombinedTerm c2) {
		for (MinTerm m : c1.getMinTermList()) this.minTermList.add(m);
		for (MinTerm m : c1.getMinTermList()) this.minTermList.add(m);
		computeBitValues(c1, c2);
	}
	
	public ArrayList<MinTerm> getMinTermList() {
		return this.minTermList;
	}
	
	public void computeBitValues(Term t1, Term t2) {
		for (int i = 0; i < 4; i ++) {
			if (t1.getBitValues().get(i).equals(t2.getBitValues().get(i))) {
				this.bitValues.add(t1.getBitValues().get(i));
			} else this.bitValues.add("x");
		}
	}
	
	public static void  main(String[] args) {
		ArrayList<String> bitVals1 = new ArrayList<String>();
		bitVals1.add("0");
		bitVals1.add("1");
		bitVals1.add("1");
		bitVals1.add("0");
		MinTerm t1 = new MinTerm(bitVals1);
		System.out.println(t1.getBitValues());
		
		ArrayList<String> bitVals2 = new ArrayList<String>();
		bitVals2.add("0");
		bitVals2.add("0");
		bitVals2.add("1");
		bitVals2.add("0");
		MinTerm t2 = new MinTerm(bitVals2);
		System.out.println(t2.getBitValues());
		
		CombinedTerm c = new CombinedTerm(t1, t2);
		System.out.println(c.getBitValues());

	}
}

