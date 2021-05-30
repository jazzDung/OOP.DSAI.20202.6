package table;

import java.util.ArrayList;

import term.Term;

public class IntermediateColumnContainer {
	
	ArrayList<IntermediateColumn> intermediateColumns = new ArrayList<IntermediateColumn>();
	ArrayList<Term> unchecked = new ArrayList<Term>();
	
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
	
	public ArrayList<Term> getUnchecked() {
		return unchecked;
	}
	
	public static void main(String[] args) {
		IntermediateColumnContainer icc = new IntermediateColumnContainer(new TruthTable(4));
		for (Term t:icc.getUnchecked()) {
			System.out.println(t.getBitValues());
		}
	}

	public ArrayList<IntermediateColumn> getIntermediateColumns() {
		// TODO Auto-generated method stub
		return intermediateColumns;
	}

}
