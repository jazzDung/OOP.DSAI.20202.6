package table;

import java.lang.reflect.Array;
import java.util.*;

import exception.NameNotFoundException;
import term.CombinedTerm;
import term.MinTerm;
import term.Term;

public class PITable extends Table{

	ArrayList<Term> useTerm = new ArrayList<Term>();
	
	public PITable(IntermediateColumnContainer icc, TruthTable tt) throws NameNotFoundException {
		ArrayList<Term> useTermWithDup = icc.getUnchecked();
//		System.out.println("Bin");
//		for(Term t:useTermWithDup) {
//			System.out.println(t.getBitValues());
//			System.out.println(t.getName());
//		}
		
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
//		System.out.println("No dup");
//		for(Term t:useTerm) {
//			System.out.println(t.getName());
//		}
		
		
		this.useTerm = useTerm;
		System.out.println("MinTerm of Unchecked Terms");
		for(Term t:useTerm) {
			System.out.println(t.getImplicant());
			if(t instanceof MinTerm) {
				System.out.println(((MinTerm) t).getNameInt());
			}else if(t instanceof CombinedTerm){
				for(MinTerm mt:((CombinedTerm) t).getMinTermList()) {
					System.out.println(mt.getNameInt());
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
		System.out.println("AllMinTerms");
		System.out.println(allMinTerm);
		this.columnNames = allMinTerm;
		
		ArrayList<ArrayList<Object>> values = new ArrayList<ArrayList<Object>>();
		List<String> list = new ArrayList<String>(allMinTerm);
		for(Term t:useTerm) {
			Object[] oneRow = new String[allMinTerm.size()];
			Arrays.fill(oneRow, " ");
			if(t instanceof CombinedTerm) {
				for(MinTerm mt:((CombinedTerm) t).getMinTermList()) {
					oneRow[list.indexOf(String.valueOf(mt.getNameInt()))] = "x";
				}	
			}else if(t instanceof MinTerm){
				System.out.println("List");
				System.out.println(list);
				oneRow[list.indexOf(String.valueOf(((MinTerm) t).getNameInt()))] = "x";
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
	
	public ArrayList<String> finalResult(){
		Set<String> resultSet = new HashSet<String>();
		ArrayList<String> uncoveredMinTerm = new ArrayList<String>(this.getColumnName());
		boolean[] piState = new boolean[this.getRowName().size()];
		Arrays.fill(piState, false);
		
		for(int col=0; col<this.getColumnName().size(); col++) {
			int count = 0;
			int imp = 0;
			for(int row=0; row<this.getRowName().size(); row++) {
				if(this.values.get(row).get(col).equals("x")) {
					count += 1;
					imp = row;
				}
			}
			
			if(count == 0) {
				if(uncoveredMinTerm.contains(String.valueOf(this.getColumnName().get(col)))) {
					uncoveredMinTerm.remove(String.valueOf(this.getColumnName().get(col)));
				}	
			}else if(count == 1) {
				resultSet.add(this.getRowName().get(imp));
				piState[imp] = true;
				Term t = this.useTerm.get(imp);
				if(t instanceof MinTerm) {
					uncoveredMinTerm.remove(((MinTerm) t).getNameInt());
				}else if (t instanceof CombinedTerm) {
					for(MinTerm mt:((CombinedTerm) t).getMinTermList()) {
						if(uncoveredMinTerm.contains(String.valueOf(mt.getNameInt()))) {
							uncoveredMinTerm.remove(String.valueOf(mt.getNameInt()));
						}
					}
				}
			}
			System.out.println(uncoveredMinTerm);
		}
		ArrayList<Term> pi = new ArrayList<Term>();
		for(int i=0; i<this.useTerm.size(); i++) {
			if(!piState[i]) {
				pi.add(this.useTerm.get(i));
			}
		}
		
		ArrayList<ArrayList<Term>> subsetOfPi = new ArrayList<ArrayList<Term>>();
		ArrayList<Term> minSubset = new ArrayList<Term>();
		int n = pi.size();
		int minSize = pi.size();
        for (int i = 0; i < (1<<n); i++){
        	ArrayList<Term> subset = new ArrayList<Term>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                	subset.add(pi.get(j));
                }
            }
            String[] coverMinTerm = new String[uncoveredMinTerm.size()];
            Arrays.fill(coverMinTerm, "false");
            for(Term t:subset) {
            	if(t instanceof MinTerm) {
            		coverMinTerm[uncoveredMinTerm.indexOf(((MinTerm) t).getName())] = "true";
            	}else if(t instanceof CombinedTerm) {
            		for(MinTerm mt:((CombinedTerm) t).getMinTermList()) {
            			if(uncoveredMinTerm.contains(mt.getName())) {
            				coverMinTerm[uncoveredMinTerm.indexOf(mt.getName())] = "true";
            			}
            		}
            	}
            }
            if(!Arrays.asList(coverMinTerm).contains("false")) {
            	if(subset.size() <= minSize) {
            		minSubset = subset;
            		minSize = subset.size();
            	}
            }
        }
        
        for(Term t:minSubset) {
        	ArrayList<String> implicant = t.getImplicant();
			StringBuilder strBuild = new StringBuilder();
			for(String i:implicant) {
				strBuild.append(i);
			}
			resultSet.add(strBuild.toString());
        }
        System.out.println(String.join(" + ", resultSet));
		
		ArrayList<String> finalResult = new ArrayList<String>(resultSet);
		return finalResult;
	}
	
	public String finalResultSOP() {
		ArrayList<String> finalResult = this.finalResult();
		return String.join(" + ", finalResult);
	}
	
	public String finalResultPOS() {
		ArrayList<String> finalResult = this.finalResult();
		ArrayList<String> output = new ArrayList<String>();
		for(String str:finalResult) {
			int i=0;
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			while(i < str.length()) {
				sb.append(str.charAt(i));
				if(i==str.length()-1) {
					;
				}
				else if(Character.isUpperCase(str.charAt(i+1))) {
					sb.append("+");
				}
				i++;
			}
			sb.append(")");
			output.add(sb.toString());
		}
		return String.join(" ", output);
	}
	
	public static void main(String[] args) throws NameNotFoundException {
		TruthTable tt = new TruthTable(3);
		IntermediateColumnContainer ic = new IntermediateColumnContainer(tt);
		PITable pi = new PITable(ic, tt);
		System.out.println(pi.getRowName());
		System.out.println(pi.getColumnName());
		System.out.println("POS");
		System.out.println(pi.finalResultPOS());
	}
}
