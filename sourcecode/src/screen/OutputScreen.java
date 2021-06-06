////package screen;
////
////import java.awt.BorderLayout;
////import java.awt.Color;
////import java.awt.Container;
////import java.awt.Dimension;
////import java.awt.Font;
////import java.awt.GridLayout;
////import java.util.ArrayList;
////
////import javax.swing.BorderFactory;
////import javax.swing.Box;
////import javax.swing.BoxLayout;
////import javax.swing.JButton;
////import javax.swing.JFrame;
////import javax.swing.JLabel;
////import javax.swing.JPanel;
////import javax.swing.JScrollPane;
////
////import exception.NameNotFoundException;
////import table.IntermediateColumn;
////import table.IntermediateColumnContainer;
////import table.PITable;
////import table.TruthTable;
////
////public class OutputScreen extends JFrame {
////	
////	protected JFrame stage;
////	protected TruthTable table;
////	protected String outputType;
////	
////
////	public OutputScreen(TruthTable table, String outputType) {
////        JFrame stage = new JFrame();
////        this.table = table;
////        this.outputType = outputType;
////        
////        Container cp = getContentPane();
////        cp.setLayout(new BorderLayout());
////        cp.add(createNorth(), BorderLayout. NORTH);
////        cp.add(createCenter(), BorderLayout. CENTER);
////
////        stage.add(new JScrollPane(cp), BorderLayout.CENTER);
////        stage.setSize(600,800);
////        stage.setTitle("Intermediate Column");
////        stage.show();
////		
//////		this.table = table;
//////		this.outputType = outputType;
//////		Container cp = getContentPane();
//////		cp.setLayout(new BorderLayout());
//////		cp.add(createNorth(), BorderLayout. NORTH);
//////		cp.add(createCenter(), BorderLayout. CENTER);
//////		setVisible(true);
//////		setTitle("Intermediate Column");
//////		setSize(750, 750);
////	}
////	
////	JPanel createCenter() {
////		
////		JPanel center = new JPanel();
////		center.setLayout(new GridLayout(3, 1, 30, 30));
////		center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
////		
////		IntermediateColumnContainer container = new IntermediateColumnContainer(table);
////		System.out.println(container.getIntermediateColumns());
////		
////		if (table.getNumberOfVariable() == 3) {
////			for(IntermediateColumn column: container.getIntermediateColumns()) {
////				center.add(new ThreeVariableColumnBlock(column));
////			}
////		}
////		else if (table.getNumberOfVariable() == 4) {
////			for(IntermediateColumn column: container.getIntermediateColumns()) {
////				center.add(new FourVariableColumnBlock(column));
////			}
////		}
////		
////		try {
////			PITable pi = new PITable(container, table);
////			center.add(new PIBlock(pi));
////			
////			JPanel result = new JPanel();
////			if(outputType.equals("POS")) {
////				result.add(new JLabel(pi.finalResultPOS()));
////			}else if(outputType.equals("SOP")) {
////				result.add(new JLabel(pi.finalResultSOP()));
////			}
////			
////			center.add(result);
////		} catch (NameNotFoundException e) {
////			e.printStackTrace();
////		}
////		return center;
////		}
////
////	
////	JPanel createNorth() {
////		JPanel north = new JPanel();
////		north.setLayout(new BoxLayout(north, BoxLayout. Y_AXIS));
////		north.add(createHeader());
////		return north;
////		}
////	
////	JPanel createHeader() {
////		
////		JPanel header = new JPanel();
////		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
////		
////		JLabel title = new JLabel("Intermediate Column");
////		title. setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
////		title. setForeground(Color.BLACK);
////		
////		header.add(Box.createRigidArea(new Dimension (10, 10)));
////		header.add(title);
////		header.add(Box.createHorizontalGlue());
////		header.add(Box.createRigidArea(new Dimension (10, 10)));
////		
////		return header;
////		}
////	
////}
//
//package screen;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowEvent;
//
//import javax.swing.BorderFactory;
//import javax.swing.Box;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.SwingUtilities;
//
//import exception.NameNotFoundException;
//import table.IntermediateColumn;
//import table.IntermediateColumnContainer;
//import table.PITable;
//import table.TruthTable;
//
//public class OutputScreen extends JFrame {
//	
//	protected JFrame stage;
//	protected TruthTable table;
//	protected String outputType;
//	private Container cp;
//	
//	public OutputScreen(TruthTable table, String outputType) {
//
//		this.outputType = outputType;
//        JFrame stage = new JFrame();
//        this.table = table;
//
//        cp = getContentPane();
//        cp.setLayout(new BorderLayout());
//        cp.add(createNorth(), BorderLayout. NORTH);
//        cp.add(createCenter(), BorderLayout. CENTER);
//        stage.add(new JScrollPane(cp), BorderLayout.CENTER);
//        stage.setSize(800,800);
//        stage.setTitle("Intermediate Column");
//        stage.show();
//
//        }
//	
//	 JPanel createCenter() {
//
//	        JPanel center = new JPanel();
//
//	        IntermediateColumnContainer container = new IntermediateColumnContainer(table);
//
//	        BoxLayout boxlayout = new BoxLayout(center, BoxLayout.Y_AXIS);
//	        center.setLayout(boxlayout);
//	        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//
//
//	        if (table.getNumberOfVariable() == 3) {
//	            for(IntermediateColumn column: container.getIntermediateColumns()) {
//	                center.add(new ThreeVariableColumnBlock(column));
//	                center.add(Box.createRigidArea(new Dimension(10, 30)));
//	            }
//	        }
//	        else if (table.getNumberOfVariable() == 4) {
//	            for(IntermediateColumn column: container.getIntermediateColumns()) {
//	                center.add(new FourVariableColumnBlock(column));
//	                center.add(Box.createRigidArea(new Dimension(10, 30)));
//	            }
//	        }
//	        
//	        try {
//				PITable pi = new PITable(container, table);
//				center.add(new PIBlock(pi));
//				
//				if (outputType.equals("POS")) {
//					
//					JLabel title = new JLabel("Simplified expression:");
//					JLabel expression = new JLabel(pi.finalResultPOS());
//					
//					title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
//					title.setForeground(Color.BLACK);
//					
//					expression.setFont(new Font(expression.getFont().getName(), Font.PLAIN, 30));
//					expression.setForeground(Color.BLACK);
//					
//					center.add(title);
//					center.add(expression);
//					
//				} else if(outputType.equals("SOP")) {
//					JLabel title = new JLabel("Simplified expression");
//					JLabel expression = new JLabel(pi.finalResultSOP());
//					
//					title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
//					title.setForeground(Color.BLACK);
//					
//					expression.setFont(new Font(expression.getFont().getName(), Font.PLAIN, 30));
//					expression.setForeground(Color.BLACK);
//					
//					center.add(title);
//					center.add(expression);
//				}
//				
//
//			
//			} catch (NameNotFoundException e) {
//				e.printStackTrace();
//			}
//	        
//			return center;
//			}
//	
//	JPanel createNorth() {
//		JPanel north = new JPanel();
//		north.setLayout(new BoxLayout(north, BoxLayout. Y_AXIS));
//		north.add(createHeader());
//		return north;
//		}
//	
//	JPanel createHeader() {
//		
//		JButton restart = new JButton("Convert again");
//		restart.addActionListener(new ConvertAgainListener());
//		restart.setPreferredSize(new Dimension (120, 50));
//		restart.setMaximumSize(new Dimension ( 120, 50));
//		
//		JPanel header = new JPanel();
//		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
//		
//		JLabel title = new JLabel("Intermediate Column");
//		title. setFont(new Font(title.getFont().getName(), Font.PLAIN, 40));
//		title. setForeground(Color.BLACK);
//		
//		header.add(Box.createRigidArea(new Dimension (10, 10)));
//		header.add(title);
//		header.add(Box.createHorizontalGlue());
//		header.add(restart);
//		header.add(Box.createRigidArea(new Dimension (10, 10)));
//		
//		return header;
//		
//		}
//	




