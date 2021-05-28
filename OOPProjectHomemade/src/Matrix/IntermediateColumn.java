package Matrix;

import java.util.ArrayList;
import java.util.Collections;

import Term.CombinedTerm;
import Term.MinTerm;
import Term.Term;

public class IntermediateColumn extends Table {
	public IntermediateColumn next() {
		int rowNum = this.getRowName().size() - 1;
		
		Group[] groupArray = new Group[rowNum];
		for (int i = 0; i < rowNum; i ++) {
			groupArray[i] = new Group();
		}
			
		for (int i = 0; i < rowNum; i ++) {
			Group g1 = (Group) this.values.get(i).get(0);
			for (Term t1:g1.getGroupMembers()) {
				Group g2 = ((Group) this.values.get(i+1).get(0));
				for (Term t2:g2.getGroupMembers()) {
					if (t1.compareTerm(t2)) {
						g1.check(t1);
						g2.check(t2);
						CombinedTerm c = new CombinedTerm(t1, t2);
						groupArray[i].addTerm(c);
					}
				}
			}
		}
		
		IntermediateColumn ic = new IntermediateColumn();
		ic.IntermediateColumnFromGroup(groupArray);
		return ic;
	}
	
	public void IntermediateColumnFromGroup(Group[] groupArray) {
		int count = 0;
		for (Group group:groupArray) {
			this.rowNames.add(String.valueOf(count));
			this.values.add(new ArrayList<Object>());
			this.values.get(count).add(group);

			count++;
		}
	}
	
	public IntermediateColumn() {	
	}
	
	public IntermediateColumn(TruthTable tt) {
		// TODO Auto-generated constructor stub
		this.columnNames.add("Term");
		
		
		int numVar = tt.getNumberOfVarivable();
		Group[] groupArray = new Group[numVar + 1];
		for (int i = 0; i < numVar + 1; i ++) {
//			this.rowNames.add(String.valueOf(i));
			groupArray[i] = new Group();
		}
		
		for (ArrayList<Object> row:tt.getValues()) {
			if (row.get(numVar).equals("1")) {
				System.out.println(row);
				ArrayList<String> bitVals = new ArrayList<String>();
				for (int i = 0; i < numVar; i ++) {
					bitVals.add((String) row.get(i));
				}
				MinTerm m = new MinTerm(bitVals);
				groupArray[Collections.frequency(row, "1") - 1].addTerm(m);
			}
		}
		
		IntermediateColumnFromGroup(groupArray);
//		int count = 0;
//		for (Group group:groupArray) {
//			this.values.add(new ArrayList<Object>());
//			this.values.get(count).add(group);
//			count++;
//		}
	}
	
	public ArrayList<Term> getUncheckedTerm() {
		ArrayList<Term> unchecked = new ArrayList<Term>();
		for (ArrayList<Object> row:this.values) {
			unchecked.addAll(((Group) (row.get(0))).getUnchecked());
		}
		return unchecked;
	}
	
	public static void main(String[] args) {
		TruthTable tt = new TruthTable(4);
		IntermediateColumn ic = new IntermediateColumn(tt);
//		System.out.println(((MinTerm) ((Group) ic.getValues().get(2).get(0)).getGroupMembers().get(0)));
//		System.out.println(ic.getRowName());
//		IntermediateColumn icNext = ic.next();
//		System.out.println(icNext.getValues());
//		System.out.println(icNext.getRowName());
		while (!(ic.getValues().isEmpty())) {
			System.out.println("");
			System.out.println("");

			for (ArrayList<Object> row : ic.getValues()) {
				System.out.println("");
				for (Term t:((Group) row.get(0)).getGroupMembers()) {
					System.out.println(t.getBitValues());
				}
			}
			
			IntermediateColumn icNext = ic.next();

			for (ArrayList<Object> row : ic.getValues()) {
				System.out.println(((Group) row.get(0)).getChecked());
			}
			ic = ic.next();

		}
	}
}
