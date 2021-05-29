package screen;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import table.TruthTable;

public class FourVariableScreenController {

	protected JFrame stage;
	protected TruthTable table;
	
	protected ArrayList<Object> rowValue0;
	protected ArrayList<Object> rowValue1;
	protected ArrayList<Object> rowValue2;
	protected ArrayList<Object> rowValue3;
	protected ArrayList<Object> rowValue4;
	protected ArrayList<Object> rowValue5;
	protected ArrayList<Object> rowValue6;
	protected ArrayList<Object> rowValue7;
	protected ArrayList<Object> rowValue8;
	protected ArrayList<Object> rowValue9;
	protected ArrayList<Object> rowValue10;
	protected ArrayList<Object> rowValue11;
	protected ArrayList<Object> rowValue12;
	protected ArrayList<Object> rowValue13;
	protected ArrayList<Object> rowValue14;
	protected ArrayList<Object> rowValue15;
	
	public FourVariableScreenController(TruthTable table, JFrame stage) {
		
		super();
		this.table = table;
		this.stage = stage;
		this.table.setNumberOfVariable(4);
		
	}
	
    @FXML
    void btnSubmitPressed(ActionEvent event) {
    	if (this.negate.getSelectedToggle() == Negate) {
    		CreateTruthTable().NegateTable();
    		tfTruthTable.setText(String.valueOf(table.values.toString()));
    	}
    	else {
      		CreateTruthTable();
    		tfTruthTable.setText(String.valueOf(table.values.toString()));
    	}
    }
    
    @FXML
    void btnThreeVariablePressed(ActionEvent event) {
    	new ThreeVariableScreen(new TruthTable());
    	stage.dispose();
    }

    @FXML
    void btnFourVariablePressed(ActionEvent event) {
		new FourVariableScreen(new TruthTable());
		stage.dispose();
    }
	
    @FXML 
    public TruthTable CreateTruthTable() {
    			
		rowValue0 = new ArrayList<>(Arrays.asList("0","0","0","0"));
		rowValue1 = new ArrayList<>(Arrays.asList("0","0","0","1"));
		rowValue2 = new ArrayList<>(Arrays.asList("0","0","1","0"));
		rowValue3 = new ArrayList<>(Arrays.asList("0","0","1","1"));
		rowValue4 = new ArrayList<>(Arrays.asList("0","1","0","0"));
		rowValue5 = new ArrayList<>(Arrays.asList("0","1","0","1"));
		rowValue6 = new ArrayList<>(Arrays.asList("0","1","1","0"));
		rowValue7 = new ArrayList<>(Arrays.asList("0","1","1","1"));
		rowValue8 = new ArrayList<>(Arrays.asList("1","0","0","0"));
		rowValue9 = new ArrayList<>(Arrays.asList("1","0","0","1"));
		rowValue10 = new ArrayList<>(Arrays.asList("1","0","1","0"));
		rowValue11 = new ArrayList<>(Arrays.asList("1","0","1","1"));
		rowValue12 = new ArrayList<>(Arrays.asList("1","1","0","0"));
		rowValue13 = new ArrayList<>(Arrays.asList("1","1","0","1"));
		rowValue14 = new ArrayList<>(Arrays.asList("1","1","1","0"));
		rowValue15 = new ArrayList<>(Arrays.asList("1","1","1","1"));
		
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
    	if (this.row8.getSelectedToggle() == row80) {
    		rowValue8.add("0");
    	} else {this.rowValue8.add("1");}
    	if (this.row9.getSelectedToggle() == row90) {
    		rowValue9.add("0");
    	} else {this.rowValue11.add("1");}
    	if (this.rowten.getSelectedToggle() == row100) {
    		rowValue10.add("0");
    	} else {this.rowValue10.add("1");}
    	if (this.roweleven.getSelectedToggle() == row110) {
    		rowValue11.add("0");
    	} else {this.rowValue11.add("1");}
    	if (this.row12.getSelectedToggle() == row120) {
    		rowValue12.add("0");
    	} else {this.rowValue12.add("1");}
    	if (this.row13.getSelectedToggle() == row130) {
    		rowValue13.add("0");
    	} else {this.rowValue13.add("1");}
    	if (this.row14.getSelectedToggle() == row140) {
    		rowValue14.add("0");
    	} else {this.rowValue14.add("1");}
    	if (this.row15.getSelectedToggle() == row150) {
    		rowValue15.add("0");
    	} else {this.rowValue15.add("1");}
    	
		this.table.values.add(rowValue0);
		this.table.values.add(rowValue1);
		this.table.values.add(rowValue2);
		this.table.values.add(rowValue3);
		this.table.values.add(rowValue4);
		this.table.values.add(rowValue5);
		this.table.values.add(rowValue6);
		this.table.values.add(rowValue7);
		this.table.values.add(rowValue8);
		this.table.values.add(rowValue9);
		this.table.values.add(rowValue10);
		this.table.values.add(rowValue11);
		this.table.values.add(rowValue12);
		this.table.values.add(rowValue13);
		this.table.values.add(rowValue14);
		this.table.values.add(rowValue15);
		
		return this.table;
    }

