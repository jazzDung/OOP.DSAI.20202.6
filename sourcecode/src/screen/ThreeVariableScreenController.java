package screen;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import table.TruthTable;

public class ThreeVariableScreenController {

	protected TruthTable table;
	protected ArrayList<Object> rowValue0;
	protected ArrayList<Object> rowValue1;
	protected ArrayList<Object> rowValue2;
	protected ArrayList<Object> rowValue3;
	protected ArrayList<Object> rowValue4;
	protected ArrayList<Object> rowValue5;
	protected ArrayList<Object> rowValue6;
	protected ArrayList<Object> rowValue7;
	
	public ThreeVariableScreenController() {
		
		super();
		this.table = new TruthTable(3);		
	}
	
    @FXML
    void btnThreeVariablePressed(ActionEvent event) {
//    	new ThreeVariableScreen(new TruthTable());
////    	stage.dispose();
//		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(ThreeVariableScreen.fxPanel);
//    	f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }

    @FXML
    void btnFourVariablePressed(ActionEvent event) {
		new FourVariableScreen(new TruthTable(4));
//    	stage.dispose();
		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(ThreeVariableScreen.fxPanel);
    	f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }
	
//    @FXML 
//    public TruthTable CreateTruthTable() {
//    			
//		rowValue0 = new ArrayList<>(Arrays.asList("0","0","0"));
//		rowValue1 = new ArrayList<>(Arrays.asList("0","0","1"));
//		rowValue2 = new ArrayList<>(Arrays.asList("0","1","0"));
//		rowValue3 = new ArrayList<>(Arrays.asList("0","1","1"));
//		rowValue4 = new ArrayList<>(Arrays.asList("1","0","0"));
//		rowValue5 = new ArrayList<>(Arrays.asList("1","0","1"));
//		rowValue6 = new ArrayList<>(Arrays.asList("1","1","0"));
//		rowValue7 = new ArrayList<>(Arrays.asList("1","1","1"));
//		
//    	if (this.row0.getSelectedToggle() == row00) {
//    		rowValue0.add("0");
//    	} else {this.rowValue0.add("1");}
//    	
//    	if (this.row1.getSelectedToggle() == row10) {
//    		rowValue1.add("0");
//    	} else {this.rowValue1.add("1");}
//    	
//    	if (this.row2.getSelectedToggle() == row20) {
//    		rowValue2.add("0");
//    	} else {this.rowValue2.add("1");}
//    	
//    	if (this.row3.getSelectedToggle() == row30) {
//    		rowValue3.add("0");
//    	} else {this.rowValue3.add("1");}
//    	
//    	if (this.row4.getSelectedToggle() == row40) {
//    		rowValue4.add("0");
//    	} else {this.rowValue4.add("1");}
//    	
//    	if (this.row5.getSelectedToggle() == row50) {
//    		rowValue5.add("0");
//    	} else {this.rowValue5.add("1");}
//    	
//    	if (this.row6.getSelectedToggle() == row60) {
//    		rowValue6.add("0");
//    	} else {this.rowValue6.add("1");}
//    	
//    	if (this.row7.getSelectedToggle() == row70) {
//    		rowValue7.add("0");
//    	} else {this.rowValue7.add("1");}
//    	
//    	this.table.columnNames = new ArrayList<String>(Arrays.asList("A", "B", "C", "Y Value"));
//        for (int i = 0; i < 8; i ++) {
//            this.table.rowNames.add(String.valueOf(i));
//        }
//		this.table.values.add(rowValue0);
//		this.table.values.add(rowValue1);
//		this.table.values.add(rowValue2);
//		this.table.values.add(rowValue3);
//		this.table.values.add(rowValue4);
//		this.table.values.add(rowValue5);
//		this.table.values.add(rowValue6);
//		this.table.values.add(rowValue7);
//		
//		return this.table;
//    }
    
    @FXML 
    public void fillTruthTable() {
    	if (this.row0.getSelectedToggle() == row00) {table.setYValue("0", "0");} else {table.setYValue("0", "1");}
    	
    	if (this.row1.getSelectedToggle() == row10) {table.setYValue("1", "0");} else {table.setYValue("1", "1");}
    	
    	if (this.row2.getSelectedToggle() == row20) {table.setYValue("2", "0");} else {table.setYValue("2", "1");}
    	
    	if (this.row3.getSelectedToggle() == row30) {table.setYValue("3", "0");} else {table.setYValue("3", "1");}
    	
    	if (this.row4.getSelectedToggle() == row40) {table.setYValue("4", "0");} else {table.setYValue("4", "1");}
    	
    	if (this.row5.getSelectedToggle() == row50) {table.setYValue("5", "0");} else {table.setYValue("5", "1");}
    	
    	if (this.row6.getSelectedToggle() == row60) {table.setYValue("6", "0");} else {table.setYValue("6", "1");}
    	
    	if (this.row7.getSelectedToggle() == row70) {table.setYValue("7", "0");} else {table.setYValue("7", "1");}
    }
    
    @FXML
    void btnSubmitPressed(ActionEvent event) {
    	if (this.OutputType.getSelectedToggle() == POS) {
    		fillTruthTable();
    		table.NegateTable();
    		table.printTruthTable();
    		new OutputScreen(table, "POS");
    	}
    	else if (this.OutputType.getSelectedToggle() == SOP) {
      		fillTruthTable();
      		table.printTruthTable();
      		new OutputScreen(table, "SOP");
    	}
		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(ThreeVariableScreen.fxPanel);
    	f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }
    @FXML
    private RadioButton SOP;

    @FXML
    private RadioButton POS;
    
    @FXML
    private ToggleGroup OutputType;
    
    @FXML
    private Button FourVariable;
    
    @FXML
    private Button ThreeVariable;
    
    @FXML
    private RadioButton row11;

    @FXML
    private RadioButton row31;

    @FXML
    private RadioButton row10;

    @FXML
    private Button submit;

    @FXML
    private RadioButton row70;

    @FXML
    private RadioButton row51;

    @FXML
    private RadioButton row30;

    @FXML
    private RadioButton row71;

    @FXML
    private RadioButton row50;

    @FXML
    private RadioButton row00;

    @FXML
    private RadioButton row01;

    @FXML
    private ToggleGroup row1;

    @FXML
    private RadioButton row20;

    @FXML
    private RadioButton row21;

    @FXML
    private ToggleGroup row0;

    @FXML
    private ToggleGroup row7;

    @FXML
    private ToggleGroup row6;

    @FXML
    private ToggleGroup row3;

    @FXML
    private RadioButton row40;

    @FXML
    private ToggleGroup row2;

    @FXML
    private RadioButton row41;

    @FXML
    private ToggleGroup row5;

    @FXML
    private RadioButton row60;

    @FXML
    private ToggleGroup row4;

    @FXML
    private RadioButton row61;

}