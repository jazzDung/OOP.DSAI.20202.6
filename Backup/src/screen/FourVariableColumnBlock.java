package screen;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import exception.NameNotFoundException;
import table.Group;
import table.IntermediateColumn;
import term.Term;

public class FourVariableColumnBlock extends JPanel {

	protected JTable Table;
	protected IntermediateColumn column;
	
	public FourVariableColumnBlock(IntermediateColumn column) {
		
		this.column = column;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		        
		String[] columnNames = { "Group", "Min Term", "A",  "B",  "C", "D", "Checked" };
		DefaultTableModel table = new DefaultTableModel(columnNames, 0);
//		Table = new JTable(data, columnNames);
		
        boolean firstRow;
        System.out.println(column.getRowName());
        ArrayList<String> currentRow;
		for (String name: column.getRowName()) {
			firstRow = true;
			try {
				Group group = (Group) column.getItemsFromRowName(name).get(0);
				if (group.getGroupMembers().size() > 0) {
//					data[count][0] = name;
					System.out.println(name);
					ArrayList<Term> groupMembers = group.getGroupMembers();
					ArrayList<Integer> checked = group.getChecked();
					
					for (int member = 0; member < checked.size(); member ++) {
						currentRow = new ArrayList<String>();
						if (firstRow) {
							currentRow.add(name);
							firstRow = false;
						} else {
							currentRow.add("");
						}
						ArrayList<String> bitVals = groupMembers.get(member).getBitValues();
						currentRow.add(groupMembers.get(member).getName());
						currentRow.addAll(bitVals);
						currentRow.add(String.valueOf(checked.get(member)));
//						data[count][1] = groupMembers.get(member).getName();
//						for (int dataIndex = 0; dataIndex < bitVals.size(); dataIndex ++) {
//							data[count][dataIndex+2] = String.valueOf(bitVals.get(dataIndex));
//						}
						
//						data[count++][checked.size() + 5] = String.valueOf(checked.get(member));
//						data.add(currentRow)
						Object[] row = currentRow.toArray();
						table.addRow(row);
						
					}
				}
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
		}

		
        
        //Set column name and create table
//		String[] columnNames = { "Group", "Min Term", "A",  "B",  "C", "D", "Checked" };
//		Table = new JTable(data, columnNames);
		Table = new JTable(table);
		
		// Allign center
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < 7; i++) {
			Table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		//Set row height
		Table.setRowHeight(40);

		
		this.add(Box.createVerticalGlue());
		this.add(Table.getTableHeader(), BorderLayout.NORTH);
		this.add(Table);
		this.add(Box.createVerticalGlue());
//		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}