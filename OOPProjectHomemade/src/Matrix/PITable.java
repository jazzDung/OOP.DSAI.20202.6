package Matrix;

import java.util.*;

import Exception.NameNotFoundException;
import Term.CombinedTerm;
import Term.MinTerm;
import Term.Term;

public class PITable extends Table{

	
	public PITable(IntermediateColumnContainer icc, TruthTable tt) throws NameNotFoundException {
		ArrayList<Term> useTermWithDup = icc.getUnchecked();
		ArrayList<Term> useTerm = new ArrayList<Term>();
		Boolean add = true;
		for(Term t1:useTermWithDup) {
			for(Term t2:useTerm) {
				if(t1.getImplicant().equals(t2.getImplicant())) {
					add = false;
				}
			}
			if(add) {
				useTerm.add(t1);
			}
		}
		
		System.out.println("BitValues of Unchecked");
		for(Term t:useTerm) {
			System.out.println(t.getBitValues());
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
		
//		SortedSet<Integer> allMinTermName = new TreeSet<Integer>();
//		for(Term t:useTerm) {
//			if(t instanceof MinTerm) {
//				allMinTermName.add(new Integer(((MinTerm) t).getName()));
//			}
//			else if(t instanceof CombinedTerm) {
//				for(MinTerm mt:((CombinedTerm) t).getMinTermList()) {
//					allMinTermName.add(new Integer(mt.getName()));
//				}
//			}
//		}
//		ArrayList<String> allColumns = new ArrayList<String>();
////		allColumns.add("PI");
//		for(Integer i:allMinTermName) {
//			allColumns.add(String.valueOf(i.intValue()));
//		}
		ArrayList<String> allMinTerm = tt.getAllMinTerm();
		this.columnNames = allMinTerm;
//		this.columnNames = allColumns;
		
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