package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import exception.NameNotFoundException;
import table.IntermediateColumn;
import table.IntermediateColumnContainer;
import table.PITable;
import table.TruthTable;

public class OutputScreen extends JFrame {
	
	protected JFrame stage;
	protected TruthTable table;
	protected String outputType;
	protected Container cp;
	public OutputScreen(TruthTable table, String outputType) {

		this.outputType = outputType;
        JFrame stage = new JFrame();
        this.table = table;

        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createCenter(), BorderLayout.CENTER);
        stage.add(new JScrollPane(cp), BorderLayout.CENTER);
        stage.setSize(900,900);
        stage.setTitle("Intermediate Column");
        stage.show();

        }
	
	public JLabel makeItFancy(JLabel label) {
		Border border = label.getBorder();
		Border margin = new EmptyBorder(10,10,10,10);
		label.setBorder(new CompoundBorder(border, margin));
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 30));
		label.setForeground(Color.BLACK);
		return label;
	}
	
	public JTable resultTable(String row) {

		
		int width = 0;
		String data[][]= {{row}};
	    
	    String column[]={"Result"};  
	    
		JTable result = new JTable(data, column);
		


						
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		result.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		result.getColumnModel().getColumn(0).setPreferredWidth(590);
		result.setRowHeight(50);	
        result.setFont(new Font("Serif", Font.BOLD, 30));
		return result;
	}
	
	 JPanel createCenter() {

	        JPanel center = new JPanel();

	        IntermediateColumnContainer container = new IntermediateColumnContainer(table);

	        BoxLayout boxlayout = new BoxLayout(center, BoxLayout.Y_AXIS);
	        center.setLayout(boxlayout);
	        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    		center.add(makeItFancy(new JLabel("Intermediate Column")));
	        
	        if (table.getNumberOfVariable() == 3) {
	            for(IntermediateColumn column: container.getIntermediateColumns()) {
	                center.add(new ThreeVariableColumnBlock(column));
	                center.add(Box.createRigidArea(new Dimension(10, 20)));
	            }
	        }
	        else if (table.getNumberOfVariable() == 4) {
	            for(IntermediateColumn column: container.getIntermediateColumns()) {
	                center.add(new FourVariableColumnBlock(column));
	                center.add(Box.createRigidArea(new Dimension(10, 20)));
	            }
	        }
	        
	        try {
	        	//PI Table section
	    		center.add(makeItFancy(new JLabel("PI Table")));
	    		
				PITable pi = new PITable(container, table);
				center.add(new PIBlock(pi));
                center.add(Box.createRigidArea(new Dimension(10, 20)));

				
				//Result section
	    		center.add(makeItFancy(new JLabel("Simplified expression")));

//			    String data[][]= {{pi.finalResultSOP()}};
//			    
//			    String column[]={"Result"};  
//			    
//				JTable result = new JTable(data, column);
//								
//				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//				result.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
//				result.setRowHeight(40);
				
				JPanel resultRibbon = new JPanel();
				resultRibbon.setLayout(new FlowLayout(FlowLayout.LEFT));
				
				if (pi.getValues().isEmpty()) resultRibbon.add(resultTable("0"));
				else {
					if (outputType.equals("POS")) {
						
						resultRibbon.add(resultTable(pi.finalResultPOS()));
						
					} else if(outputType.equals("SOP")) {
						
						resultRibbon.add(resultTable(pi.finalResultSOP()));
						
					}
				}
				JButton restart = new JButton("Convert again");
				restart.addActionListener(new ConvertAgainListener());
				restart.setPreferredSize(new Dimension (120, 50));
				resultRibbon.add(Box.createRigidArea(new Dimension(10, 20)));
				resultRibbon.add(restart);
			
				center.add(resultRibbon);
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
	        
//			JButton restart = new JButton("Convert again");
//			restart.addActionListener(this);
//			restart.setPreferredSize(new Dimension (120, 50));
//            center.add(Box.createRigidArea(new Dimension(10, 20)));
//			center.add(restart);
			
			return center;
			}
	private class ConvertAgainListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new ThreeVariableScreen();
			JFrame f = (JFrame) SwingUtilities.getWindowAncestor(cp);
			f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
		}
		
	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String button = e.getActionCommand();
//		if (button.equals("Convert again")) {
//			new ThreeVariableScreen(new TruthTable());
//			this.dispose();
//		}
//	}
	
}