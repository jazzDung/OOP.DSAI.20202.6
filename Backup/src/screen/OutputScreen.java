package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import exception.NameNotFoundException;
import table.IntermediateColumn;
import table.IntermediateColumnContainer;
import table.PITable;
import table.TruthTable;

public class OutputScreen extends JFrame implements ActionListener {
	
	protected JFrame stage;
	protected TruthTable table;
	protected String outputType;
	
	public OutputScreen(TruthTable table, String outputType) {

		this.outputType = outputType;
        JFrame stage = new JFrame();
        this.table = table;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout. NORTH);
        cp.add(createCenter(), BorderLayout. CENTER);
        stage.add(new JScrollPane(cp), BorderLayout.CENTER);
        stage.setSize(800,800);
        stage.setTitle("Intermediate Column");
        stage.show();

        }
	
	 JPanel createCenter() {

	        JPanel center = new JPanel();

	        IntermediateColumnContainer container = new IntermediateColumnContainer(table);

	        BoxLayout boxlayout = new BoxLayout(center, BoxLayout.Y_AXIS);
	        center.setLayout(boxlayout);
	        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


	        if (table.getNumberOfVariable() == 3) {
	            for(IntermediateColumn column: container.getIntermediateColumns()) {
	                center.add(new ThreeVariableColumnBlock(column));
	                center.add(Box.createRigidArea(new Dimension(10, 30)));
	            }
	        }
	        else if (table.getNumberOfVariable() == 4) {
	            for(IntermediateColumn column: container.getIntermediateColumns()) {
	                center.add(new FourVariableColumnBlock(column));
	                center.add(Box.createRigidArea(new Dimension(10, 30)));
	            }
	        }
	        
	        try {
				PITable pi = new PITable(container, table);
				center.add(new PIBlock(pi));
				
				if (outputType.equals("POS")) {
					
					JLabel title = new JLabel("Simplified expression:");
					JLabel expression = new JLabel(pi.finalResultPOS());
					
					title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
					title.setForeground(Color.BLACK);
					
					expression.setFont(new Font(expression.getFont().getName(), Font.PLAIN, 30));
					expression.setForeground(Color.BLACK);
					
					center.add(title);
					center.add(expression);
					
				} else if(outputType.equals("SOP")) {
					JLabel title = new JLabel("Simplified expression");
					JLabel expression = new JLabel(pi.finalResultSOP());
					
					title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
					title.setForeground(Color.BLACK);
					
					expression.setFont(new Font(expression.getFont().getName(), Font.PLAIN, 30));
					expression.setForeground(Color.BLACK);
					
					center.add(title);
					center.add(expression);
				}
				

			
			} catch (NameNotFoundException e) {
				e.printStackTrace();
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
		
		JButton restart = new JButton("Convert again");
		restart.addActionListener(this);
		restart.setPreferredSize(new Dimension (120, 50));
		restart.setMaximumSize(new Dimension ( 120, 50));
		
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("Intermediate Column");
		title. setFont(new Font(title.getFont().getName(), Font.PLAIN, 40));
		title. setForeground(Color.BLACK);
		
		header.add(Box.createRigidArea(new Dimension (10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(restart);
		header.add(Box.createRigidArea(new Dimension (10, 10)));
		
		return header;
		
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Convert again")) {
			new ThreeVariableScreen(new TruthTable());
			this.dispose();
		}
	}
	
}