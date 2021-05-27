package Term;

import java.util.ArrayList;

public class MinTerm extends Term {
	public MinTerm(ArrayList<String> bitVals) {
		this.bitValues = bitVals;
	}
	public static void  main(String[] args) {
		ArrayList<String> bitVals = new ArrayList<String>();
		bitVals.add("0");
		bitVals.add("1");
		bitVals.add("1");
		bitVals.add("0");
		MinTerm t = new MinTerm(bitVals);
		System.out.println(t.getBitValues());
	}
}
