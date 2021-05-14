package Matrix;

import java.util.*;

public abstract class Table {
	
	public ArrayList<String> RowName;
	public ArrayList<String> ColumnName;
	public ArrayList<ArrayList<String>> Table;
	public ArrayList<Integer> Size = new ArrayList<Integer>();
	
	public Table() {
	}
	
	public ArrayList<String> getRowName() {
		return RowName;
	}
	public ArrayList<String> getColumnName() {
		return ColumnName;
	}
	public ArrayList<ArrayList<String>> getTable() {
		return Table;
	}
	public ArrayList<Integer> getSize() {
		return Size;
	}
	
	

}
