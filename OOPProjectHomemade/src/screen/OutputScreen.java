package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import table.IntermediateColumn;
import table.IntermediateColumnContainer;
import table.TruthTable;

public class OutputScreen extends JFrame {
	
	protected JFrame stage;
	protected TruthTable table;
	
//	public OutputScreen(TruthTable table) {
//		
//		this.table = table;
//		Container cp = getContentPane();
//		cp.setLayout(new BorderLayout());
//		cp.add(createNorth(), BorderLayout. NORTH);
//		cp.add(createCenter(), BorderLayout. CENTER);
//		setVisible(true);
//		setTitle("Intermediate Column");
//		setSize(750, 750);
//		}
	
	public OutputScreen(TruthTable table) {

        JFrame stage = new JFrame();
        this.table = table;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout. NORTH);
        cp.add(createCenter(), BorderLayout. CENTER);

        stage.add(new JScrollPane(cp), BorderLayout.CENTER);
        stage.setSize(600,800);
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


	        return center;
	        }
//	public OutputScreen(TruthTable table) {
//
//        JFrame stage = new JFrame();
//        this.table = table;
//
//        Container cp = getContentPane();
//        cp.setLayout(new BorderLayout());
//        cp.add(createNorth(), BorderLayout. NORTH);
//        cp.add(createCenter(), BorderLayout. CENTER);
//
//        stage.add(new JScrollPane(cp), BorderLayout.CENTER);
//        stage.setSize(600,800);
//        stage.setTitle("Intermediate Column");
//        stage.show();
//
//        }
//	
//	JPanel createCenter() {
//		
//		IntermediateColumnContainer container = new IntermediateColumnContainer(table);
//		JPanel center = new JPanel();
//		center.setLayout(new GridLayout(container.getIntermediateColumns().size(), 1, 30, 30));
//		center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//		
//		
//		if (table.getNumberOfVariable() == 3) {
//			for(IntermediateColumn column: container.getIntermediateColumns()) {
//				center.add(new ThreeVariableColumnBlock(column));
//			}
//		}
//		else if (table.getNumberOfVariable() == 4) {
//			for(IntermediateColumn column: container.getIntermediateColumns()) {
//				System.out.println("Bruh");
//				center.add(new FourVariableColumnBlock(column));
//			}
//		}
//		
//		
//		return center;
//		}
	
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