    @FXML
    private RadioButton row11;

    @FXML
    private ToggleGroup row12;

    @FXML
    private RadioButton row10;
    
    @FXML
    private ToggleGroup rowten;

    @FXML
    private ToggleGroup roweleven;

    @FXML
    private RadioButton row101;

    @FXML
    private ToggleGroup row15;

    @FXML
    private ToggleGroup row13;

    @FXML
    private ToggleGroup row14;

    @FXML
    private TextField tfTruthTable;

    @FXML
    private RadioButton row140;

    @FXML
    private RadioButton row91;

    @FXML
    private RadioButton row90;

    @FXML
    private RadioButton row51;

    @FXML
    private RadioButton row100;

    @FXML
    private RadioButton row50;

    @FXML
    private RadioButton row141;

    @FXML
    private ToggleGroup OutputType;

    @FXML
    private RadioButton row00;

    @FXML
    private RadioButton row01;

    @FXML
    private ToggleGroup row1;

    @FXML
    private ToggleGroup row0;

    @FXML
    private ToggleGroup row7;

    @FXML
    private RadioButton row80;

    @FXML
    private RadioButton row151;

    @FXML
    private ToggleGroup row6;

    @FXML
    private RadioButton row150;

    @FXML
    private RadioButton row81;

    @FXML
    private ToggleGroup row9;

    @FXML
    private ToggleGroup row8;

    @FXML
    private ToggleGroup row3;

    @FXML
    private RadioButton row40;

    @FXML
    private RadioButton row111;

    @FXML
    private ToggleGroup row2;

    @FXML
    private RadioButton row41;

    @FXML
    private RadioButton row110;

    @FXML
    private ToggleGroup row5;

    @FXML
    private ToggleGroup row4;

    @FXML
    private RadioButton Nope;

    @FXML
    private RadioButton POS;

    @FXML
    private RadioButton row31;

    @FXML
    private ToggleGroup row75;

    @FXML
    private Button ThreeVariable;

    @FXML
    private Button submit;

    @FXML
    private Button FourVariable;

    @FXML
    private RadioButton row70;

    @FXML
    private RadioButton row30;

    @FXML
    private ToggleGroup row74;

    @FXML
    private RadioButton row121;

    @FXML
    private RadioButton row71;

    @FXML
    private RadioButton row120;

    @FXML
    private RadioButton row20;

    @FXML
    private RadioButton row21;

    @FXML
    private RadioButton row60;

    @FXML
    private RadioButton row131;

    @FXML
    private RadioButton row61;

    @FXML
    private RadioButton row130;

    @FXML
    private RadioButton SOP;

    @FXML
    private ToggleGroup negate;

    @FXML
    private RadioButton Negate;

}