package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ThreeVariableScreenController {

	protected JFrame stage;
	protected TruthTable table;
	protected ArrayList<String> rowValue0;
	protected ArrayList<String> rowValue1;
	protected ArrayList<String> rowValue2;
	protected ArrayList<String> rowValue3;
	protected ArrayList<String> rowValue4;
	protected ArrayList<String> rowValue5;
	protected ArrayList<String> rowValue6;
	protected ArrayList<String> rowValue7;
	
	public ThreeVariableScreenController(TruthTable table, JFrame stage) {
		
		super();
		this.table = table;
		
	}
	
    @FXML 
    public TruthTable CreateTruthTable() {
    			
		rowValue0 = new ArrayList<>(Arrays.asList("0","0","0"));
		rowValue1 = new ArrayList<>(Arrays.asList("0","0","1"));
		rowValue2 = new ArrayList<>(Arrays.asList("0","1","0"));
		rowValue3 = new ArrayList<>(Arrays.asList("0","1","1"));
		rowValue4 = new ArrayList<>(Arrays.asList("1","0","0"));
		rowValue5 = new ArrayList<>(Arrays.asList("1","0","1"));
		rowValue6 = new ArrayList<>(Arrays.asList("1","1","0"));
		rowValue7 = new ArrayList<>(Arrays.asList("1","1","1"));
		
    	if (this.row0.getSelectedToggle() == row00) {
    		rowValue0.add("0");
    	} else {this.rowValue0.add("1");}
    	
    	if (this.row1.getSelectedToggle() == row10) {
    		rowValue1.add("0");
    	} else {this.rowValue1.add("1");}
    	
    	if (this.row2.getSelectedToggle() == row20) {
    		rowValue2.add("0");
    	} else {this.rowValue2.add("1");}
    	
    	if (this.row3.getSelectedToggle() == row30) {
    		rowValue3.add("0");
    	} else {this.rowValue3.add("1");}
    	
    	if (this.row4.getSelectedToggle() == row40) {
    		rowValue4.add("0");
    	} else {this.rowValue4.add("1");}
    	
    	if (this.row5.getSelectedToggle() == row50) {
    		rowValue5.add("0");
    	} else {this.rowValue5.add("1");}
    	
    	if (this.row6.getSelectedToggle() == row60) {
    		rowValue6.add("0");
    	} else {this.rowValue6.add("1");}
    	
    	if (this.row7.getSelectedToggle() == row70) {
    		rowValue7.add("0");
    	} else {this.rowValue7.add("1");}
    	
		this.table.Table.add(rowValue0);
		this.table.Table.add(rowValue1);
		this.table.Table.add(rowValue2);
		this.table.Table.add(rowValue3);
		this.table.Table.add(rowValue4);
		this.table.Table.add(rowValue5);
		this.table.Table.add(rowValue6);
		this.table.Table.add(rowValue7);
		
		return this.table;
    }
    
    @FXML
    void btnSubmitPressed(ActionEvent event) {
    	if (this.negate.getSelectedToggle() == Negate) {
    		CreateTruthTable().NegateTable();
    		tfTruthTable.setText(String.valueOf(table.getTable()));
    	}
    	else {
      		CreateTruthTable();
    		tfTruthTable.setText(String.valueOf(table.getTable()));
    	}
    }
    
    @FXML
    private TextField tfTruthTable;

    @FXML
    private RadioButton row11;

    @FXML
    private RadioButton row31;

    @FXML
    private RadioButton row10;

    @FXML
    private Button submit;

    @FXML
    private ToggleGroup negate;

    @FXML
    private RadioButton Negate;
    
    @FXML
    private RadioButton Nope;

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