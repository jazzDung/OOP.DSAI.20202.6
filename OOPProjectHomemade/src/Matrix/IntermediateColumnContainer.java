package Matrix;

import java.util.ArrayList;

import Term.Term;

public class IntermediateColumnContainer {
	
	private ArrayList<IntermediateColumn> intermediateColumns = new ArrayList<IntermediateColumn>();
	private ArrayList<Term> unchecked = new ArrayList<Term>();
	
	public IntermediateColumnContainer(TruthTable tt) {
		// TODO Auto-generated constructor stub
		IntermediateColumn ic = new IntermediateColumn(tt);
		while (!(ic.getValues().isEmpty())) {
			intermediateColumns.add(ic);
			IntermediateColumn icNext = ic.next();
			unchecked.addAll(ic.getUncheckedTerm());
			ic = icNext;
		}
	}

	
	public ArrayList<IntermediateColumn> getIntermediateColumns() {
		return intermediateColumns;
	}



	public ArrayList<Term> getUnchecked() {
		return unchecked;
	}
	
	public static void main(String[] args) {
		IntermediateColumnContainer icc = new IntermediateColumnContainer(new TruthTable(4));
		for (Term t:icc.getUnchecked()) {
			System.out.println(t.getBitValues());
		}
	}
}
