package Matrix;

import java.util.ArrayList;

public class TruthTable extends Table {

	public TruthTable(ArrayList<ArrayList<String>> Table, ArrayList<String> RowName, ArrayList<String> ColumnName) {
		this.Table = Table;
		this.ColumnName = ColumnName;
		this.RowName = RowName;
		Size.add(RowName.size());
		Size.add(ColumnName.size());
	}
	
	public TruthTable(int Row,int Column) {
		ArrayList<String> dummy = new ArrayList<String>();
		this.Table = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < Row; i++) {
			Table.add(dummy);
			for (int j = 0; j < Column; j++) {
				  Table.get(i).add("");
				}
		}
		Size.add(Row);
		Size.add(Column);
	}
	
	public ArrayList<ArrayList<String>> NegateTable() {
		for (int i = 0; i < this.Table.size(); i++) {
			for(int j = 0; j < this.Table.get(i).size(); j++) {
				if(this.Table.get(i).get(j) == "0") { this.Table.get(i).set(j,"1");}
				else if(Table.get(i).get(j) == "1") { this.Table.get(i).set(j,"0");}
				//futureproof
				else if(Table.get(i).get(j) == "and") { this.Table.get(i).set(j,"or");}
				else if(Table.get(i).get(j) == "or") { this.Table.get(i).set(j,"and");}
				}
		}
		return this.Table;
		}
	}

