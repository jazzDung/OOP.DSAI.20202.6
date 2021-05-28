package Matrix;

import java.util.ArrayList;
import java.util.Collections;

import Term.MinTerm;
import Term.Term;

public class IntermediateColumn extends Table {
	
	public IntermediateColumn(TruthTable tt) {
		// TODO Auto-generated constructor stub
		int numVar = tt.getNumberOfVarivable();
		@SuppressWarnings("unchecked")
		ArrayList<Term>[] group = new ArrayList[numVar + 1];
		for (int i = 0; i < 4; i ++) {
			group[i] = new ArrayList<Term>();
		}
		
		for (ArrayList<Object> row:tt.getValues()) {
			if (row.get(numVar).equals("1")) {
				System.out.println(row);
				ArrayList<String> bitVals = new ArrayList<String>();
				for (int i = 0; i < numVar; i ++) {
					bitVals.add((String) row.get(i));
				}
				MinTerm m = new MinTerm(bitVals);
				group[Collections.frequency(row, "1") - 1].add(m);
			}
		}
		
		this.values = new ArrayList<ArrayList<Object>>();
		int count = 0;
		for (ArrayList<Term> groupRow:group) {
			for (Term t:groupRow) {
				System.out.println(t.getBitValues());
			}
			System.out.println("nice");
			this.values.add(new ArrayList<Object>());
			this.values.get(count).add(groupRow);
			count++;
		}
			
	}
	
	public static void main(String[] args) {
		TruthTable tt = new TruthTable(3);
		IntermediateColumn ic = new IntermediateColumn(tt);
		System.out.println(ic.getValues());
		
	}
}
