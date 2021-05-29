package Matrix;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewScreen extends JFrame {
	
	protected JFrame stage;
	protected TruthTable table;
	
	public NewScreen(TruthTable table) {
		
		this.table = table;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout. NORTH);
		cp.add(createCenter(), BorderLayout. CENTER);
		setVisible(true);
		setTitle("Intermediate Column");
		setSize(1024, 768);
		}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		IntermediateColumnContainer container = new IntermediateColumnContainer(table);
		for(IntermediateColumn column: container.getIntermediateColumns()) {
			center.add(new ColumnBlock(column));
		}
		
		return center;
		}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout. Y_AXIS));
		north.add(createHeader());
		return north;
		}
	
	JPanel createHeader() {
		
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("Intermediate Column");
		title. setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title. setForeground(Color.BLACK);
		
		header.add(Box.createRigidArea(new Dimension (10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension (10, 10)));
		
		return header;
		}
	
}
