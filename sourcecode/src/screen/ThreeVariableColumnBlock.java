package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import exception.NameNotFoundException;
import table.Group;
import table.IntermediateColumn;
import term.Term;

public class ThreeVariableColumnBlock extends JPanel {

	protected JTable Table;
	protected IntermediateColumn column;
	
	public ThreeVariableColumnBlock(IntermediateColumn column) {
		
		this.column = column;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
//		JScrollPane sp = new JScrollPane(Table);  
		String[] columnNames = { "Group", "Min Term", "A",  "B",  "C", "Checked" };
		DefaultTableModel table = new DefaultTableModel(columnNames, 0);
		
		JLabel title = new JLabel("Box No.1");
		title. setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);

//        String[][] data = new String[100][100];
        boolean firstRow;
        ArrayList<String> currentRow;

//        int count = 0;
        System.out.println(column.getRowName());
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
//						
//						data[count++][checked.size() + 4] = String.valueOf(checked.get(member));
						Object[] row = currentRow.toArray();
						table.addRow(row);
					}
				}
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
		}

		
        
        //Set column name and create table
//		String[] columnNames = { "Group", "Min Term", "A",  "B",  "C", "Checked" };
//		Table = new JTable(data, columnNames);
		Table = new JTable(table);
		
		// Allign center
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < 6; i++) {
			Table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		//Set row height
		Table.setRowHeight(40);

		
		for (int i = 0; i < 6; i++) {
		    Table.getColumnModel().getColumn(i).setWidth(5);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(Table.getTableHeader(), BorderLayout.NORTH);
		this.add(Table);
		this.add(Box.createVerticalGlue());
//		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}