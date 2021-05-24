package Matrix;

import java.util.ArrayList;

public class TruthTable extends Table {

	public TruthTable(ArrayList<ArrayList<Object>> values, ArrayList<String> RowName, 
			ArrayList<String> ColumnName, ArrayList<Integer> size) {
		super(RowName, ColumnName, values, size);
		
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
	
	public ArrayList<ArrayList<Object>> NegateTable() {
		for (int i = 0; i < this.values.size(); i++) {
			for(int j = 0; j < this.values.get(i).size(); j++) {
				if(this.values.get(i).get(j) == "0") { this.values.get(i).set(j,"1");}
				else if(values.get(i).get(j) == "1") { this.values.get(i).set(j,"0");}
				//futureproof
				else if(values.get(i).get(j) == "and") { this.values.get(i).set(j,"or");}
				else if(values.get(i).get(j) == "or") { this.values.get(i).set(j,"and");}
				}
		}
		return this.values;
		}
	}

