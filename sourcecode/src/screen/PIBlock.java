package screen;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import table.PITable;

public class PIBlock extends JPanel{
	
	protected JTable Table;
	protected PITable piTable;
	
	
	public PIBlock(PITable piTable) {
		this.piTable = piTable;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		ArrayList<ArrayList<String>> dataWithRow = new ArrayList<ArrayList<String>>();
		ArrayList<String> rowName = this.piTable.getRowName();
		ArrayList<ArrayList<Object>> data = this.piTable.getValues();
		for(int i=0; i<data.size(); i++) {
			ArrayList<String> oneRow = new ArrayList<String>();
			oneRow.add(rowName.get(i));
			for(int j=0; j<data.get(i).size(); j++) {
				oneRow.add((String) data.get(i).get(j));
			}
			dataWithRow.add(oneRow);
		}
		System.out.println("dataWithRow");
		System.out.println(dataWithRow);
		
		if (dataWithRow.isEmpty()) Table = new JTable();
		else {
			String[][] dataWithRowArray = new String[dataWithRow.size()][dataWithRow.get(0).size()];
			for(int i=0; i<dataWithRow.size(); i++) {
				for(int j=0; j<dataWithRow.get(0).size(); j++) {
					dataWithRowArray[i][j] = (String) dataWithRow.get(i).get(j);
				}
			}
			
			
			ArrayList<String> col = new ArrayList<String>();
			col.add("PI");
			col.addAll(this.piTable.getColumnName());
			String[] columnNames = new String[col.size()];
			for(int i=0; i<col.size(); i++) {
				columnNames[i] = col.get(i);
			}
	//		String[] columnNames = (String[]) col.toArray();
			
			Table = new JTable(dataWithRowArray, columnNames);
		
		// Allign center
//		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//		for (int i = 0; i < 6; i++) {
//			Table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
//		}
				
		//Set row height
//		Table.setRowHeight(20);
		
		
			// Allign center
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			for (int i = 0; i < piTable.getColumnName().size() + 1; i++) {
				Table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			}
			
			//Set row height
			Table.setRowHeight(40);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(Table.getTableHeader(), BorderLayout.NORTH);
		this.add(Table);
		this.add(Box.createVerticalGlue());
		
		
	}
}
