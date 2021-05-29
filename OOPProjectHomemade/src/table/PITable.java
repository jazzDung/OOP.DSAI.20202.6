package table;

import java.util.*;

import exception.NameNotFoundException;
import term.CombinedTerm;
import term.MinTerm;
import term.Term;

public class PITable extends Table{

	
	public PITable(IntermediateColumnContainer icc, TruthTable tt) throws NameNotFoundException {
		ArrayList<Term> useTermWithDup = icc.getUnchecked();
		ArrayList<Term> useTerm = new ArrayList<Term>();

		System.out.println("\n");
		for(Term t1:useTermWithDup) {
			Boolean add = true;
			for(Term t2:useTerm) {
				if(t1.getBitValues().equals(t2.getBitValues())) {
					add = false;
				}
			}
			if(add) {
				useTerm.add(t1);
			}
		}
		System.out.println("MinTerm of Unchecked Terms");
		for(Term t:useTerm) {
			System.out.println(t.getImplicant());
			if(t instanceof MinTerm) {
				System.out.println(((MinTerm) t).getName());
			}else if(t instanceof CombinedTerm){
				for(MinTerm mt:((CombinedTerm) t).getMinTermList()) {
					System.out.println(mt.getName());
				}
			}
		}
		
		ArrayList<String> allImplicants = new ArrayList<String>();
		for(Term t:useTerm) {
			ArrayList<String> implicant = t.getImplicant();
			StringBuilder strBuild = new StringBuilder();
			for(String i:implicant) {
				strBuild.append(i);
			}
			allImplicants.add(strBuild.toString());
		}
		this.rowNames = allImplicants;
		
		ArrayList<String> allMinTerm = tt.getAllMinTerms();
		this.columnNames = allMinTerm;
		
		ArrayList<ArrayList<Object>> values = new ArrayList<ArrayList<Object>>();
		List<String> list = new ArrayList<String>(allMinTerm);
		for(Term t:useTerm) {
			Object[] oneRow = new String[allMinTerm.size()];
			Arrays.fill(oneRow, " ");
			if(t instanceof CombinedTerm) {
				for(MinTerm mt:((CombinedTerm) t).getMinTermList()) {
					oneRow[list.indexOf(String.valueOf(mt.getName()))] = "x";
				}	
			}else if(t instanceof MinTerm){
				oneRow[list.indexOf(String.valueOf(((MinTerm) t).getName()))] = "x";
			}
			ArrayList<Object> oneRowArrList = new ArrayList<Object>(Arrays.asList(oneRow));
			values.add(oneRowArrList);
		}
		System.out.println("PiTable:");
		for(ArrayList<Object> val: values) {
			System.out.println(val);
		}
		this.values = values;
	}
	
	public static void main(String[] args) throws NameNotFoundException {
		TruthTable tt = new TruthTable(4);
		IntermediateColumnContainer ic = new IntermediateColumnContainer(tt);
		PITable pi = new PITable(ic, tt);
		System.out.println(pi.getRowName());
		System.out.println(pi.getColumnName());
	}
}
