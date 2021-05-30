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
		
        String[][] data = new String[100][100];
		
        int count = 0;
        System.out.println(column.getRowName());
		for (String name: column.getRowName()) {
			
			try {
				Group group = (Group) column.getItemsFromRowName(name).get(0);
				if (group.getGroupMembers().size() > 0) {
					data[count][0] = name;
					System.out.println(name);
					ArrayList<Term> groupMembers = group.getGroupMembers();
					ArrayList<Integer> checked = group.getChecked();
					
					for (int member = 0; member < checked.size(); member ++) {
						ArrayList<String> bitVals = groupMembers.get(member).getBitValues();
						data[count][1] = groupMembers.get(member).getName();
						for (int dataIndex = 0; dataIndex < bitVals.size(); dataIndex ++) {
							data[count][dataIndex+2] = String.valueOf(bitVals.get(dataIndex));
						}
						
						data[count++][checked.size() + 5] = String.valueOf(checked.get(member));
					}
				}
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
		}

		
        
        //Set column name and create table
		String[] columnNames = { "Group", "Min Term", "A",  "B",  "C", "D", "Checked" };
		Table = new JTable(data, columnNames);
		
		// Allign center
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < 7; i++) {
			Table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		//Set row height
		Table.setRowHeight(20);
		
//		for (int i = 0; i < 7; i++) {
//		    Table.getColumnModel().getColumn(i).setPreferredWidth(5);
//		}
		
		this.add(Box.createVerticalGlue());
		this.add(Table.getTableHeader(), BorderLayout.NORTH);
		this.add(Table);
		this.add(Box.createVerticalGlue());
//		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}