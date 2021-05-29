package table;
import java.util.*;

import exception.NameNotFoundException;

public class Table {
	
	public ArrayList<String> rowNames = new ArrayList<String>();
	public ArrayList<String> columnNames = new ArrayList<String>();
	public ArrayList<ArrayList<Object>> values = new ArrayList<ArrayList<Object>>();
	public ArrayList<Integer> size;
	
	public ArrayList<String> getRowName() {
		return rowNames;
	}
	public ArrayList<String> getColumnName() {
		return columnNames;
	}
	public ArrayList<ArrayList<Object>> getValues() {
		return values;
	}
	public ArrayList<Integer> getSize() {
		return size;
	}
	
	public ArrayList<Object> getItemsFromRowName(String rowName) throws NameNotFoundException {
		int index = rowNames.indexOf(rowName);
		if (index == -1) throw new NameNotFoundException("No such row name: " + rowName);
		else return values.get(index);
	}
	
	public ArrayList<Object> getItemsFromColumnName(String colName) throws NameNotFoundException {
		int index = columnNames.indexOf(colName);
		if (index == -1) throw new NameNotFoundException("No such column name:" + colName);
		else {
			ArrayList<Object> colItems = new ArrayList<Object>();
			for (ArrayList<Object> row : values) colItems.add(row.get(index));
			return colItems;
		}
	}

}
