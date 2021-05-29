package Matrix;

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

import Exception.NameNotFoundException;
import Term.Term;

public class ColumnBlock extends JPanel {

	protected JTable Table;
	protected IntermediateColumn column;
	
	public ColumnBlock(IntermediateColumn column) {
		
		this.column = column;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
//		JScrollPane sp = new JScrollPane(Table);  
		
		JLabel title = new JLabel("Box No.1");
		title. setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
        Object[][] data = new String[10][10];
		
		for (String name: column.getRowName()) {
			int i = 0;
			try {
				data[i][0] = column.getItemsFromRowName(name);
			} catch (NameNotFoundException e) {
				System.out.println("HE HO");
				e.printStackTrace();
			}
		}

		
        
        
		String[] columnNames = { "Group", "Min Term", "A  B  C  D" };
		Table = new JTable(data, columnNames);
		
		

		
		
		
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(Table);
		this.add(Box.createVerticalGlue());
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}
