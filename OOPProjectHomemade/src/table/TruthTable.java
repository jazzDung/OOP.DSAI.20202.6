package table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import exception.NameNotFoundException;

public class TruthTable extends Table {
	
	
	private int numberOfVariable;
	
	public int getNumberOfVariable() {
		return numberOfVariable;
	}
	
	public TruthTable() {
		values = new ArrayList<ArrayList<Object>>();
	}
	
	public ArrayList<String> getAllMinTerms() throws NameNotFoundException {
		ArrayList<String> minTermNames = new ArrayList<String>();
		for (String rowName : this.getRowName()) {
			ArrayList<Object> row = this.getItemsFromRowName(rowName);
			if (row.get(numberOfVariable).equals("1")) minTermNames.add(rowName);
		}
		return minTermNames;
	}
	
	public TruthTable(int numVariable) {
		this.numberOfVariable = numVariable;
		ArrayList<String> rowName = new ArrayList<String>();
		ArrayList<String> columnName = null;
		ArrayList<ArrayList<Object>> values = new ArrayList<ArrayList<Object>>();
		if (numVariable == 3) {
			columnName = new ArrayList<String>(Arrays.asList("A", "B", "C", "Y Value"));
			for (int i = 0; i < 8; i ++) {
				rowName.add(String.valueOf(i));
			}
			values.add(new ArrayList<Object>(Arrays.asList("0", "0", "0", "0")));
			values.add(new ArrayList<Object>(Arrays.asList("0", "0", "1", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("0", "1", "0", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("0", "1", "1", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("1", "0", "0", "0")));
			values.add(new ArrayList<Object>(Arrays.asList("1", "0", "1", "0")));
			values.add(new ArrayList<Object>(Arrays.asList("1", "1", "0", "0")));
			values.add(new ArrayList<Object>(Arrays.asList("1", "1", "1", "1")));
			super.size = new ArrayList<Integer>(Arrays.asList(9, 4));

			
			
		} else if (numVariable == 4) {
			columnName = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "Y Value"));
			for (int i = 0; i < 16; i ++) {
				rowName.add(String.valueOf(i));		
			}
			values.add(new ArrayList<Object>(Arrays.asList("0", "0", "0", "0", "0")));
			values.add(new ArrayList<Object>(Arrays.asList("0", "0", "0", "1", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("0", "0", "1", "0", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("0", "0", "1", "1", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("0", "1", "0", "0", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("0", "1", "0", "1", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("0", "1", "1", "0", "0")));
			values.add(new ArrayList<Object>(Arrays.asList("0", "1", "1", "1", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("1", "0", "0", "0", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("1", "0", "0", "1", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("1", "0", "1", "0", "0")));
			values.add(new ArrayList<Object>(Arrays.asList("1", "0", "1", "1", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("1", "1", "0", "0", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("1", "1", "0", "1", "0")));
			values.add(new ArrayList<Object>(Arrays.asList("1", "1", "1", "0", "1")));
			values.add(new ArrayList<Object>(Arrays.asList("1", "1", "1", "1", "1")));
			super.size = new ArrayList<Integer>(Arrays.asList(16, 4));

		} else {
//			throw an exception or smt
		}
		super.columnNames = columnName;
		super.rowNames = rowName;
		super.values = values;
	}
	
//	public TruthTable(int Row,int Column) {
//		ArrayList<String> dummy = new ArrayList<String>();
//		this.table = new ArrayList<ArrayList<String>>();
//		for (int i = 0; i < Row; i++) {
//			values.add(dummy);
//			for (int j = 0; j < Column; j++) {
//				  values.get(i).add("");
//				}
//		}
//		size.add(Row);
//		size.add(Column);
//	}
	
	public void setNumberOfVariable(int numberOfVariable) {
		this.numberOfVariable = numberOfVariable;
	}

	public ArrayList<ArrayList<Object>> NegateTable() {
		for (int i = 0; i < this.values.size(); i++) {
			for(int j = 0; j < this.values.get(i).size(); j++) {
				if(this.values.get(i).get(j) == "0") { this.values.get(i).set(j,"1");}
				else if(values.get(i).get(j) == "1") { this.values.get(i).set(j,"0");}
				}
		}
//		Collections.sort(this.values, new Comparator<ArrayList<String>>() {
//
//			@Override
//			public int compare(ArrayList<String> arg0, ArrayList<String> arg1) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		})
		Collections.reverse(this.rowNames);
		return this.values;
	}
	
	public static void main(String[] args) {
		TruthTable t = new TruthTable(3);
		System.out.println(t.getRowName());
	}
}
