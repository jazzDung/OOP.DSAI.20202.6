package Term;

import java.util.ArrayList;

public class Term {
	protected ArrayList<String> bitValues = new ArrayList<String>();
	public boolean compareTerm(Term t) {
		int count = 0;
		for (int i = 0; i < t.getBitValues().size(); i ++) {
			if (!this.bitValues.get(i).equals(t.getBitValues().get(i))) count++;
		}
		return count == 1;
	}
	public ArrayList<String> getBitValues() {
		return bitValues;
	}
}
