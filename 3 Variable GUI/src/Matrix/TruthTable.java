package Matrix;

import java.util.ArrayList;

public class TruthTable extends Table {

	public TruthTable() {
		Table = new ArrayList<ArrayList<String>>();
	}
	public TruthTable(ArrayList<ArrayList<String>> Table){
		this.Table = Table;
	}
	
	public TruthTable(ArrayList<ArrayList<String>> Table, ArrayList<String> RowName, ArrayList<String> ColumnName) {
		this.Table = Table;
		this.ColumnName = ColumnName;
		this.RowName = RowName;
		Size.add(RowName.size());
		Size.add(ColumnName.size());
	}
	
	public ArrayList<ArrayList<String>> NegateTable() {
		for (int i = 0; i < this.Table.size(); i++) {
			for(int j = 0; j < this.Table.get(i).size(); j++) {
				if(this.Table.get(i).get(j) == "0") {this.Table.get(i).set(j,"1");}
				else if(this.Table.get(i).get(j) == "1") {this.Table.get(i).set(j,"0");}
				}
		}
		return this.Table;
		}
	
 
	}




